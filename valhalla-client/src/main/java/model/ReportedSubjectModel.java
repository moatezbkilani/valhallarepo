package model;

import java.util.Set;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote;

public class ReportedSubjectModel extends AbstractTableModel {
	Set<Subject> res;

	String[] col = { "id", "Name", "Number of report", "State" };

	public ReportedSubjectModel() throws NamingException {
		Context context = new InitialContext();
		ReportSubjectServicesRemote serviceServicesRemote = (ReportSubjectServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ReportSubjectServices!tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote");
		res = serviceServicesRemote.findSubject();

	}

	public ReportedSubjectModel(Integer id) throws NamingException {
		Context context = new InitialContext();
		ReportSubjectServicesRemote serviceServicesRemote = (ReportSubjectServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ReportSubjectServices!tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote");
		res = serviceServicesRemote.findSubjectByService(id);

	}

	public ReportedSubjectModel(Integer id, Integer e) throws NamingException {
		Context context = new InitialContext();
		ReportSubjectServicesRemote serviceServicesRemote = (ReportSubjectServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ReportSubjectServices!tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote");
		res = serviceServicesRemote.findSubjectBySection(id);

	}

	public int getRowCount() {
		return res.size();
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return col.length;
	}

	public Subject methode(Integer i) {

		Integer j = 0;
		for (Subject s : res) {
			if (j == i) {
				return s;
			}
			j++;
		}
		return null;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		// case 0 : return ar.get(rowIndex).getId();
		case 0: {

			return methode(rowIndex).getId();
		}
		case 1:
			return methode(rowIndex).getSubjectName();
		case 3:
			return methode(rowIndex).getState();
		case 2: {
			Context context;
			try {
				context = new InitialContext();
				ReportSubjectServicesRemote serviceServicesRemote = (ReportSubjectServicesRemote) context.lookup(
						"valhalla-ear/valhalla-ejb/ReportSubjectServices!tn.esprit.bzbz.valhalla.services.reportSubject.ReportSubjectServicesRemote");
				return serviceServicesRemote.findNumberReportSubject(methode(rowIndex).getId());
			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		}
		return null;

	}

	public String getColumnName(int column) {
		return col[column]; // To change body of generated methods, choose Tools
							// | Templates.
	}

}
