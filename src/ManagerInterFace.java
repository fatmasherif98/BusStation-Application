import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

public class ManagerInterFace extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerInterFace frame = new ManagerInterFace();
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
	public ManagerInterFace() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 429);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
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

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(205, 92, 92));
		panel_2.setBounds(36, 11, 632, 358);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bon Voyage");
		lblNewLabel.setForeground(new Color(255, 228, 196));
		lblNewLabel.setFont(new Font("Mistral", Font.BOLD, 81));
		lblNewLabel.setBounds(101, 40, 498, 126);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome To Manager Settings");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 40));
		lblNewLabel_1.setBounds(24, 116, 586, 189);
		panel_2.add(lblNewLabel_1);
	}
}
