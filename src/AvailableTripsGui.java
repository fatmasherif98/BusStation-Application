import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class AvailableTripsGui extends JFrame {

	Arrays array1 = new Arrays();
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AvailableTripsGui frame = new AvailableTripsGui();
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
	public Object GetData(JTable table, int row_index, int col_index) {
		return table.getModel().getValueAt(row_index, col_index);
	}

	public AvailableTripsGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 550);

		array1.readFromTripsFile();

		/*****************************************************************************/
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
		/***********************************************************************************/
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 220));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(250, 128, 114), 4, true), "Available Trips",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 128, 114)));
		panel.setBounds(10, 11, 550, 468);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnDisplayAvailableTrips = new JButton("Display Available Trips");
		btnDisplayAvailableTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDisplayAvailableTrips.setVisible(false);
				for (int j = 0; j < array1.countTrips; j++) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(
							new Object[] { array1.arrayOfTrips.get(j).getFrom(), array1.arrayOfTrips.get(j).getTo(),
									array1.arrayOfTrips.get(j).getTime(), array1.arrayOfTrips.get(j).getStops() });
				}
			}
		});
		btnDisplayAvailableTrips.setBounds(181, 180, 173, 64);
		panel.add(btnDisplayAvailableTrips);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 530, 436);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "From", "To", "Time", "Stops" }));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(250, 128, 114), 4, true));
		panel_1.setBounds(570, 11, 252, 468);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(101, 62, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(101, 150, 86, 20);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(101, 210, 86, 20);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(101, 300, 86, 20);
		panel_1.add(textField_3);

		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setBounds(31, 65, 46, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setBounds(31, 153, 46, 14);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setBounds(31, 213, 46, 14);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Stops");
		lblNewLabel_3.setBounds(31, 303, 46, 14);
		panel_1.add(lblNewLabel_3);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < table.getRowCount(); i++) {

					array1.addToTripsList(new Trips((String) GetData(table, i, 0), (String) GetData(table, i, 1),
							(String) GetData(table, i, 2), (String) GetData(table, i, 3)), i);
				}

				array1.countTrips = table.getRowCount();
				array1.writeToTripsFile();
			}
		});
		btnSave.setBounds(10, 390, 89, 23);
		panel_1.add(btnSave);

		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
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
					array1.removeFromAvailableTripsList(j);
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btnNewButton_1.setBounds(134, 390, 89, 23);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Add New Trip");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText(),

				});
			}
		});
		btnNewButton_2.setBounds(58, 434, 120, 23);
		panel_1.add(btnNewButton_2);

	}
}
