package model;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class UserModel extends AbstractTableModel {
	List<User> users;
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	String[] col = { "id", "Username", "State", "Role" };

	public UserModel() throws NamingException {

		try {

			Context context = new InitialContext();
			UserServicesRemote UserServicesRemote = (UserServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
			users = UserServicesRemote.findAllUser();
		} catch (NamingException ex) {
			System.out.println(ex);
		}

	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		// throw new UnsupportedOperationException("Not supported yet."); //To
		// change body of generated methods, choose Tools | Templates.

		return col.length;
	}

	@Override
	public String getColumnName(int column) {
		return col[column]; // To change body of generated methods, choose Tools
							// | Templates.
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return users.get(rowIndex).getId();
		case 1:
			return users.get(rowIndex).getUsername();
		case 2:
			return users.get(rowIndex).getState();
		case 3:
			return users.get(rowIndex).getRole();

		}
		return null;
	}
}
