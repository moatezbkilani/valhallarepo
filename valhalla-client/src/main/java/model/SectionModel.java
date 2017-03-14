package model;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;

import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote;

public class SectionModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Section> sections;
	String[] col = { "id", "Picture", "Name", "Description", "IdService", "Service" };

	public SectionModel() throws NamingException {
		Context context = new InitialContext();
		SectionsServicesRemote serviceServicesRemote = (SectionsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
		sections = serviceServicesRemote.findAllSectionsNonRemoved();
	}

	public int getRowCount() {
		return sections.size();
	}

	public int getColumnCount() {
		return col.length;
	}

	public String getColumnName(int column) {
		return col[column]; // To change body of generated methods, choose Tools
							// | Templates.
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		// case 0 : return ar.get(rowIndex).getId();
		case 0:
			return sections.get(rowIndex).getId();
		case 1:
			return sections.get(rowIndex).getImage();
		case 2:
			return sections.get(rowIndex).getSectionName();
		case 3:
			return sections.get(rowIndex).getDescription();
		case 4:
			return sections.get(rowIndex).getService().getId();

		case 5:
			return sections.get(rowIndex).getService().getServiceName();

		}
		return null;
	}

}
