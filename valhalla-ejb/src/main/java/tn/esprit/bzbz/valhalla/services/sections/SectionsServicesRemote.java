package tn.esprit.bzbz.valhalla.services.sections;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;

@Remote
public interface SectionsServicesRemote {
	
	Boolean createSection(Integer serviceId, String sectionName, String description, String image, String state);

	Boolean deleteSection(Integer sectionId);
	
	Section findSectionById(Integer id);
	
	Boolean updateSection(Integer sectionId, String name, String description, String image,Integer serviceId);
	
	List<Section> findSectionsByService(Service service);
	
	List<Section> findSectionsByServiceId(Integer serviceId);
	
	List<Section> findAllSections();
}
