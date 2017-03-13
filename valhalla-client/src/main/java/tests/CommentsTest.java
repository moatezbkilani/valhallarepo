package tests;

import java.util.Date;
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
		Date startDate = new Date();
		startDate.setDate(20);
		Date endDate = new Date();
		endDate.setDate(29);
		List<Long> l = sisr.getNumberCommentsFromJanvier();
		for (Long i : l) {
			System.out.println(i);
		}

	}

}
