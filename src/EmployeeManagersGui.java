import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeManagersGui extends JFrame {

	private ManagerLogic managerObj = new ManagerLogic();

	private JPanel contentPane;
	private JTable table;
	private JTextField textField4;
	private JTextField textField3;
	private JTextField textField2;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagersGui frame = new EmployeeManagersGui();
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
	public EmployeeManagersGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 699);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		/*********************************************************************/
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
		/*******************************************************************/

		managerObj.readFromManagersFile();

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(255, 255, 255), 3, true), "Manager's Information", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(21, 32, 712, 466);
		contentPane.add(panel);
		

		JButton btnShowManagers = new JButton("Show Managers Information");
		btnShowManagers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowManagers.setVisible(false);
				for (int j = 0; j < managerObj.countManagers; j++) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] { managerObj.managerArray.get(j).getFirstName(),
							managerObj.managerArray.get(j).getLastName(), managerObj.managerArray.get(j).getSalary(),
							managerObj.managerArray.get(j).getDepartment() });
				}
			}
		});
		btnShowManagers.setBounds(239, 223, 234, 61);
		panel.add(btnShowManagers);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 31, 692, 424);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "First Name", "Last Name", "Salary", "Department" }));

		textField4 = new JTextField();
		textField4.setBounds(550, 509, 166, 31);
		contentPane.add(textField4);
		textField4.setColumns(10);

		textField3 = new JTextField();
		textField3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(java.awt.event.KeyEvent evt) {
				char iNumber = evt.getKeyChar();
				if (!(Character.isDigit(iNumber)) || (iNumber == KeyEvent.VK_BACK_SPACE)
						|| (iNumber == KeyEvent.VK_DELETE)) {
					evt.consume();
				}
			}
		});
		textField3.setColumns(10);
		textField3.setBounds(374, 509, 166, 31);
		contentPane.add(textField3);

		textField2 = new JTextField();
		textField2.setColumns(10);
		textField2.setBounds(198, 509, 166, 31);
		contentPane.add(textField2);

		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(21, 509, 166, 31);
		contentPane.add(textField1);

		JButton btnSave = new JButton("save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				for (int i = 0; i < table.getRowCount(); i++) {

					managerObj
							.addToManagerList(new Managers((String) GetData(table, i, 0), (String) GetData(table, i, 1),
									(String) GetData(table, i, 2), (String) GetData(table, i, 3)), i);

				}
				managerObj.countManagers = table.getRowCount();
				managerObj.writeToManagersFile();
			}
		});
		btnSave.setBounds(21, 579, 166, 31);
		contentPane.add(btnSave);

		JButton btnDelete = new JButton("delete");
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
					managerObj.removeFromManagerList(j);
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnDelete.setBounds(198, 579, 164, 31);
		contentPane.add(btnDelete);

		JButton btnAddNewDriver = new JButton("Add NewManagver");
		btnAddNewDriver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textField1.getText(), textField2.getText(), textField3.getText(),
						textField4.getText()

				});

			}
		});
		btnAddNewDriver.setBounds(374, 579, 342, 31);
		contentPane.add(btnAddNewDriver);

		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(72, 554, 61, 14);
		contentPane.add(lblNewLabel);

		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(255, 554, 61, 14);
		contentPane.add(lblLastName);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setBounds(431, 551, 68, 14);
		contentPane.add(lblSalary);

		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(603, 554, 76, 14);
		contentPane.add(lblDepartment);
	}
}
