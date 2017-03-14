package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote;

public class CommentsTest {

	public static void main(String[] args) throws NamingException {
		Context context = new InitialContext();
		CommentsServicesRemote sisr = (CommentsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");

		List<Long> l = sisr.getNumberCommentsPerMonthFrom3YearsAgor();
		for (Long i : l) {
			System.out.println(i);
		}
		/*
		 * UserServicesRemote userServicesRemote = (UserServicesRemote)
		 * context.lookup(
		 * "valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote"
		 * ); SubjectsServicesRemote subjectServicesRemote =
		 * (SubjectsServicesRemote) context.lookup(
		 * "valhalla-ear/valhalla-ejb/SubjectServices!tn.esprit.bzbz.valhalla.services.subject.SubjectServicesRemote"
		 * );
		 * 
		 * User user = userServicesRemote.findById(1);
		 * 
		 * Subject subject = subjectServicesRemote.findSubjectById(1);
		 * 
		 * sisr.saveOrUpdateComment("abc", user, subject);
		 */
	}

}
