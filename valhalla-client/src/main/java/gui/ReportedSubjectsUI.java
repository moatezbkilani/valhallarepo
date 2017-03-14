package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportedSubjectsUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

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
	public ReportedSubjectsUI() {
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
		
		JComboBox ComboServices = new JComboBox();
		ComboServices.setToolTipText("Services");
		ComboServices.setBounds(469, 115, 148, 27);
		contentPane.add(ComboServices);
		
		JComboBox ComboSection = new JComboBox();
		ComboSection.setToolTipText("Section");
		ComboSection.setBounds(649, 115, 154, 27);
		contentPane.add(ComboSection);
		
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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(1038, 558, -337, -280);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 556, 391, -296);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReportedSubjectsUI.class.getResource("/images/reportedSubjects.jpg")));
		label.setBounds(0, 0, 1264, 697);
		contentPane.add(label);
		
		JButton btnback = new JButton("back");
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f=new ForumMangementUI();
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
				MainMenuUI f=new MainMenuUI(MainMenuUI.connectedUser);
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
	}
}
