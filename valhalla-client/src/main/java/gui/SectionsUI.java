package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SectionsUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField description;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SectionsUI frame = new SectionsUI();
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
	public SectionsUI() {
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
		
		name = new JTextField();
		name.setBounds(351, 302, 177, 28);
		contentPane.add(name);
		name.setColumns(10);
		
		description = new JTextField();
		description.setBounds(351, 361, 177, 28);
		contentPane.add(description);
		description.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(457, 469, 71, 23);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("Section Name :");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(185, 301, 112, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDescription.setBounds(185, 361, 112, 19);
		contentPane.add(lblDescription);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(653, 506, 95, 36);
		contentPane.add(btnAdd);
		
		JButton btnupdate = new JButton("Update");
		btnupdate.setBounds(805, 506, 95, 36);
		contentPane.add(btnupdate);
		
		JButton Delete = new JButton("Delete");
		Delete.setBounds(940, 506, 95, 36);
		contentPane.add(Delete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(641, 214, 416, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SectionsUI.class.getResource("/images/section.jpg")));
		label.setBounds(0, 0, 1274, 709);
		contentPane.add(label);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f=new ForumMangementUI();
				f.pack();
			    f.setLocationRelativeTo(null);
				f.setVisible(true);
				SectionsUI.this.setVisible(false);
			}
		});
		btnBack.setDefaultCapable(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setBorderPainted(false);
		btnBack.setFocusTraversalKeysEnabled(false);
		btnBack.setFocusPainted(false);
		btnBack.setBounds(1099, 11, 55, 60);
		contentPane.add(btnBack);
		
		JButton btnHome = new JButton("back");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f=new MainMenuUI();
				f.pack();
			    f.setLocationRelativeTo(null);
				f.setVisible(true);
				SectionsUI.this.setVisible(false);
			}
		});
		btnHome.setDefaultCapable(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setBounds(1177, 11, 55, 60);
		contentPane.add(btnHome);
	}

}
