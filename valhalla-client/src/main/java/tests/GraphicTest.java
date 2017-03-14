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
	public GraphicTest() throws NamingException {
		Context context = new InitialContext();
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
		PieChart demo = new PieChart("Pie Chart Demo 1", results);
		setContentPane(demo.createDemoPanel(results));
	}

}
