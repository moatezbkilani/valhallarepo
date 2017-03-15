package model;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote;

public class ReportedSubjectUserModel extends AbstractTableModel {
	List<ReportSubject> res;

	String[] col = { "Date", "User", "Reason" };

	public ReportedSubjectUserModel(Integer id) throws NamingException {
		Context context = new InitialContext();
		ReportSubjectServicesRemote serviceServicesRemote = (ReportSubjectServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ReportSubjectServices!tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote");
		res = serviceServicesRemote.findAllReportedSubjectBySubject(id);

	}

	public int getRowCount() {
		return res.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		// case 0 : return ar.get(rowIndex).getId();
		case 0:
			return res.get(rowIndex).getDate();
		case 1:
			return res.get(rowIndex).getUser().getUsername();
		case 2:
			return res.get(rowIndex).getReason();

		}
		return null;

	}

	public String getColumnName(int column) {
		return col[column]; // To change body of generated methods, choose Tools
							// | Templates.
	}

}
