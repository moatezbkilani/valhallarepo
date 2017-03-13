package tests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote;

public class SectionsTests {

	public static void main(String[] args)throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		SectionsServicesRemote sectionServicesRemote = (SectionsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
		//System.out.println(sectionServicesRemote.createSection(1, "section service 1", "description", "image", "state"));
		//sectionServicesRemote.deleteSection(2);
		//sectionServicesRemote.updateSection(2, "test", "", "", null);
		List<Section> sections = sectionServicesRemote.findSectionsByServiceId(1);
		for(Section s:sections){
			System.out.println(s.getId()+" "+s.getSectionName());
		}
	}

}
