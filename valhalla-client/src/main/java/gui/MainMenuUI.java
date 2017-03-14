package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.bzbz.valhalla.entity.User;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class MainMenuUI extends JFrame {

	public static User connectedUser;

	private JPanel contentPane;

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
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon(MainMenuUI.class.getResource("/images/Main.jpg")));
		BG.setBounds(0, 0, 1274, 713);
		contentPane.add(BG);
		
		JButton btnForumMangement = new JButton("New button");
		btnForumMangement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f=new ForumMangementUI();
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
				
				UserMangerUI f=new UserMangerUI();
				
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
				PrivateMessageUI f=new PrivateMessageUI();
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
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginUI f=new LoginUI();
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
