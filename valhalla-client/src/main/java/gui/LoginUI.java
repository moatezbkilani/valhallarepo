package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote;
import tn.esprit.bzbz.valhalla.services.user.UserServicesRemote;

public class LoginUI extends JFrame {

	private JPanel contentPane;
	private JTextField email;
	private JPasswordField password;
	MainMenuUI n;
	static LoginUI frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginUI();
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
		n = new MainMenuUI(MainMenuUI.connectedUser);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Context context;
				try {
					context = new InitialContext();
					SignInServicesRemote sisr = (SignInServicesRemote) context.lookup(
							"valhalla-ear/valhalla-ejb/SignInServices!tn.esprit.bzbz.valhalla.services.signin.SignInServicesRemote");
					// sisr.signIn(email.getText(), password.getText());
					Context context1 = new InitialContext();
					UserServicesRemote usr = (UserServicesRemote) context1.lookup(
							"valhalla-ear/valhalla-ejb/UserServices!tn.esprit.bzbz.valhalla.services.user.UserServicesRemote");
					User connectedUser = usr.findById(sisr.signIn(email.getText(), password.getText()));
					if (connectedUser != null) {
						MainMenuUI n = new MainMenuUI(connectedUser);
						n.setVisible(true);
						LoginUI.this.setVisible(false);

					}

				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnLogin.setBounds(617, 387, 177, 31);
		contentPane.add(btnLogin);

		JLabel lblForgetYouPassword = new JLabel("Forget your password ?");
		lblForgetYouPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				RecoverUI f = new RecoverUI();

				f.setLocationRelativeTo(null);
				f.setVisible(true);
				LoginUI.this.setVisible(false);

			}
		});
		lblForgetYouPassword.setForeground(Color.WHITE);
		lblForgetYouPassword.setToolTipText("Recover Your Password");
		lblForgetYouPassword.setBounds(617, 429, 131, 14);
		contentPane.add(lblForgetYouPassword);

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
