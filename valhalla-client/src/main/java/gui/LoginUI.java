package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
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
	public LoginUI() {
		setMinimumSize(new Dimension(1280, 720));
		setMaximumSize(new Dimension(1280, 720));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(1280, 720));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		MainMenuUI n =new MainMenuUI();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					SignInServicesRemote sisr = (SignInServicesRemote) context.lookup(
							"valhalla-ear/valhalla-ejb/SignInServices!tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote");
					sisr.signIn(email.getText(), password.getText());
					
					MainMenuUI n =new MainMenuUI();
					n.setVisible(true);
					LoginUI.this.setVisible(false);
					
					
					
					
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				
			}
		});
		btnLogin.setBounds(524, 400, 104, 31);
		contentPane.add(btnLogin);
		
		JButton btnRecoverPassword = new JButton("recover password");
		btnRecoverPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnRecoverPassword.setBounds(703, 404, 119, 23);
		contentPane.add(btnRecoverPassword);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(486, 232, 71, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblPasss = new JLabel("Password");
		lblPasss.setForeground(Color.WHITE);
		lblPasss.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPasss.setBounds(487, 324, 100, 14);
		contentPane.add(lblPasss);
		
		email = new JTextField();
		email.setBounds(617, 236, 177, 28);
		contentPane.add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(617, 320, 177, 26);
		contentPane.add(password);
		
		JLabel BG = new JLabel("");
		BG.setIcon(new ImageIcon(LoginUI.class.getResource("/images/login.jpg")));
		BG.setBounds(0, 0, 1264, 681);
		contentPane.add(BG);
	}
}
