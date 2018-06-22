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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class ReservedTripsGui extends JFrame {

	Arrays array1 = new Arrays();
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservedTripsGui frame = new ReservedTripsGui();
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

	public ReservedTripsGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1065, 609);

		array1.readFromReservedTripsFile();

		/**********************************************************************************************/
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

		/************************************************************************************************/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(new LineBorder(new Color(25, 25, 112), 4, true), "Reserved Trips Information",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(25, 25, 112)));
		panel.setBounds(10, 11, 701, 527);
		contentPane.add(panel);
		panel.setLayout(null);

		
		JButton btnShowRTrips = new JButton("Display Reserved Trips");
		btnShowRTrips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnShowRTrips.setVisible(false);
				for (int j = 0; j < array1.countReservedTrips; j++) {

					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(new Object[] { array1.reservedTripsArray.get(j).getFrom(),
							array1.reservedTripsArray.get(j).getTo(), array1.reservedTripsArray.get(j).getVehicle(),
							array1.reservedTripsArray.get(j).getNumberOfStops(),
							array1.reservedTripsArray.get(j).getTypeOfTrip(),
							array1.reservedTripsArray.get(j).getTime(), array1.reservedTripsArray.get(j).getPrice(),
							array1.reservedTripsArray.get(j).getMemberId(),
							array1.reservedTripsArray.get(j).getDate() });

				}
			}
		});
		btnShowRTrips.setBounds(241, 154, 171, 97);
		panel.add(btnShowRTrips);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 22, 681, 494);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "From", "To", "Vehicle", "Stops",
				"Ticket Type", "Time", "Price", "Member ID", "Date" }));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(721, 11, 318, 527);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		textField = new JTextField();
		textField.setBounds(113, 25, 130, 20);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(113, 69, 130, 20);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(113, 116, 130, 20);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(113, 158, 130, 20);
		panel_1.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(113, 208, 130, 20);
		panel_1.add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(113, 254, 130, 20);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(113, 311, 130, 20);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(113, 358, 130, 20);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(113, 410, 130, 20);
		panel_1.add(textField_8);

		JLabel lblFrom = new JLabel("From");
		lblFrom.setBounds(34, 28, 46, 14);
		panel_1.add(lblFrom);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(34, 72, 46, 14);
		panel_1.add(lblTo);

		JLabel lblVehicle = new JLabel("Vehicle");
		lblVehicle.setBounds(34, 119, 46, 14);
		panel_1.add(lblVehicle);

		JLabel lblStops = new JLabel("Stops");
		lblStops.setBounds(34, 161, 46, 14);
		panel_1.add(lblStops);

		JLabel lblTicketType = new JLabel("Ticket Type");
		lblTicketType.setBounds(10, 211, 79, 14);
		panel_1.add(lblTicketType);

		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(34, 257, 46, 14);
		panel_1.add(lblTime);

		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(34, 314, 46, 14);
		panel_1.add(lblPrice);

		JLabel lblMemberId = new JLabel("Member ID");
		lblMemberId.setBounds(34, 361, 64, 14);
		panel_1.add(lblMemberId);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(34, 413, 46, 14);
		panel_1.add(lblDate);

		JButton btn1 = new JButton("Save");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < table.getRowCount(); i++) {

					array1.addToReservedTripsList(new ReservedTrips((String) GetData(table, i, 0),
							(String) GetData(table, i, 1), (String) GetData(table, i, 2), (String) GetData(table, i, 3),
							(String) GetData(table, i, 4), (String) GetData(table, i, 5),
							Double.parseDouble(GetData(table, i, 6).toString()), (String) GetData(table, i, 7),
							(String) GetData(table, i, 8)), i);

				}
				array1.countReservedTrips = table.getRowCount();
				array1.writeToReservedTripsFile();

			}
		});
		btn1.setBounds(10, 458, 89, 23);
		panel_1.add(btn1);

		JButton btn3 = new JButton("Add New Trip");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(new Object[] { textField.getText(), textField_1.getText(), textField_2.getText(),
						textField_3.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(),
						textField_7.getText(), textField_8.getText()

				});

			}
		});
		btn3.setBounds(88, 493, 148, 23);
		panel_1.add(btn3);

		JButton btn2 = new JButton("Delete");
		btn2.addActionListener(new ActionListener() {
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

					array1.removeFromReversedTripsList(j);
					model.removeRow(table.getSelectedRow());
				}
			}
		});
		btn2.setBounds(219, 458, 89, 23);
		panel_1.add(btn2);

	}
}
