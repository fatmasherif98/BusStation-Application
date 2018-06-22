
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
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class DriversFrame extends JFrame {

	ManagerLogic managerObj = new ManagerLogic();

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriversFrame frame = new DriversFrame();
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
	public DriversFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 795, 759);

		/************************************************************************/
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
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				dispose();
				LoginFrame log = new LoginFrame();
				log.main(null);
			}
		});
		mnLogOut.add(mntmLogOut);

		/***************************************************************************************************/

		managerObj.readFromDriversFile();
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setForeground(new Color(220, 20, 60));
		panel.setBounds(10, 11, 764, 518);
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 4), "Drivers Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		contentPane.add(panel);

		JButton btnNewButton = new JButton("Display Drivers!");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(233, 150, 122));
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setVisible(false);
				for (int j = 0; j < managerObj.countDrivers; j++) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] { managerObj.driverArray.get(j).getFirstName(),
							managerObj.driverArray.get(j).getLastName(), managerObj.driverArray.get(j).getSalary(),
							managerObj.driverArray.get(j).getNumberOfKilos(),
							managerObj.driverArray.get(j).getVehicle() });
				}

			}
		});
		btnNewButton.setBounds(213, 277, 408, 65);
		panel.add(btnNewButton);

		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 744, 484);
		panel.add(scrollPane);

		table = new JTable();
		table.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(table);

		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "First Name", "Last Name", "Salary", "Number Of Kilos", "Vehicle" }));
		table.getColumnModel().getColumn(3).setPreferredWidth(78);
		table.getColumnModel().getColumn(3).setMinWidth(21);

		JButton btnSave = new JButton("Save");
		btnSave.setBackground(new Color(233, 150, 122));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < table.getRowCount(); i++) {

					managerObj.addToDriverList(new Drivers((String) GetData(table, i, 0), (String) GetData(table, i, 1),
							(String) GetData(table, i, 2), (String) GetData(table, i, 3),
							(String) GetData(table, i, 4)), i);

				}
				managerObj.countDrivers = table.getRowCount();
				managerObj.writeToDriversFile();

			}
		});
		btnSave.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnSave.setBounds(34, 531, 249, 23);
		contentPane.add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(233, 150, 122));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getRowCount() == 0) {

						JOptionPane.showMessageDialog(null, "No data to delete");
					} else {
						JOptionPane.showMessageDialog(null, "Select a row to delete");
					}
				} else {
					int j = table.getSelectedRow();
					managerObj.removeFromDriverList(j);
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnDelete.setBounds(293, 531, 203, 23);
		contentPane.add(btnDelete);

		JButton btnAddNewDriver = new JButton("Add New Driver");
		btnAddNewDriver.setBackground(new Color(233, 150, 122));
		btnAddNewDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText()

				});
			}
		});
		btnAddNewDriver.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnAddNewDriver.setBounds(506, 531, 249, 23);
		contentPane.add(btnAddNewDriver);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setForeground(new Color(205, 92, 92));
		panel_1.setBorder(null);
		panel_1.setBounds(0, 565, 769, 102);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 54, 137, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 54, 137, 20);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char iNumber = evt.getKeyChar();
				if (!(Character.isDigit(iNumber)) || (iNumber == KeyEvent.VK_BACK_SPACE)
						|| (iNumber == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(304, 54, 137, 20);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char iNumber = evt.getKeyChar();
				if (!(Character.isDigit(iNumber)) || (iNumber == KeyEvent.VK_BACK_SPACE)
						|| (iNumber == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(451, 54, 137, 20);
		panel_1.add(textField_3);

		JLabel lblFirstName_1 = new JLabel("First Name");
		lblFirstName_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblFirstName_1.setBounds(42, 40, 75, 14);
		panel_1.add(lblFirstName_1);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblLastName.setBounds(184, 40, 75, 14);
		panel_1.add(lblLastName);

		JLabel lblSalary_1 = new JLabel("Salary");
		lblSalary_1.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblSalary_1.setBounds(336, 40, 75, 14);
		panel_1.add(lblSalary_1);

		JLabel lblNumberOfKilometes = new JLabel("Number Of Kilometers");
		lblNumberOfKilometes.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblNumberOfKilometes.setBounds(451, 40, 151, 14);
		panel_1.add(lblNumberOfKilometes);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(598, 54, 137, 20);
		panel_1.add(textField_4);

		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblVehicle.setBounds(625, 40, 75, 14);
		panel_1.add(lblVehicle);

	}
}
