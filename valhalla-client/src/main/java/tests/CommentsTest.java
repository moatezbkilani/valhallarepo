package tests;

import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote;
import tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class CommentsTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommentsServicesRemote sisr = (CommentsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");
		Date startDate = new Date();
		startDate.setDate(20);
		Date endDate = new Date();
		endDate.setDate(29);
		List<Long> l = sisr.getNumberCommentsFromJanvier();
		for (Long i : l) {
			System.out.println(i);
		}

		UserServicesRemote userServicesRemote = (UserServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
		SubjectsServicesRemote subjectServicesRemote = (SubjectsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SubjectServices!tn.esprit.bzbz.valhalla.services.subject.SubjectServicesRemote");

		CommentsServicesRemote commentServicesRemote = (CommentsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/CommentServices!tn.esprit.bzbz.valhalla.services.comment.CommentServicesRemote");
		User user = userServicesRemote.findById(1);

		Subject subject = subjectServicesRemote.findSubjectById(1);

		commentServicesRemote.saveOrUpdateComment("abc", user, subject);

	}

}
