package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class PrivateMessageTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		UserServicesRemote usr = (UserServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
		Context context1 = new InitialContext();
		PrivateMessageServicesRemote pr = (PrivateMessageServicesRemote) context1.lookup(
				"valhalla-ear/valhalla-ejb/PrivateMessageServices!tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote");

		User usr1 = usr.findById(1);
		User usr2 = usr.findById(2);
		User usr3 = usr.findById(3);

		 pr.sendPrivateMessage(usr1, usr2, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		 pr.sendPrivateMessage(usr2, usr1, "BBBBBBBBBBBBBBBBBBBBBBBBBBBB");

		// pr.sendPrivateMessage(usr3, usr1, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		pr.sendPrivateMessage(usr2, usr3, "AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

		/*
		 * Set<User> usersList = pr.findConversations(usr3); for(User u :
		 * usersList){ System.out.println(u.getId()+" "+u.getEmail()); }
		 */

		// System.out.println(pr.deleteConversation(usr1, usr2));
		List<Message> messagesList = pr.findMessages(usr1, usr2);
		if (messagesList != null)
			for (Message m : messagesList) {
				System.out.println(m.getUserOne().getId() + ": " + m.getContent());
			}
	}

}
