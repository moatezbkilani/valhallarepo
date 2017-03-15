package tn.esprit.bzbz.valhalla.services.reportSubject;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Subject;

/**
 * Session Bean implementation class ReportSubjectServices
 */
@Stateless
public class ReportSubjectServices implements ReportSubjectServicesRemote, ReportSubjectServicesLocal {

	@PersistenceContext
	EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public ReportSubjectServices() {

	}

	@Override
	public List<ReportSubject> findAllReportedSubject() {
		try {

			return (List<ReportSubject>) entityManager.createQuery("select s from ReportSubject s ").getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public Set<Subject> findSubject() {
		try {
			Set<Subject> ss = new HashSet<Subject>();
			List<ReportSubject> rs = findAllReportedSubject();
			for (ReportSubject r : rs) {
				ss.add(r.getSubject());

			}
			return ss;
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}

	@Override
	public Set<Subject> findSubjectByService(Integer id) {
		try {
			Set<Subject> ss = new HashSet<Subject>();
			List<ReportSubject> rs = findAllReportedSubjectByService(id);
			for (ReportSubject r : rs) {
				ss.add(r.getSubject());

			}
			return ss;
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}

	@Override
	public Set<Subject> findSubjectBySection(Integer id) {
		try {
			Set<Subject> ss = new HashSet<Subject>();
			List<ReportSubject> rs = findAllReportedSubjectBySection(id);
			for (ReportSubject r : rs) {
				ss.add(r.getSubject());

			}
			return ss;
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}

	}

	@Override
	public Long findNumberReportSubject(Integer id) {
		return (Long) entityManager.createQuery("select count(s) from ReportSubject s where s.subject.id like :p")
				.setParameter("p", id).getSingleResult();
	}

	@Override
	public List<ReportSubject> findAllReportedSubjectByService(Integer id) {
		try {
			return (List<ReportSubject>) entityManager
					.createQuery("select s from ReportSubject s where s.subject.section.service.id like :p")
					.setParameter("p", id).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public List<ReportSubject> findAllReportedSubjectBySubject(Integer id) {
		try {
			return (List<ReportSubject>) entityManager
					.createQuery("select s from ReportSubject s where s.subject.id like :p").setParameter("p", id)
					.getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

	@Override
	public List<ReportSubject> findAllReportedSubjectBySection(Integer id) {
		try {
			return (List<ReportSubject>) entityManager
					.createQuery("select s from ReportSubject s where s.subject.section.id like :p")
					.setParameter("p", id).getResultList();
		} catch (NoResultException e) {
			return null;
		} catch (NullPointerException e) {
			return null;
		}
	}

}
