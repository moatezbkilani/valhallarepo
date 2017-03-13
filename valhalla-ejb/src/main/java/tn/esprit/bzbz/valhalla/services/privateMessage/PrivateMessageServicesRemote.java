package tn.esprit.bzbz.valhalla.services.privateMessage;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.User;

@Remote
public interface PrivateMessageServicesRemote {
	void sendPrivateMessage(User userOne, User userTwo, String content);

	List<Message> findSentMessages(User user);
	
	List<Message> findReceivedMessages(User user);
	
	Set<User> findConversations(User user);
	
	List<Message> findMessages(User sessionUser, User secondParty);
	
	Boolean deleteConversation (User sessionUser,User secondParty);
}
