package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import tn.esprit.bzbz.valhalla.entity.Message;
import tn.esprit.bzbz.valhalla.entity.User;
import tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class PrivateMessageUI extends JFrame {

	public static Set<User> secondParties;
	private JPanel contentPane;
	private JTextPane messagesContainer;
	private JTextArea messagesArea;
	private User secondParty;


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

		Context context;
		secondParties = new HashSet<User>();
		try {
			context = new InitialContext();
			PrivateMessageServicesRemote pr = (PrivateMessageServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/PrivateMessageServices!tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote");
			secondParties = pr.findConversations(MainMenuUI.connectedUser);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DefaultListModel listModel = new DefaultListModel();
		for (User u : secondParties) {
			listModel.addElement("" + u.getFirstName() + " " + u.getLastName());
		}

		JList conversationsList = new JList();
		conversationsList.setSelectionBackground(Color.LIGHT_GRAY);
		conversationsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		conversationsList.setBounds(25, 128, 275, 529);
		conversationsList.setModel(listModel);
		conversationsList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent evt) {
				if (evt.getValueIsAdjusting())
					return;
				messagesContainer.setText("");

				for (User u : secondParties) {
					String str = "" + u.getFirstName() + " " + u.getLastName();
					if (str.equals(conversationsList.getSelectedValue().toString())) {
						secondParty = u;
						loadMessagesByConversation(u);
					}
				}
			}
		});

		messagesContainer = new JTextPane();
		messagesContainer.setEditable(false);
		messagesContainer.setBounds(381, 101, 859, 388);
		contentPane.add(messagesContainer);

		messagesArea = new JTextArea();
		messagesArea.setBounds(381, 535, 781, 145);
		contentPane.add(messagesArea);
		contentPane.add(conversationsList);

		JLabel sendMessage = new JLabel("");
		sendMessage.setIcon(new ImageIcon(PrivateMessageUI.class.getResource("/images/aa.png")));
		sendMessage.setBounds(1172, 571, 68, 63);
		sendMessage.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Context context;
				if (!messagesArea.getText().equals("")) {
					try {
						context = new InitialContext();
						PrivateMessageServicesRemote pr = (PrivateMessageServicesRemote) context.lookup(
								"valhalla-ear/valhalla-ejb/PrivateMessageServices!tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote");
						pr.sendPrivateMessage(MainMenuUI.connectedUser, secondParty, messagesArea.getText());
						
					} catch (NamingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				messagesArea.setText("");
			}
		});
		contentPane.add(sendMessage);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setEnabled(false);
		lblNewLabel.setIcon(new ImageIcon(PrivateMessageUI.class.getResource("/images/aa.png")));
		lblNewLabel.setBounds(1172, 571, 68, 63);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(PrivateMessageUI.class.getResource("/images/message.jpg")));
		label.setBounds(0, 0, 1274, 705);
		contentPane.add(label);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenuUI f = new MainMenuUI(MainMenuUI.connectedUser);
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
				MainMenuUI f = new MainMenuUI(MainMenuUI.connectedUser);
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
	
	public void loadMessagesByConversation(User secondParty) {

		StyledDocument doc;

		SimpleAttributeSet as = new SimpleAttributeSet();
		StyleConstants.setAlignment(as, StyleConstants.ALIGN_RIGHT);

		SimpleAttributeSet timeDesign = new SimpleAttributeSet();
		StyleConstants.setForeground(timeDesign, Color.decode("#D1D1D1"));
		// StyleConstants.setBackground(senderColor, Color.LIGHT_GRAY);
		StyleConstants.setBold(timeDesign, false);
		StyleConstants.setFontSize(timeDesign, 9);

		/*
		 * ImageIcon pigIcon = createImageIcon("images/Pig.gif", "a cute pig");
		 * if (pigIcon != null) { StyleConstants.setIcon(s, pigIcon); }
		 */
		SimpleAttributeSet messageContent = new SimpleAttributeSet();
		StyleConstants.setForeground(messageContent, Color.decode("#767676"));
		// StyleConstants.setBackground(senderColor, Color.LIGHT_GRAY);
		StyleConstants.setBold(messageContent, false);
		StyleConstants.setFontSize(messageContent, 14);
		// StyleConstants.setIcon(messageContent, c);

		SimpleAttributeSet senderColor = new SimpleAttributeSet();
		StyleConstants.setForeground(senderColor, Color.decode("#0000FF"));
		// StyleConstants.setBackground(senderColor, Color.LIGHT_GRAY);
		StyleConstants.setBold(senderColor, true);
		StyleConstants.setFontSize(senderColor, 15);

		SimpleAttributeSet receiverColor = new SimpleAttributeSet();
		StyleConstants.setForeground(receiverColor, Color.decode("#FF0000"));
		// StyleConstants.setBackground(receiverColor, Color.LIGHT_GRAY);
		StyleConstants.setBold(receiverColor, true);
		StyleConstants.setFontSize(receiverColor, 15);
		List<Message> messages = new ArrayList();
		try {
			Context context = new InitialContext();
			PrivateMessageServicesRemote pr = (PrivateMessageServicesRemote) context.lookup(
					"valhalla-ear/valhalla-ejb/PrivateMessageServices!tn.esprit.bzbz.valhalla.services.privateMessage.PrivateMessageServicesRemote");
			messages = pr.findMessages(MainMenuUI.connectedUser, secondParty);

		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (messages != null) {
			for (Message message : messages) {
				User sender = message.getUserOne();
				String print = " " + sender.getFirstName() + ": ";
				doc = messagesContainer.getStyledDocument();
				try {
					if (MainMenuUI.connectedUser.getId() == sender.getId()) {
						doc.insertString(doc.getLength(), print, senderColor);
						doc.insertString(doc.getLength(), message.getContent() + " \n", messageContent);
						doc.insertString(doc.getLength(), "                                                         "
								+ message.getMessageId().getDate() + " \n", timeDesign);
					} else {
						doc.insertString(doc.getLength(), print, receiverColor);
						doc.insertString(doc.getLength(), message.getContent() + " \n", messageContent);
						doc.insertString(doc.getLength(), "                                                         "
								+ message.getMessageId().getDate() + " \n", timeDesign);

					}
				} catch (BadLocationException ex) {
					// Logger.getLogger(Messages.class.getName()).log(Level.SEVERE,
					// null, ex);
				}
			}

		}


	}

}
