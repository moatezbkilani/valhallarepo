package tn.esprit.bzbz.valhalla.services.sections;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;

/**
 * Session Bean implementation class SectionsServices
 */
@Stateless
public class SectionsServices implements SectionsServicesRemote, SectionsServicesLocal {
	@PersistenceContext
	EntityManager entityManager;
	
	@EJB private ServiceServicesRemote serviceServicesRemote;
    /**
     * Default constructor. 
     */
    public SectionsServices() {
        // TODO Auto-generated constructor stub
    }
    
    public Service findService(Integer id) {
        return serviceServicesRemote.findServiceById(id);
    }
    
    @Override
    public Boolean createSection(Integer serviceId, String sectionName,String description, String image, String state)
    {
    	Service parentService = this.findService(serviceId);
    	if(parentService != null){
    		Section section = new Section(sectionName,description,image,state,parentService);
    		entityManager.persist(section);
    		return true;
    	}
    	return false;
    }
    
    @Override
    public Boolean deleteSection(Integer sectionId)
    {
    	Section sectionToDelete = this.findSectionById(sectionId);
    	if(sectionToDelete != null){
    		entityManager.merge(sectionToDelete);
    		entityManager.remove(sectionToDelete);
    		return true;
    	}
    	return false;
    }
    
    @Override
	public Section findSectionById(Integer id) {
		try {
			return (Section) entityManager.createQuery("select s from Section s where s.id LIKE :sectName")
					.setParameter("sectName", id).getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
    
    @Override
	public Boolean updateSection(Integer sectionId, String name, String description, String image,Integer newServiceId) {
		Section sectionToUpdate = this.findSectionById(sectionId);
    	Service newParentService = this.findService(newServiceId);

		if (sectionToUpdate != null) {
			if (!name.equals(""))
				sectionToUpdate.setSectionName(name);
			if (!description.equals(""))
				sectionToUpdate.setDescription(description);
			if (!image.equals(""))
				sectionToUpdate.setImage(image);
			if((newServiceId != null) && (newParentService != null))
				sectionToUpdate.setService(newParentService);
			entityManager.merge(sectionToUpdate);
			entityManager.persist(sectionToUpdate);
			return true;
		}
		return false;
	}
    
    @Override
	public List<Section> findSectionsByService(Service service) {
		try {
			return (List<Section>) entityManager.createQuery("select s from Section s where s.service LIKE :servId")
					.setParameter("servId", service).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
    
    @Override
	public List<Section> findSectionsByServiceId(Integer serviceId) {
		try {
			return (List<Section>) entityManager.createQuery("select s from Section s where s.service.id LIKE :servId")
					.setParameter("servId", serviceId).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}
    
    @Override
	public List<Section> findAllSections() {
		try {
			return (List<Section>) entityManager.createQuery("select s from Section s")
					.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

}
