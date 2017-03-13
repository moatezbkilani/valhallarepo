package tn.esprit.bzbz.valhalla.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.bzbz.valhalla.entity.embeddable.MessageId;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity

public class Message implements Serializable {
	@EmbeddedId
	private MessageId messageId;
	private String content;

	public MessageId getMessageId() {
		return messageId;
	}

	public void setMessageId(MessageId messageId) {
		this.messageId = messageId;
	}

	public User getUserOne() {
		return userOne;
	}

	public void setUserOne(User userOne) {
		this.userOne = userOne;
	}

	public User getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(User userTwo) {
		this.userTwo = userTwo;
	}

	@ManyToOne
	@JoinColumn(name = "userOneId", referencedColumnName = "id", updatable = false, insertable = false)
	private User userOne;

	@ManyToOne
	@JoinColumn(name = "userTwoId", referencedColumnName = "id", updatable = false, insertable = false)
	private User userTwo;

	private static final long serialVersionUID = 1L;

	public Message() {
		super();
	}

	public Message(String content, User userOne, User userTwo) {
		super();
		this.messageId = new MessageId(userOne.getId(), userTwo.getId());
		this.content = content;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
