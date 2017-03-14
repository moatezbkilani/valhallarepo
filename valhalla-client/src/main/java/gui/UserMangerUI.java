package gui;
import model.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class UserMangerUI extends JFrame {

	private JPanel contentPane;
	private static JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					UserMangerUI frame = new UserMangerUI();
					
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
	public UserMangerUI() {
		setResizable(false);
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
		
		JLabel lblName = new JLabel("First name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblName.setBounds(781, 176, 96, 23);
		contentPane.add(lblName);
		
		JLabel LastName = new JLabel("Last Name :");
		LastName.setForeground(Color.WHITE);
		LastName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		LastName.setBounds(781, 207, 96, 23);
		contentPane.add(LastName);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth :");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDateOfBirth.setBounds(781, 241, 96, 23);
		contentPane.add(lblDateOfBirth);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGender.setBounds(781, 276, 96, 23);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setBounds(781, 310, 96, 23);
		contentPane.add(lblEmail);
		
		JLabel lblPassworld = new JLabel("Passworld :");
		lblPassworld.setForeground(Color.WHITE);
		lblPassworld.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassworld.setBounds(781, 344, 96, 23);
		contentPane.add(lblPassworld);
		
		JLabel lblRegistrationDate = new JLabel("Registration Date :");
		lblRegistrationDate.setForeground(Color.WHITE);
		lblRegistrationDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRegistrationDate.setBounds(781, 378, 115, 23);
		contentPane.add(lblRegistrationDate);
		
		JLabel lblLastLogin = new JLabel("Last Login :");
		lblLastLogin.setForeground(Color.WHITE);
		lblLastLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLastLogin.setBounds(781, 412, 96, 23);
		contentPane.add(lblLastLogin);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(781, 446, 96, 23);
		contentPane.add(lblUsername);
		
		JLabel lblSate = new JLabel("State :");
		lblSate.setForeground(Color.WHITE);
		lblSate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSate.setBounds(781, 480, 96, 23);
		contentPane.add(lblSate);
		
		JLabel lblRole = new JLabel("Role :");
		lblRole.setForeground(Color.WHITE);
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRole.setBounds(781, 514, 96, 23);
		contentPane.add(lblRole);
		
		JLabel lblPromotionDate = new JLabel("Promotion Date :");
		lblPromotionDate.setForeground(Color.WHITE);
		lblPromotionDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPromotionDate.setBounds(781, 548, 115, 23);
		contentPane.add(lblPromotionDate);
		
		JLabel Firstname = new JLabel("");
		Firstname.setForeground(Color.WHITE);
		Firstname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Firstname.setBounds(920, 176, 96, 23);
		contentPane.add(Firstname);
		
		JLabel lastname = new JLabel("");
		lastname.setForeground(Color.WHITE);
		lastname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastname.setBounds(920, 207, 96, 23);
		contentPane.add(lastname);
		
		JLabel Dateofbith = new JLabel("");
		Dateofbith.setForeground(Color.WHITE);
		Dateofbith.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Dateofbith.setBounds(920, 241, 96, 23);
		contentPane.add(Dateofbith);
		
		JLabel gender = new JLabel("");
		gender.setForeground(Color.WHITE);
		gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gender.setBounds(920, 276, 96, 23);
		contentPane.add(gender);
		
		JLabel email = new JLabel("");
		email.setForeground(Color.WHITE);
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setBounds(920, 310, 96, 23);
		contentPane.add(email);
		
		JLabel password = new JLabel("");
		password.setForeground(Color.WHITE);
		password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		password.setBounds(920, 344, 96, 23);
		contentPane.add(password);
		
		JLabel Registrationdate = new JLabel("");
		Registrationdate.setForeground(Color.WHITE);
		Registrationdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Registrationdate.setBounds(920, 378, 115, 23);
		contentPane.add(Registrationdate);
		
		JLabel lastlogin = new JLabel("");
		lastlogin.setForeground(Color.WHITE);
		lastlogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastlogin.setBounds(920, 412, 96, 23);
		contentPane.add(lastlogin);
		
		JLabel usernme = new JLabel("");
		usernme.setForeground(Color.WHITE);
		usernme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		usernme.setBounds(920, 446, 96, 23);
		contentPane.add(usernme);
		
		JLabel sate = new JLabel("");
		sate.setForeground(Color.WHITE);
		sate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		sate.setBounds(920, 480, 96, 23);
		contentPane.add(sate);
		
		JLabel role = new JLabel("");
		role.setForeground(Color.WHITE);
		role.setFont(new Font("Tahoma", Font.PLAIN, 12));
		role.setBounds(920, 514, 96, 23);
		contentPane.add(role);
		
		JLabel promotion = new JLabel("");
		promotion.setForeground(Color.WHITE);
		promotion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		promotion.setBounds(920, 548, 115, 23);
		contentPane.add(promotion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 195, 526, 373);
		contentPane.add(scrollPane);
		
		table = new JTable();
		try {
			table.setModel(new UserModel());
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		scrollPane.setViewportView(table);
		
		JButton btnBanne = new JButton("Banne");
		btnBanne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBanne.setBounds(1057, 590, 115, 36);
		contentPane.add(btnBanne);
		
		JButton btnDowngrade = new JButton("Downgrade");
		btnDowngrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDowngrade.setBounds(920, 590, 115, 36);
		contentPane.add(btnDowngrade);
		
		JButton btnUpgrade = new JButton("Upgrade ");
		btnUpgrade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpgrade.setBounds(781, 590, 115, 36);
		contentPane.add(btnUpgrade);
		
		
		JLabel bg = new JLabel("");
		bg.setForeground(Color.WHITE);
		bg.setIcon(new ImageIcon(UserMangerUI.class.getResource("/images/user.jpg")));
		bg.setBounds(0, 0, 1279, 704);
		contentPane.add(bg);
		
		JButton GoToMenu = new JButton("New button");
		GoToMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenuUI f=new MainMenuUI(MainMenuUI.connectedUser);
				f.pack();
			    f.setLocationRelativeTo(null);
				f.setVisible(true);
				UserMangerUI.this.setVisible(false);
			}
		});
		GoToMenu.setOpaque(false);
		GoToMenu.setFocusable(false);
		GoToMenu.setFocusTraversalKeysEnabled(false);
		GoToMenu.setFocusPainted(false);
		GoToMenu.setContentAreaFilled(false);
		GoToMenu.setBorderPainted(false);
		GoToMenu.setBorder(null);
		GoToMenu.setBounds(1158, 11, 52, 58);
		contentPane.add(GoToMenu);
	}
}
