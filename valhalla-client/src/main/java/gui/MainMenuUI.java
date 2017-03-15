package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartPanel;

import classes.AreaChart;
import classes.PieChart3D;
import classes.Results;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;
import tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote;

public class MainMenuUI extends JFrame {

	public static User connectedUser;

	private JPanel contentPane;

	private JPanel statsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenuUI frame = new MainMenuUI(MainMenuUI.connectedUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenuUI(User connectedUser) {
		Context context;
		this.connectedUser = connectedUser;
		setMinimumSize(new Dimension(1280, 720));
		setResizable(false);
		setMaximumSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1280, 720));
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		statsPanel = new JPanel();
		statsPanel.setBounds(325, 112, 939, 568);
		contentPane.add(statsPanel);

		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon(MainMenuUI.class.getResource("/images/Main.jpg")));
		BG.setBounds(0, 0, 1274, 713);
		contentPane.add(BG);

		JButton btnForumMangement = new JButton("New button");
		btnForumMangement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f = new ForumMangementUI();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				MainMenuUI.this.setVisible(false);
			}
		});
		btnForumMangement.setBorderPainted(false);
		btnForumMangement.setBorder(null);
		btnForumMangement.setFocusable(false);
		btnForumMangement.setFocusTraversalKeysEnabled(false);
		btnForumMangement.setFocusPainted(false);
		btnForumMangement.setOpaque(false);
		btnForumMangement.setBounds(22, 309, 242, 64);
		contentPane.add(btnForumMangement);

		JButton UserMangment = new JButton("New button");
		UserMangment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				UserMangerUI f = new UserMangerUI();

				f.setLocationRelativeTo(null);
				f.setVisible(true);
				MainMenuUI.this.setVisible(false);
			}
		});
		UserMangment.setOpaque(false);
		UserMangment.setFocusable(false);
		UserMangment.setFocusTraversalKeysEnabled(false);
		UserMangment.setFocusPainted(false);
		UserMangment.setBorderPainted(false);
		UserMangment.setBorder(null);
		UserMangment.setBounds(22, 188, 242, 64);
		contentPane.add(UserMangment);

		JButton Message = new JButton("New button");
		Message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PrivateMessageUI f = new PrivateMessageUI();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				MainMenuUI.this.setVisible(false);

			}
		});
		Message.setOpaque(false);
		Message.setFocusable(false);
		Message.setFocusTraversalKeysEnabled(false);
		Message.setFocusPainted(false);
		Message.setBorderPainted(false);
		Message.setBorder(null);
		Message.setBounds(800, 11, 211, 58);
		contentPane.add(Message);

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
			// PieChart demo = new PieChart("Comments per services", results);
			// setContentPane(demo.createDemoPanel(results));

			final PieChart3D demox = new PieChart3D("Comments per Services", results);
			/*
			 * demox.pack(); RefineryUtilities.centerFrameOnScreen(demox);
			 * demox.setVisible(true); demox.setAlwaysOnTop(true);
			 */
			ChartPanel dPanel = new ChartPanel(demox.commentsChart("Comments per Services", results)); // creating
																										// the
																										// chart
																										// panel,
																										// which
																										// extends
																										// JPanel
			FlowLayout flowLayout3 = (FlowLayout) dPanel.getLayout();
			flowLayout3.setAlignment(FlowLayout.LEFT);
			dPanel.setMaximumDrawWidth(500);
			dPanel.setMaximumDrawHeight(400);
			dPanel.setPreferredSize(new Dimension(440, 300)); // size according
																// to my window
			dPanel.setMouseWheelEnabled(true);

			statsPanel.add(dPanel);

			SubjectsServicesRemote sub = (SubjectsServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/SubjectsServices!tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote");

			CommentsServicesRemote sisr = (CommentsServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/CommentsServices!tn.esprit.bzbz.valhalla.services.comments.CommentsServicesRemote");

			List<Results> results1 = new ArrayList<Results>();
			for (Service ser : ssr.findServices()) {
				Double r = 0d;
				Results res = new Results();
				res.setStat1(ser.getServiceName());
				System.out.println("ICIIIIIII " + sub.numberSubject(ssr.findServiceById(ser.getId())));
				r = (sub.numberSubject(ssr.findServiceById(ser.getId())).doubleValue()
						/ sub.numberTotalSubjects().doubleValue());
				System.out.println(r);

				res.setStat2(r);

				results1.add(res);
				System.out.println(res.getStat2());
			}

			List<Long> l = sisr.getNumberCommentsPerMonthFrom3YearsAgor();

			final AreaChart demo2 = new AreaChart("Comments per months for 3 years ago", l);

			ChartPanel areaPanel = new ChartPanel(AreaChart.areaChart); // creating
																		// the
																		// chart
																		// panel,
																		// which
																		// extends
																		// JPanel
			FlowLayout borderLayout = (FlowLayout) areaPanel.getLayout();
			borderLayout.setAlignment(FlowLayout.CENTER);
			areaPanel.setMaximumDrawWidth(900);
			areaPanel.setMaximumDrawHeight(400);
			areaPanel.setPreferredSize(new Dimension(900, 300)); // size
																	// according
																	// to my
																	// window
			areaPanel.setMouseWheelEnabled(true);

			final PieChart3D dem = new PieChart3D("Subjects per Services", results1);

			ChartPanel chPanel = new ChartPanel(dem.subjectsChart("Subjects per Services", results1)); // creating
																										// the
																										// chart
																										// panel,
																										// which
																										// extends
																										// JPanel
			FlowLayout flowLayout = (FlowLayout) chPanel.getLayout();
			flowLayout.setAlignment(FlowLayout.LEFT);
			chPanel.setMaximumDrawWidth(500);
			chPanel.setMaximumDrawHeight(400);
			chPanel.setPreferredSize(new Dimension(440, 300)); // size according
																// to my window
			chPanel.setMouseWheelEnabled(true);

			statsPanel.add(chPanel);

			statsPanel.add(areaPanel);

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				LoginUI f = new LoginUI();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				MainMenuUI.this.setVisible(false);

			}
		});
		button.setOpaque(false);
		button.setFocusable(false);
		button.setFocusTraversalKeysEnabled(false);
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setBounds(1045, 21, 43, 34);
		contentPane.add(button);

		JLabel YourName = new JLabel("");
		YourName.setBounds(1155, 33, 97, 14);
		contentPane.add(YourName);
	}
}
