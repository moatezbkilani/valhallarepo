package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import tn.esprit.bzbz.valhalla.entity.Service;
import tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote;

public class ServicesUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton Add;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JTextField name;
	private JTextField description;
	private JLabel lblServiceName;
	private JLabel lblServicesDescription;
	private JButton button;
	private JButton btnBack;
	private JButton btnHome;
	private JTable servicesTable;

	private Service selectedService;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServicesUI frame = new ServicesUI();
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

	public List<Service> allServices() throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

		return serviceServicesRemote.findServices();
	}

	public Service findServiceById(Integer serviceId) throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

		return serviceServicesRemote.findServiceById(serviceId);
	}

	public void deleteService(Service service) throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

		serviceServicesRemote.deleteService(service.getId());
	}

	public void updateService(Service service) throws NamingException {
		// TODO Auto-generated method stub

		Context context = new InitialContext();
		ServiceServicesRemote serviceServicesRemote = (ServiceServicesRemote) context.lookup(
				"valhalla-ear/valhalla-ejb/ServiceServices!tn.esprit.bzbz.valhalla.services.service.ServiceServicesRemote");

		serviceServicesRemote.updateService(service.getId(), service.getServiceName(), service.getDescription(),
				service.getImage());
	}

	public TableModel tableModel() {
		String col[] = { "id", "service name", " description", "image" };

		DefaultTableModel tableModel = new DefaultTableModel(col, 0);

		try {
			for (Service s : this.allServices()) {
				String service[] = { s.getId().toString(), s.getServiceName(), s.getDescription(), s.getImage() };
				tableModel.addRow(service);
			}
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return tableModel;
	}

	public ServicesUI() {
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

		name = new JTextField();
		name.setColumns(10);
		name.setBounds(369, 264, 177, 28);
		contentPane.add(name);

		description = new JTextField();
		description.setColumns(10);
		description.setBounds(369, 323, 177, 28);
		contentPane.add(description);

		servicesTable = new JTable(tableModel());
		servicesTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		servicesTable.setSurrendersFocusOnKeystroke(true);
		servicesTable.setBounds(644, 222, 415, 148);
		servicesTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent e) {

				try {

					if (servicesTable.getSelectedRow() == -1)
						return;

					if (!e.getValueIsAdjusting()) {
						Integer selectedServiceId = Integer
								.valueOf((String) servicesTable.getValueAt(servicesTable.getSelectedRow(), 0));
						selectedService = findServiceById(selectedServiceId);
					}
				} catch (IndexOutOfBoundsException ex) {
					ex.printStackTrace();

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		contentPane.add(servicesTable);

		button = new JButton("Attach Image");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc = new JFileChooser();
				int returnVal = fc.showDialog(contentPane, "Attach");
				File f = fc.getSelectedFile();
				System.out.println(fc.getName(f));

			}
		});
		button.setBounds(475, 403, 71, 23);
		contentPane.add(button);

		lblServiceName = new JLabel("Service Name");
		lblServiceName.setForeground(Color.WHITE);
		lblServiceName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServiceName.setBounds(203, 263, 112, 19);
		contentPane.add(lblServiceName);

		lblServicesDescription = new JLabel("Services Description");
		lblServicesDescription.setForeground(Color.WHITE);
		lblServicesDescription.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblServicesDescription.setBounds(203, 323, 137, 19);
		contentPane.add(lblServicesDescription);

		Add = new JButton("Add");
		Add.setBounds(644, 528, 101, 33);
		contentPane.add(Add);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selectedService.setServiceName((String) servicesTable.getValueAt(servicesTable.getSelectedRow(), 1));
				selectedService.setDescription((String) servicesTable.getValueAt(servicesTable.getSelectedRow(), 2));
				selectedService.setImage((String) servicesTable.getValueAt(servicesTable.getSelectedRow(), 3));
				System.out.println(selectedService.getServiceName());
				try {
					updateService(selectedService);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				servicesTable.setModel(tableModel());
			}
		});
		btnUpdate.setBounds(802, 528, 101, 33);
		contentPane.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteService(selectedService);
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				servicesTable.setModel(tableModel());
			}
		});
		btnDelete.setBounds(954, 528, 101, 33);
		contentPane.add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(1051, 493, -389, -249);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1274, 702);
		label.setIcon(new ImageIcon(ServicesUI.class.getResource("/images/servcies.jpg")));
		contentPane.add(label);

		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ForumMangementUI f = new ForumMangementUI();
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ServicesUI.this.setVisible(false);
			}
		});
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
		btnBack.setDefaultCapable(false);
		btnBack.setFocusPainted(false);
		btnBack.setFocusTraversalKeysEnabled(false);
		btnBack.setFocusable(false);
		btnBack.setBounds(1100, 11, 55, 54);
		contentPane.add(btnBack);

		btnHome = new JButton("home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI(MainMenuUI.connectedUser);
				f.pack();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
				ServicesUI.this.setVisible(false);
			}
		});
		btnHome.setDefaultCapable(false);
		btnHome.setBorderPainted(false);
		btnHome.setFocusable(false);
		btnHome.setFocusTraversalKeysEnabled(false);
		btnHome.setFocusPainted(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBounds(1175, 11, 59, 54);
		contentPane.add(btnHome);
	}
	
	
}
