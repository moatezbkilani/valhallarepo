package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrivateMessageUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrivateMessageUI frame = new PrivateMessageUI();
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
	public PrivateMessageUI() {
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrivateMessageUI.class.getResource("/images/aa.png")));
		lblNewLabel.setBounds(1172, 617, 68, 63);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PrivateMessageUI.class.getResource("/images/message.jpg")));
		label.setBounds(0, 0, 1274, 705);
		contentPane.add(label);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				PrivateMessageUI.this.setVisible(false);
				
			}
		});
		btnBack.setDefaultCapable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusable(false);
		btnBack.setFocusTraversalKeysEnabled(false);
		btnBack.setFocusPainted(false);
		btnBack.setBounds(1109, 11, 55, 50);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				PrivateMessageUI.this.setVisible(false);
				
			}
		});
		btnHome.setFocusable(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setDefaultCapable(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setBounds(1190, 11, 55, 50);
		contentPane.add(btnHome);
	}

}
