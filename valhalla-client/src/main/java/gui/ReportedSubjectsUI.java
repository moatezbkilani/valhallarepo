package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import model.ReportedSubjectModel;
import model.ReportedSubjectUserModel;
import tn.esprit.bzbz.valhalla.entity.Section;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;
import tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote;

public class ReportedSubjectsUI extends JFrame {
	JComboBox comboService;
	List<Service> comboServ;
	List<Section> comboSect;
	private JPanel contentPane;
	private JTable tablereport;
	private JTable tableuser;
	JComboBox comboSection;
	Service s1;
	Section s2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportedSubjectsUI frame = new ReportedSubjectsUI();
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
	public ReportedSubjectsUI() throws NamingException {
		setMinimumSize(new Dimension(1280, 720));
		setMaximumSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1280, 720));
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		comboService = new JComboBox();

		comboService.setToolTipText("Services");
		comboService.setBounds(469, 115, 148, 27);
		contentPane.add(comboService);

		comboSection = new JComboBox();

		comboSection.setToolTipText("Section");
		comboSection.setBounds(649, 115, 154, 27);
		contentPane.add(comboSection);

		JButton btnLockSubject = new JButton("Lock The Subject");

		btnLockSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLockSubject.setBounds(236, 573, 125, 37);
		contentPane.add(btnLockSubject);

		JButton btnDeleteTheSubject = new JButton("Delete The Subject");

		btnDeleteTheSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteTheSubject.setBounds(443, 573, 125, 37);
		contentPane.add(btnDeleteTheSubject);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 243, 401, 316);
		contentPane.add(scrollPane);

		tablereport = new JTable();

		scrollPane.setViewportView(tablereport);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(675, 237, 399, 381);
		contentPane.add(scrollPane_1);

		tableuser = new JTable();
		scrollPane_1.setViewportView(tableuser);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReportedSubjectsUI.class.getResource("/images/reportedSubjects.jpg")));
		label.setBounds(0, 0, 1264, 697);
		contentPane.add(label);

		JButton btnback = new JButton("back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f = new ForumMangementUI();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ReportedSubjectsUI.this.setVisible(false);
			}
		});
		btnback.setFocusable(false);
		btnback.setFocusTraversalKeysEnabled(false);
		btnback.setFocusPainted(false);
		btnback.setDefaultCapable(false);
		btnback.setContentAreaFilled(false);
		btnback.setBorderPainted(false);
		btnback.setBounds(1100, 11, 55, 54);
		contentPane.add(btnback);

		JButton btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI(MainMenuUI.connectedUser);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ReportedSubjectsUI.this.setVisible(false);

			}
		});
		btnHome.setFocusable(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setDefaultCapable(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(1175, 11, 59, 54);
		contentPane.add(btnHome);
		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");
		comboServ = serviceServicesRemote.findServices();
		comboService.addItem("");
		for (Service s : comboServ) {
			comboService.addItem(s.getServiceName());

		}

		tablereport.setModel(new ReportedSubjectModel());
		tablereport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableuser.setVisible(true);
				try {
					tableuser.setModel(new ReportedSubjectUserModel(
							Integer.parseInt(tablereport.getValueAt(tablereport.getSelectedRow(), 0).toString())));
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		comboSection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboSection.getSelectedIndex() == 0) {
					try {
						tablereport.setModel(new ReportedSubjectModel(s1.getId()));
						tableuser.setVisible(false);
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Context context1;

					try {
						context1 = new InitialContext();
						SectionsServicesRemote sectionServicesRemote = (SectionsServicesRemote) context1.lookup(
								"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
						for (Section s : comboSect) {
							if (s.getSectionName().equals(comboSection.getSelectedItem())) {
								Context context2 = new InitialContext();
								SectionsServicesRemote serviceServicesRemote = (SectionsServicesRemote) context2.lookup(
										"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");

								s2 = serviceServicesRemote.findSectionById(s.getId());
								tablereport.setModel(new ReportedSubjectModel(s2.getId(), 1));
								tableuser.setVisible(false);
							}
						}

					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// do something with object
				}

			}
		});

		comboService.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (comboService.getSelectedIndex() == 0) {
					try {
						tablereport.setModel(new ReportedSubjectModel());
						tableuser.setVisible(false);
						comboSection.removeAllItems();
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Context context1;
					comboSection.removeAllItems();
					try {
						context1 = new InitialContext();
						SectionsServicesRemote sectionServicesRemote = (SectionsServicesRemote) context1.lookup(
								"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
						for (Service s : comboServ) {
							if (s.getServiceName().equals(comboService.getSelectedItem())) {
								Context context2 = new InitialContext();
								ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context2.lookup(
										"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

								s1 = serviceServicesRemote.findServiceById(s.getId());
								tablereport.setModel(new ReportedSubjectModel(s1.getId()));
								tableuser.setVisible(false);
							}
						}
						comboSect = sectionServicesRemote.findSectionsByService(s1);

						comboSection.addItem("");
						for (Section s : comboSect) {
							comboSection.addItem(s.getSectionName());

						}

					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					// do something with object
				}
			}

		});
		btnLockSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablereport.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please, select a subject");
				} else {
					Context context2;
					try {
						context2 = new InitialContext();
						SubjectsServicesRemote serviceServicesRemote = (SubjectsServicesRemote) context2.lookup(
								"valhalla-ear/valhalla-ejb/SubjectsServices!tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote");
						serviceServicesRemote.lockSubject(
								Integer.parseInt(tablereport.getValueAt(tablereport.getSelectedRow(), 0) + ""));
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		btnDeleteTheSubject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablereport.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please, select a subject");
				} else {
					Context context2;
					try {
						context2 = new InitialContext();
						SubjectsServicesRemote serviceServicesRemote = (SubjectsServicesRemote) context2.lookup(
								"valhalla-ear/valhalla-ejb/SubjectsServices!tn.esprit.bzbz.valhalla.services.subjects.SubjectsServicesRemote");
						serviceServicesRemote.removeSubject(
								Integer.parseInt(tablereport.getValueAt(tablereport.getSelectedRow(), 0) + ""));
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
	}
}
