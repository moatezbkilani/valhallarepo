package tests;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;

import classes.PieChart;
import classes.Results;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;

public class StatisticTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatisticTest frame = new StatisticTest();

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
	public StatisticTest() throws NamingException {
		Context context = new InitialContext();
		ServiceServicesRemote ssr = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");
		CommentsServicesRemote sis = (CommentsServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");
		System.out
				.println("NB: " + sis.numberComments(ssr.findServiceById(1)) + " NBTOT: " + sis.numberTotalComments());
		List<Service> services = new ArrayList<Service>();
		services.addAll(ssr.findServices());
		List<Results> result = new ArrayList<Results>();
		for (Service ser : ssr.findServices()) {
			Results res = new Results();
			res.setStat1(ser.getServiceName());
			Double r = (sis.numberComments(ssr.findServiceById(ser.getId())).doubleValue()
					/ sis.numberTotalComments().doubleValue());
			res.setStat2(r);
			result.add(res);
		}
		PieChart demo = new PieChart("Pie Chart Demo 1", result);
		setContentPane(demo.createDemoPanel(result));

	}

}
