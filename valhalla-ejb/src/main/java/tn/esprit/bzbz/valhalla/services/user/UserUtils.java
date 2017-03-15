package tn.esprit.bzbz.valhalla.services.user;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.bzbz.valhalla.entity.Comment;
import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.ReportSubject;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.Subject;
import tn.esprit.bzbz.valhalla.entity.User;

@Singleton
@LocalBean
@Startup
public class UserUtils {
	@PersistenceContext
	private EntityManager entityManager;

	public UserUtils() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void initDb() {
		User user = new User();
		// user.setId(1);
		user.setUsername("MBK1");
		user.setPassword("mbk");
		user.setFirstName("Moatez");
		user.setLastName("Ben Kilani");
		user.setEmail("moatez.benkilani@esprit.tn");
		user.setImage("moatez.jpg");
		entityManager.persist(user);
		User user2 = new User();
		// user2.setId(2);
		user2.setUsername("wala");
		user2.setPassword("zargouni");
		user2.setFirstName("Wala");
		user2.setLastName("Zargouni");
		user2.setImage("wala.jpg");
		user2.setEmail("wala.zargouni@esprit.tn");
		entityManager.persist(user2);
		User user3 = new User();
		// user2.setId(2);
		user3.setUsername("riadh");
		user3.setPassword("mrz");
		user3.setFirstName("Riadh");
		user3.setLastName("Zrig");
		user3.setEmail("mohamedriadh.zrig@esprit.tn");
		user3.setImage("riadh.jpg");
		entityManager.persist(user3);
		User user4 = new User();
		// user2.setId(2);
		user4.setUsername("raouf");
		user4.setPassword("raouf");
		user4.setFirstName("Raouf");
		user4.setLastName("Ben Fadhel");
		user4.setEmail("raouf.benfadhel@esprit.tn");
		user4.setImage("raouf.jpg");
		entityManager.persist(user4);
		Service service1 = new Service();
		Service service2 = new Service();
		Service service3 = new Service();
		service1.setDescription("Sport");
		service1.setServiceName("Sport");
		service2.setDescription("Cinema");
		service2.setServiceName("Cinema");
		service3.setDescription("Gaming");
		service3.setServiceName("Gaming");
		
		entityManager.persist(service1);
		entityManager.persist(service2);
		entityManager.persist(service3);
		Section section1 = new Section();
		section1.setDescription("Foot");
		section1.setSectionName("Foot");
		section1.setService(service1);
		entityManager.persist(section1);
		Section section2 = new Section();
		section2.setDescription("Thril");
		section2.setSectionName("Thril");
		section2.setService(service2);
		entityManager.persist(section2);
		Section section3 = new Section();
		section3.setDescription("Rom");
		section3.setSectionName("Rom");
		section3.setService(service2);
		entityManager.persist(section3);
		Section section4 = new Section();
		section4.setDescription("FPS");
		section4.setSectionName("FPS");
		section4.setService(service3);
		entityManager.persist(section4);
		Subject subject1 = new Subject();
		subject1.setSection(section1);
		subject1.setSubjectName("Allo j'aime le foot");
		subject1.setUser(user);
		entityManager.persist(subject1);
		Subject subject2 = new Subject();
		subject2.setSection(section1);
		subject2.setSubjectName("Allo j'aime le football");
		subject2.setUser(user2);
		entityManager.persist(subject2);
		Subject subject3 = new Subject();
		subject3.setSection(section2);
		subject3.setSubjectName("Allo j'aime le thrill");
		subject3.setUser(user);
		entityManager.persist(subject3);
		Subject subject4 = new Subject();
		subject4.setSection(section2);
		subject4.setSubjectName("Allo j'aime le Thriller");
		subject4.setUser(user3);
		entityManager.persist(subject4);
		Subject subject5 = new Subject();
		subject5.setSection(section4);
		subject5.setSubjectName("Allo j'aime lol");
		subject5.setUser(user);
		entityManager.persist(subject5);

		ReportSubject rs1 = new ReportSubject(user3, subject1, "OK");
		entityManager.persist(rs1);
		ReportSubject rs2 = new ReportSubject(user, subject1, "OK");
		entityManager.persist(rs2);
		ReportSubject rs3 = new ReportSubject(user2, subject3, "OK");

		entityManager.persist(rs3);
		ReportSubject rs4 = new ReportSubject(user3, subject3, "OK");

		entityManager.persist(rs4);

		Comment comment2 = new Comment("AAAAAhhh", user, subject1);
		entityManager.persist(comment2);

		Comment comment3 = new Comment("wAAAAAw", user2, subject3);
		entityManager.persist(comment3);

		Comment comment21 = new Comment("ohhh!", user, subject3);
		entityManager.persist(comment21);

		Comment comment4 = new Comment("AAAAA", user, subject2);
		entityManager.persist(comment4);

		Comment comment5 = new Comment("AAAAAhhh", user, subject5);
		entityManager.persist(comment5);
		
		Message message2 = new Message("Ahla", user2, user);
		Message message = new Message("Salut", user, user2);
		Message message4 = new Message("ysalmek", user3, user2);
		Message message3 = new Message("Asslema", user2, user3);
		Message message6 = new Message("Hellooo !!", user4, user2);
		Message message5 = new Message("Roufaaaa !", user2, user4);
		
		entityManager.persist(message);
		entityManager.persist(message2);
		entityManager.persist(message3);
		entityManager.persist(message4);
		entityManager.persist(message5);
		entityManager.persist(message6);
	}
}
