package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ForumMangementUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForumMangementUI frame = new ForumMangementUI();
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
	public ForumMangementUI() {
		setMinimumSize(new Dimension(1280, 720));
		setMaximumSize(new Dimension(1280, 720));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(1280, 720));
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ForumMangementUI.class.getResource("/images/frum-magement.jpg")));
		label.setBounds(0, 0, 1274, 711);
		contentPane.add(label);

		JButton btnServices = new JButton("ServiceBtn");
		btnServices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ServicesUI f = new ServicesUI();

				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ForumMangementUI.this.setVisible(false);
			}
		});
		btnServices.setFocusable(false);
		btnServices.setFocusTraversalKeysEnabled(false);
		btnServices.setFocusPainted(false);
		btnServices.setContentAreaFilled(false);
		btnServices.setBorderPainted(false);
		btnServices.setBorder(null);
		btnServices.setBounds(22, 165, 245, 69);
		contentPane.add(btnServices);

		JButton btnSection = new JButton("ServiceBtn");
		btnSection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SectionsUI f;
				try {
					f = new SectionsUI();
					f.setLocationRelativeTo(null);
					f.setVisible(true);
					ForumMangementUI.this.setVisible(false);
					
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
			}
		});
		btnSection.setFocusable(false);
		btnSection.setFocusTraversalKeysEnabled(false);
		btnSection.setFocusPainted(false);
		btnSection.setContentAreaFilled(false);
		btnSection.setBorderPainted(false);
		btnSection.setBorder(null);
		btnSection.setBounds(22, 286, 245, 69);
		contentPane.add(btnSection);

		JButton btnReprotSubject = new JButton("ServiceBtn");
		btnReprotSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportedSubjectsUI f;
				try {
					f = new ReportedSubjectsUI();
					f.setLocationRelativeTo(null);
					f.setVisible(true);
					ForumMangementUI.this.setVisible(false);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			}
		});
		btnReprotSubject.setFocusable(false);
		btnReprotSubject.setFocusTraversalKeysEnabled(false);
		btnReprotSubject.setFocusPainted(false);
		btnReprotSubject.setContentAreaFilled(false);
		btnReprotSubject.setBorderPainted(false);
		btnReprotSubject.setBorder(null);
		btnReprotSubject.setBounds(22, 422, 245, 69);
		contentPane.add(btnReprotSubject);

		JButton btnReportComent = new JButton("ServiceBtn");
		btnReportComent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportedCommentsUI f = new ReportedCommentsUI();

				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ForumMangementUI.this.setVisible(false);

			}
		});
		btnReportComent.setFocusable(false);
		btnReportComent.setFocusTraversalKeysEnabled(false);
		btnReportComent.setFocusPainted(false);
		btnReportComent.setContentAreaFilled(false);
		btnReportComent.setBorderPainted(false);
		btnReportComent.setBorder(null);
		btnReportComent.setBounds(22, 547, 245, 69);
		contentPane.add(btnReportComent);

		JButton btnBck = new JButton("New button");
		btnBck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MainMenuUI f = new MainMenuUI(MainMenuUI.connectedUser);

				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ForumMangementUI.this.setVisible(false);
			}
		});
		btnBck.setFocusable(false);
		btnBck.setFocusTraversalKeysEnabled(false);
		btnBck.setFocusPainted(false);
		btnBck.setDefaultCapable(false);
		btnBck.setContentAreaFilled(false);
		btnBck.setBorderPainted(false);
		btnBck.setBounds(1175, 11, 65, 57);
		contentPane.add(btnBck);
	}

}
