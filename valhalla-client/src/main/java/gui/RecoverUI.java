package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import tn.esprit.bzbz.valhalla.services.recoverPassword.RecoverPasswordServicesRemote;

public class RecoverUI extends JFrame {

	private JPanel contentPane;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecoverUI frame = new RecoverUI();
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
	public RecoverUI() {
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

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int p = JOptionPane.showConfirmDialog(null, "Are you sure to Recover you password ", "Recover Password",
						JOptionPane.YES_NO_OPTION);
				if (p == 0) {
					try {
						Context context;
						context = new InitialContext();
						RecoverPasswordServicesRemote recoverPasswordServicesRemote = (RecoverPasswordServicesRemote) context
								.lookup("valhalla-ear/valhalla-ejb/RecoverPasswordServices!tn.esprit.bzbz.valhalla.services.recoverPassword.RecoverPasswordServicesRemote");
						Boolean r = recoverPasswordServicesRemote.sendNewPassword(email.getText());
						System.out.println(email.getText());
						System.out.println(r);
						if (r == true) {
							JOptionPane.showMessageDialog(null, "Please check you email inbox ");
							LoginUI f = new LoginUI();

							f.setLocationRelativeTo(null);
							f.setVisible(true);
							RecoverUI.this.setVisible(false);
						} else
							JOptionPane.showMessageDialog(null, "Wrong email ");

						// System.out.println(i);
					} catch (NamingException w) {
					}
				}

			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBounds(765, 299, 89, 23);
		contentPane.add(btnNewButton);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEmail.setBounds(379, 297, 86, 27);
		contentPane.add(lblEmail);

		email = new JTextField();
		email.setBounds(471, 297, 279, 27);
		contentPane.add(email);
		email.setColumns(10);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(RecoverUI.class.getResource("/images/recover.jpg")));
		label.setBounds(0, 0, 1274, 691);
		contentPane.add(label);
	}
}
