package tn.esprit.bzbz.valhalla.services.comments;

import javax.ejb.Local;

@Local
public interface CommentsServicesLocal {
	Long getNumberComments();
}
