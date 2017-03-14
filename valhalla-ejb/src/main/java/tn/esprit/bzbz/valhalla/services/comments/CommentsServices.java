package tn.esprit.bzbz.valhalla.services.comments;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Comment;
import tn.esprit.bzbz.valhalla.entity.CommentReport;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.entity.embeddable.CommentId;

/**
 * Session Bean implementation class CommentsServices
 */
@Stateless
public class CommentsServices implements CommentsServicesRemote, CommentsServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public CommentsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getNumberComments() {
		return (Long) entityManager.createQuery("select count(c) from Comment c").getSingleResult();
	}

	@Override
	public Long getNumberCommentsInDate(Date startDate, Date endDate) {
		return (Long) entityManager
				.createQuery("select count(c) from Comment c where c.commentId.date between :startdate and :enddate")
				.setParameter("startdate", startDate).setParameter("enddate", endDate).getSingleResult();
	}

	@Override
	public void saveOrUpdateComment(String content, User user, Subject subject) {
		Comment comment = new Comment(content, user, subject);
		entityManager.merge(comment);

	}

	@Override
	public void reportComment(User user, CommentId commentId, CommentReport commentReport) {
		Comment comment = findCommentById(commentId);
		comment.getMapOfReport().put(user, commentReport);

		entityManager.merge(comment);

	}

	@Override
	public Long numberTotalComments() {
		return (Long) entityManager.createQuery("select count(u) from Comment u").getSingleResult();
	}

	@Override
	public Long numberComments(Service service) {
		return (Long) entityManager
				.createQuery("select count(u) from Comment u where u.subject.section.service LIKE :a")
				.setParameter("a", service).getSingleResult();
	}

	@Override
	public Comment findCommentById(CommentId commentId) {
		return entityManager.find(Comment.class, commentId);
	}

	@Override
	public List<Long> getNumberCommentsFromJanvier() {
		List<Long> listeretour = new ArrayList<Long>();
		Date date = new Date();
		System.out.println(date.getMonth());
		int i, j = date.getMonth();

		for (i = 0; i <= j; i++) {

			Date datef = new Date();
			datef.setDate(1);
			datef.setMonth(i + 1);
			datef.setHours(0);
			datef.setSeconds(0);
			datef.setMinutes(0);
			Date dated = new Date();
			dated.setDate(1);
			dated.setMonth(i);
			dated.setHours(0);
			dated.setSeconds(0);
			dated.setMinutes(0);
			System.out.println(getNumberCommentsInDate(dated, datef));

			listeretour.add(getNumberCommentsInDate(dated, datef));
			System.out.println(listeretour.get(i));
		}
		return listeretour;
	}
}
