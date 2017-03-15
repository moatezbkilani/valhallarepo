package tests;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.ui.RefineryUtilities;

import classes.AreaChart;
import classes.PieChart;
import classes.PieChart3D;
import classes.Results;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;
import tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote;

public class GraphicTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicTest frame = new GraphicTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws NamingException
	 */
	public GraphicTest() {
		Context context;
		try {
			context = new InitialContext();
			ServiceServicesRemote ssr = (ServiceServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");
			CommentsServicesRemote sis = (CommentsServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");
			List<Results> results = new ArrayList<Results>();
			for (Service ser : ssr.findServices()) {
				Results res = new Results();
				res.setStat1(ser.getServiceName());
				Double r = (sis.numberComments(ssr.findServiceById(ser.getId())).doubleValue()
						/ sis.numberTotalComments().doubleValue());
				System.out.println(r);
				res.setStat2(r);

				results.add(res);
			}
			PieChart demo = new PieChart("Comments per services", results);
			setContentPane(demo.createDemoPanel(results));
			
			
			
			
			final PieChart3D demox = new PieChart3D("Comments per Services", results);
			demox.pack();
			RefineryUtilities.centerFrameOnScreen(demox);
			demox.setVisible(true);

			SubjectsServicesRemote sub = (SubjectsServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/SubjectsServices!tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote");

			CommentsServicesRemote sisr = (CommentsServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");
			
			List<Results> results1 = new ArrayList<Results>();
			for (Service ser : ssr.findServices()) {
				Results res = new Results();
				res.setStat1(ser.getServiceName());
				Double r = (sub.numberSubject(ssr.findServiceById(ser.getId())).doubleValue()
						/ sub.numberTotalSubjects().doubleValue());
				System.out.println(r);
				res.setStat2(r);

				results1.add(res);
				System.out.println(res.getStat2());
			}

			

			List<Long> l = sisr.getNumberCommentsPerMonthFrom3YearsAgor();

			final AreaChart demo2 = new AreaChart("Comments per months for 3 years ago", l);
			demo2.pack();
			RefineryUtilities.centerFrameOnScreen(demo2);
			demo2.setVisible(true);

			final PieChart3D dem = new PieChart3D("Subjects per Services", results1);
			dem.pack();
			RefineryUtilities.centerFrameOnScreen(dem);
			dem.setVisible(true);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

		
		
	}

}
