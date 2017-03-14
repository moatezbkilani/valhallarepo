package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReportedCommentsUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportedCommentsUI frame = new ReportedCommentsUI();
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
	public ReportedCommentsUI() {
		setResizable(false);
		setMinimumSize(new Dimension(1280, 720));
		setMaximumSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("Lock The Subject");
		button.setBounds(237, 573, 125, 37);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Delete The Subject");
		button_1.setBounds(444, 573, 125, 37);
		contentPane.add(button_1);
		
		JComboBox Services = new JComboBox();
		Services.setToolTipText("Services");
		Services.setBounds(470, 115, 148, 27);
		contentPane.add(Services);
		
		JComboBox Section = new JComboBox();
		Section.setToolTipText("Section");
		Section.setBounds(650, 115, 154, 27);
		contentPane.add(Section);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(1039, 558, -337, -298);
		contentPane.add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(211, 556, 391, -296);
		contentPane.add(scrollPane_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ReportedCommentsUI.class.getResource("/images/reportedComments.jpg")));
		label.setBounds(0, 0, 1274, 701);
		contentPane.add(label);
		
		JButton back = new JButton("back");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f=new ForumMangementUI();
				f.pack();
			    f.setLocationRelativeTo(null);
				f.setVisible(true);
				ReportedCommentsUI.this.setVisible(false);
				
			}
		});
		back.setFocusable(false);
		back.setFocusTraversalKeysEnabled(false);
		back.setFocusPainted(false);
		back.setDefaultCapable(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setBounds(1101, 11, 55, 54);
		contentPane.add(back);
		
		JButton home = new JButton("home");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f=new MainMenuUI();
				f.pack();
			    f.setLocationRelativeTo(null);
				f.setVisible(true);
				ReportedCommentsUI.this.setVisible(false);
			}
		});
		home.setFocusable(false);
		home.setFocusTraversalKeysEnabled(false);
		home.setFocusPainted(false);
		home.setDefaultCapable(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		home.setBounds(1176, 11, 59, 54);
		contentPane.add(home);
	}

}
