package tn.esprit.bzbz.valhalla.services.comments;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Comment;
import tn.esprit.bzbz.valhalla.entity.CommentReport;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.entity.embeddable.CommentId;

@Remote
public interface CommentsServicesRemote {
	Long getNumberComments();

	Long getNumberCommentsInDate(Date startDate, Date endDate);


	List<Long> getNumberCommentsPerMonthFrom3YearsAgor();
	Comment findCommentById(CommentId commentId);
	void reportComment(User user, CommentId commentId, CommentReport commentReport);
	Long numberComments(Service service);
	void saveOrUpdateComment(String content, User user, Subject subject);
	Long numberTotalComments();

	List<Long> getNumberCommentsFromJanvier();
}
