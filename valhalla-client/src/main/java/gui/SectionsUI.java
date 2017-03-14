package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.SectionModel;
import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;

public class SectionsUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField name;
	private JTextField description;
	JComboBox comboService;
	private static int id, idSer;
	List<Service> comboServ;

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
	 * 
	 * @throws NamingException
	 */
	public SectionsUI() throws NamingException {
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

		btnAdd.setBounds(197, 517, 95, 36);
		contentPane.add(btnAdd);

		JButton btnupdate = new JButton("Update");
		btnupdate.setBounds(349, 517, 95, 36);
		contentPane.add(btnupdate);

		JButton Delete = new JButton("Delete");

		Delete.setBounds(484, 517, 95, 36);
		contentPane.add(Delete);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(641, 214, 416, 351);
		contentPane.add(scrollPane);

		table = new JTable();

		table.setModel(new SectionModel());
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setWidth(0);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(4).setMaxWidth(0);
		table.getColumnModel().getColumn(4).setWidth(0);
		table.getColumnModel().getColumn(1).setMinWidth(0);
		table.getColumnModel().getColumn(1).setMaxWidth(0);
		table.getColumnModel().getColumn(1).setWidth(0);

		scrollPane.setViewportView(table);

		JLabel lblServiceName = new JLabel("Service Name :");
		lblServiceName.setForeground(Color.WHITE);
		lblServiceName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServiceName.setBounds(185, 246, 112, 19);
		contentPane.add(lblServiceName);

		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f = new ForumMangementUI();
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

		JButton btnHome = new JButton("");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI();
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

		comboService = new JComboBox();

		comboService.setBounds(351, 243, 177, 28);
		contentPane.add(comboService);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SectionsUI.class.getResource("/images/section.jpg")));
		label.setBounds(0, 0, 1274, 709);
		contentPane.add(label);
		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");
		comboServ = serviceServicesRemote.findServices();
		comboService.addItem("");
		for (Service s : comboServ) {
			comboService.addItem(s.getServiceName());

		}
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table.setColumnSelectionInterval(0, 0);
				comboService.setSelectedItem(table.getValueAt(table.getSelectedRow(), 5));
				name.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
				description.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
				id = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0) + "");

			}
		});
		Delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Context context;
				try {
					context = new InitialContext();
					SectionsServicesRemote serviceServicesRemote = (SectionsServicesRemote) context.lookup(
							"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
					serviceServicesRemote.deleteSection(id);
					table.setModel(new SectionModel());

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);
					table.getColumnModel().getColumn(4).setMinWidth(0);
					table.getColumnModel().getColumn(4).setMaxWidth(0);
					table.getColumnModel().getColumn(4).setWidth(0);
					table.getColumnModel().getColumn(1).setMinWidth(0);
					table.getColumnModel().getColumn(1).setMaxWidth(0);
					table.getColumnModel().getColumn(1).setWidth(0);

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnupdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Context context;
				try {
					context = new InitialContext();
					SectionsServicesRemote serviceServicesRemote = (SectionsServicesRemote) context.lookup(
							"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
					serviceServicesRemote.findSectionById(id);
					for (Service s : comboServ) {
						if (s.getServiceName().equals(comboService.getSelectedItem())) {
							idSer = s.getId();
						}
					}
					serviceServicesRemote.updateSection(id, name.getText(), description.getText(), "", idSer);

					table.setModel(new SectionModel());

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);
					table.getColumnModel().getColumn(4).setMinWidth(0);
					table.getColumnModel().getColumn(4).setMaxWidth(0);
					table.getColumnModel().getColumn(4).setWidth(0);
					table.getColumnModel().getColumn(1).setMinWidth(0);
					table.getColumnModel().getColumn(1).setMaxWidth(0);
					table.getColumnModel().getColumn(1).setWidth(0);

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Context context;
				try {
					context = new InitialContext();
					SectionsServicesRemote serviceServicesRemote = (SectionsServicesRemote) context.lookup(
							"valhalla-ear/valhalla-ejb/SectionsServices!tn.esprit.bzbz.valhalla.services.sections.SectionsServicesRemote");
					serviceServicesRemote.createSection(1, name.getText(), description.getText(), "", "");
					table.setModel(new SectionModel());

					table.getColumnModel().getColumn(0).setMinWidth(0);
					table.getColumnModel().getColumn(0).setMaxWidth(0);
					table.getColumnModel().getColumn(0).setWidth(0);
					table.getColumnModel().getColumn(4).setMinWidth(0);
					table.getColumnModel().getColumn(4).setMaxWidth(0);
					table.getColumnModel().getColumn(4).setWidth(0);
					table.getColumnModel().getColumn(1).setMinWidth(0);
					table.getColumnModel().getColumn(1).setMaxWidth(0);
					table.getColumnModel().getColumn(1).setWidth(0);

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

	}
}
