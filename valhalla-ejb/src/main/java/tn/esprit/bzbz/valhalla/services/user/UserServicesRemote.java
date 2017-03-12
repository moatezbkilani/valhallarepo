package tn.esprit.bzbz.valhalla.services.user;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.User;

@Remote
public interface UserServicesRemote {
	User findByEmail(String email);

	void banUser(Integer id);

	User findById(Integer id);

	public void updateUser(User user);

	List<User> findAllUser();

	void downgradeModerator(Integer id);
	
	void upgradeUser ( Integer id);
}
