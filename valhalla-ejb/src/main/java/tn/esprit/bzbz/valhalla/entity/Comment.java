package tn.esprit.bzbz.valhalla.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tn.esprit.bzbz.valhalla.entity.embeddable.CommentId;

/**
 * Entity implementation class for Entity: Comment
 *
 */
@Entity

public class Comment implements Serializable {

	@EmbeddedId
	private CommentId commentId;
	private String content;

	@ElementCollection
	private Map<User, CommentReport> mapOfReport = new HashMap<User, CommentReport>();

	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "id", updatable = false, insertable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "subjectId", referencedColumnName = "id", updatable = false, insertable = false)
	private Subject subject;

	public Comment(String content, User user, Subject subject) {
		super();
		this.commentId = new CommentId(user.getId(), subject.getId());
		this.content = content;
		this.user = user;
		this.subject = subject;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
	}

	public CommentId getCommentId() {
		return commentId;
	}

	public void setCommentId(CommentId commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Map<User, CommentReport> getMapOfReport() {
		return mapOfReport;
	}

	public void setMapOfReport(Map<User, CommentReport> mapOfReport) {
		this.mapOfReport = mapOfReport;
	}
}
