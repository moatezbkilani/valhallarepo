package tn.esprit.bzbz.valhalla.services.subjects;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;

@Remote
public interface SubjectsServicesRemote {
	List<ReportSubject> findAllReportedSubjects();

	List<ReportSubject> findReportedSubjectsInSection(Section section);

	Long getNumberSubject();

	Subject findSubjectById(int i);
	void saveOrUpdateSubject(Subject subject);

	Long numberSubject(Service service);

	Long numberTotalSubjects();

	void removeSubject(Integer id);

	void lockSubject(Integer id);
}
