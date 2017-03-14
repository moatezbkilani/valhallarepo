package tn.esprit.bzbz.valhalla.services.comments;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.bzbz.valhalla.entity.Comment;
import tn.esprit.bzbz.valhalla.entity.CommentReport;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.entity.embeddable.CommentId;

@Local
public interface CommentsServicesLocal {
	Long getNumberComments();

	void saveOrUpdateComment(String content, User user, Subject subject);

	Comment findCommentById(CommentId commentId);

	void reportComment(User user, CommentId commentId, CommentReport commentReport);

	Long numberComments(Service service);

	Long numberTotalComments();

	List<Long> getNumberCommentsFromJanvier();

	List<Long> getNumberCommentsPerMonthFrom3YearsAgor();
}
