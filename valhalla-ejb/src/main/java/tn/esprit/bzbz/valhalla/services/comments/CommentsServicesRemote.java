package tn.esprit.bzbz.valhalla.services.comments;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface CommentsServicesRemote {
	Long getNumberComments();

	Long getNumberCommentsInDate(Date startDate, Date endDate);

	List<Long> getNumberCommentsFromJanvier();

	
}
