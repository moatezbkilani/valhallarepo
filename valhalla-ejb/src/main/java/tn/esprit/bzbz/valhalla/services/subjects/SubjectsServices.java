package tn.esprit.bzbz.valhalla.services.subjects;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;

/**
 * Session Bean implementation class SubjectsServices
 */
@Stateless
public class SubjectsServices implements SubjectsServicesRemote, SubjectsServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public SubjectsServices() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<ReportSubject> findAllReportedSubjects() {
		return entityManager.createQuery("select rs from ReportSubject rs").getResultList();

	}

	@Override
	public List<ReportSubject> findReportedSubjectsInSection(Section section) {
		return entityManager.createQuery("select rs from ReportSubject rs where rs.subject.section LIKE :se")
				.setParameter("se", section).getResultList();
	}

	@Override
	public void saveOrUpdateSubject(Subject subject) {
		entityManager.merge(subject);

	}

	@Override
	public void lockSubject(Integer id) {
		Subject subject = findSubjectById(id);
		subject.setState("Locked");
		entityManager.merge(subject);

	}

	@Override
	public void removeSubject(Integer id) {
		Subject subject = findSubjectById(id);
		subject.setState("Removed");
		entityManager.merge(subject);

	}

	@Override
	public Subject findSubjectById(int i) {
		return entityManager.find(Subject.class, i);
	}

	@Override
	public Long getNumberSubject() {
		return (Long) entityManager.createQuery("select count(c) from Subject c").getSingleResult();
	}

	@Override
	public Long numberSubject(Service service) {
		return (Long) entityManager.createQuery("select count(c) from Subject c where c.section.service LIKE :p")
				.setParameter("p", service).getSingleResult();
	}

	@Override
	public Long numberTotalSubjects() {
		return (Long) entityManager.createQuery("select count(c) from Subject c").getSingleResult();
	}

}
