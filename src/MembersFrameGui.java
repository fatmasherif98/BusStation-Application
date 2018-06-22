import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MembersFrameGui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldONE;
	private JTextField textFieldTWO;
	private JTextField textFieldTHREE;
	private JTextField textFieldFIVE;
	private JTextField textFieldFOUR;
	private JTextField textFieldSIX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembersFrameGui frame = new MembersFrameGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Object GetData(JTable table, int row_index, int col_index) {
		return table.getModel().getValueAt(row_index, col_index);
	}

	/**
	 * Create the frame.
	 */
	public MembersFrameGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1326, 685);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/*************************************************************************************/
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Drivers");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Manage Drivers");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				DriversFrame driverFrame = new DriversFrame();
				driverFrame.setVisible(true);
			}

		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenu mnManagers = new JMenu("Managers");
		menuBar.add(mnManagers);

		JMenuItem mntmManageManagers = new JMenuItem("Manage Managers");
		mntmManageManagers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				dispose();
				EmployeeManagersGui empMan = new EmployeeManagersGui();
				empMan.setVisible(true);
			}
		});
		mnManagers.add(mntmManageManagers);

		JMenu mnTrips = new JMenu("Trips");
		menuBar.add(mnTrips);

		JMenuItem mntmCheckAvailableTrips = new JMenuItem("Manage User's Trips");
		mntmCheckAvailableTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				ReservedTripsGui reservedTrips = new ReservedTripsGui();
				reservedTrips.setVisible(true);
			}
		});
		mnTrips.add(mntmCheckAvailableTrips);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Manage Available Trips");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				AvailableTripsGui availableTrip = new AvailableTripsGui();
				availableTrip.setVisible(true);
			}
		});
		mnTrips.add(mntmNewMenuItem_1);

		JMenu mnMembers = new JMenu("Members");
		menuBar.add(mnMembers);

		JMenuItem mntmManageMembers = new JMenuItem("Manage Members");
		mntmManageMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MembersFrameGui memberGui = new MembersFrameGui();
				contentPane.setVisible(false);
				dispose();
				memberGui.setVisible(true);
			}
		});
		mnMembers.add(mntmManageMembers);

		JMenu mnLogOut = new JMenu("other options");
		menuBar.add(mnLogOut);

		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				dispose();
				LoginFrame log = new LoginFrame();
				log.main(null);
			}
		});
		mnLogOut.add(mntmLogOut);

		/****************************************************************************************************************************/

		ManagerLogic managerObj = new ManagerLogic();
		managerObj.readFromMembersFile();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 3, true), "Member's Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(10, 11, 762, 589);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnShowMembers = new JButton("Show Members Information");
		btnShowMembers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnShowMembers.setVisible(false);
				for (int j = 0; j < managerObj.countMembers; j++) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] { managerObj.memberArray.get(j).getID(),
							managerObj.memberArray.get(j).getFirstName(), managerObj.memberArray.get(j).getLastName(),
							managerObj.memberArray.get(j).getPhoneNumber(), managerObj.memberArray.get(j).getRank(),
							managerObj.memberArray.get(j).getPassword() });
				}
			}
		});
		btnShowMembers.setBounds(304, 215, 204, 80);
		panel.add(btnShowMembers);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 742, 556);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Member ID", "First Name", "Last Name", "Phone Number", "Rank", "Password" }));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 3, true), "Add New Member", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(800, 11, 500, 589);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textFieldONE = new JTextField();
		textFieldONE.setColumns(10);
		textFieldONE.setBounds(178, 45, 144, 41);
		panel_1.add(textFieldONE);

		JButton btnAddNewMem = new JButton("Add New Member");
		btnAddNewMem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textFieldONE.getText(), textFieldTWO.getText(), textFieldTHREE.getText(),
						textFieldFOUR.getText(), textFieldFIVE.getText(), textFieldSIX.getText()

				});
			}
		});
		btnAddNewMem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddNewMem.setBounds(342, 181, 135, 41);
		panel_1.add(btnAddNewMem);

		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSave.setBounds(342, 276, 135, 41);
		panel_1.add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {

						JOptionPane.showMessageDialog(null, "No data to delete");
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete");
					}
				} else {
					int j = table.getSelectedRow();
					managerObj.removeFromMemberList(j);
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBounds(342, 382, 135, 41);
		panel_1.add(btnDelete);

		textFieldTWO = new JTextField();
		textFieldTWO.setColumns(10);
		textFieldTWO.setBounds(178, 129, 144, 41);
		panel_1.add(textFieldTWO);

		textFieldTHREE = new JTextField();
		textFieldTHREE.setColumns(10);
		textFieldTHREE.setBounds(178, 228, 144, 41);
		panel_1.add(textFieldTHREE);

		textFieldFIVE = new JTextField();
		textFieldFIVE.setColumns(10);
		textFieldFIVE.setBounds(178, 436, 144, 41);
		panel_1.add(textFieldFIVE);

		textFieldFOUR = new JTextField();
		textFieldFOUR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {

				char iNumber = evt.getKeyChar();
				if (!(Character.isDigit(iNumber)) || (iNumber == KeyEvent.VK_BACK_SPACE)
						|| (iNumber == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textFieldFOUR.setColumns(10);
		textFieldFOUR.setBounds(178, 335, 144, 41);
		panel_1.add(textFieldFOUR);

		textFieldSIX = new JTextField();
		textFieldSIX.setColumns(10);
		textFieldSIX.setBounds(178, 518, 144, 41);
		panel_1.add(textFieldSIX);

		JLabel lblNewLabel = new JLabel("Member ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(35, 45, 97, 27);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("First Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(35, 139, 97, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLastName.setBounds(35, 241, 97, 14);
		panel_1.add(lblLastName);

		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPhoneNumber.setBounds(35, 345, 133, 14);
		panel_1.add(lblPhoneNumber);

		JLabel lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRank.setBounds(35, 446, 97, 14);
		panel_1.add(lblRank);

		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblpassword.setBounds(35, 528, 108, 14);
		panel_1.add(lblpassword);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < table.getRowCount(); i++) {

					managerObj.addToMemberList(new Members((String) GetData(table, i, 0), (String) GetData(table, i, 1),
							(String) GetData(table, i, 2), (String) GetData(table, i, 3), (String) GetData(table, i, 4),
							(String) GetData(table, i, 5)), i);

				}
				managerObj.countMembers = table.getRowCount();
				managerObj.writeToMembersFile();
			}
		});
	}
}
