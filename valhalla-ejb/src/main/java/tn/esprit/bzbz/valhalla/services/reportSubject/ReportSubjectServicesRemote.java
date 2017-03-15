package tn.esprit.bzbz.valhalla.services.reportSubject;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Subject;

@Remote
public interface ReportSubjectServicesRemote {

	List<ReportSubject> findAllReportedSubject();

	List<ReportSubject> findAllReportedSubjectBySection(Integer id);

	List<ReportSubject> findAllReportedSubjectByService(Integer id);

	Set<Subject> findSubject();

	Long findNumberReportSubject(Integer id);

	List<ReportSubject> findAllReportedSubjectBySubject(Integer id);

	Set<Subject> findSubjectBySection(Integer id);

	Set<Subject> findSubjectByService(Integer id);

}
