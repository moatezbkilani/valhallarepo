package tn.esprit.bzbz.valhalla.services.privateMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.User;

/**
 * Session Bean implementation class PrivateMessageServices
 */
@Stateless
public class PrivateMessageServices implements PrivateMessageServicesRemote, PrivateMessageServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;
	@Resource(name = "java:jboss/mail/Gmail")
	private Session session;

	/**
	 * Default constructor.
	 */
	public PrivateMessageServices() {

	}

	@Override
	public void sendPrivateMessage(User userOne, User userTwo, String content) {
		Message messagetosend = new Message(content, userOne, userTwo);
		entityManager.persist(messagetosend);
		javax.mail.Message message = new MimeMessage(session);

		try {
			message.setRecipients(javax.mail.Message.RecipientType.TO,
					InternetAddress.parse(userTwo.getEmail(), false));
			message.setSubject("Nouveau message sur Valhalla");
			message.setText("Vous avez recu un nouveau message de " + userOne.getUsername() + "sur le Valhalla forum");
			Transport.send(message);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> findSentMessages(User user) {
		try {
			return entityManager.createQuery("select m from Message m where m.userOne LIKE :user")
					.setParameter("user", user).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public List<Message> findReceivedMessages(User user) {
		try {
			return entityManager.createQuery("select m from Message m where m.userTwo LIKE :user")
					.setParameter("user", user).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	public Set<User> findConversations(User user){
		List<Message> sentMessages = this.findSentMessages(user);
		List<Message> receivedMessages = this.findReceivedMessages(user);
		Set<User> secondParty = new HashSet<User>();
		if(sentMessages != null)
			for(Message m : sentMessages ){
				secondParty.add(m.getUserTwo());
			}
		if(receivedMessages != null)
			for(Message m : receivedMessages ){
				secondParty.add(m.getUserOne());
			}
		//Set<User> s = new HashSet(secondParty);
		return secondParty;
	}
	
	public List<Message> findMessages(User sessionUser,User secondParty){
		try {
			Query q = entityManager.createQuery("select m from Message m where (m.userOne LIKE :lowel AND m.userTwo LIKE :theni) OR (m.userOne LIKE :theni AND m.userTwo LIKE :lowel) ORDER BY m.messageId.date ASC");
			q.setParameter("lowel", sessionUser);
			q.setParameter("theni", secondParty);
			return (List<Message>) q.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
	
	public Boolean deleteConversation (User sessionUser,User secondParty){
		List<Message> messages = this.findMessages(sessionUser, secondParty);
		if(messages != null){
			for(Message m : messages){
				entityManager.merge(m);
				entityManager.remove(m);
			}
			return true;
		}
		return false;
	}

}
