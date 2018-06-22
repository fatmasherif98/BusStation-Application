
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JPanel;

public class FrameUser1 {

	ArrayList<Trips> x = new ArrayList<Trips>();
	SearchFrom_To object1 = new SearchFrom_To();
	Calculateprice objOfCal = new Calculateprice();
	private String typeOfTrip;
	private String vehicle = "Bus";
	private String input;
	private Double cal;
	private String selected;

	public String getTypeOfTrip() {
		return typeOfTrip;
	}

	public void setTypeOfTrip(String typeOfTrip) {
		this.typeOfTrip = typeOfTrip;
	}

	public String getVehicle() {
		return vehicle;
	}

	public void setVehicle(String vehicle) {
		this.vehicle = vehicle;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public Double getCal() {
		return cal;
	}

	public void setCal(Double cal) {
		this.cal = cal;
	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	private JFrame BusStation;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void FrameUser1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameUser1 window = new FrameUser1();
					window.BusStation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrameUser1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		BusStation = new JFrame();
		BusStation.getContentPane().setBackground(new Color(255, 255, 255));
		BusStation.setBounds(100, 100, 902, 494);
		BusStation.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JComboBox cbEmpty = new JComboBox();
		cbEmpty.setBounds(159, 137, 205, 20);
		cbEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BusStation.getContentPane().setLayout(null);
		BusStation.getContentPane().add(cbEmpty);

		JComboBox cbTypeOfVehicleInternal = new JComboBox(); // will take type of vehicle internal
		cbTypeOfVehicleInternal.setBounds(159, 137, 171, 20);
		cbTypeOfVehicleInternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehicle = (String) cbTypeOfVehicleInternal.getSelectedItem();

			}
		});
		cbTypeOfVehicleInternal.setModel(new DefaultComboBoxModel(new String[] { "Bus", "Car", "Minibus" }));
		BusStation.getContentPane().add(cbTypeOfVehicleInternal);

		JComboBox cbTypeOfVehicleExternal = new JComboBox();
		cbTypeOfVehicleExternal.setBounds(159, 137, 171, 20);
		cbTypeOfVehicleExternal.setModel(new DefaultComboBoxModel(new String[] { "Bus" }));
		BusStation.getContentPane().add(cbTypeOfVehicleExternal);

		JComboBox cbHide = new JComboBox();
		cbHide.setBounds(345, 168, 122, 21);
		BusStation.getContentPane().add(cbHide);

		JComboBox cbHide2 = new JComboBox();
		cbHide2.setBounds(159, 168, 122, 21);
		BusStation.getContentPane().add(cbHide2);

		JComboBox cbFromInternal = new JComboBox();// will take FromInternal
		cbFromInternal.setBounds(159, 168, 122, 20);
		cbFromInternal
				.setModel(new DefaultComboBoxModel(new String[] { "", "Alexandria", "Asswan", "Cairo", "Tanta" }));
		BusStation.getContentPane().add(cbFromInternal);

		JComboBox cbFromExternal = new JComboBox();// will take fromExternal
		cbFromExternal.setBounds(159, 168, 122, 20);
		cbFromExternal
				.setModel(new DefaultComboBoxModel(new String[] { "", "Egypt/Cairo", "Lybya", "Palestine", "Soudan" }));
		BusStation.getContentPane().add(cbFromExternal);

		JDateChooser dateReturning = new JDateChooser();
		dateReturning.setBounds(159, 106, 205, 20);
		BusStation.getContentPane().add(dateReturning);
		JLabel bnTripType = new JLabel("Type Of Trip");
		bnTripType.setForeground(new Color(165, 42, 42));
		bnTripType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		bnTripType.setBounds(10, 11, 109, 30);
		BusStation.getContentPane().add(bnTripType);

		JComboBox cbtoExternal = new JComboBox(); // will take toExternal
		cbtoExternal.setBounds(345, 168, 122, 20);
		cbtoExternal
				.setModel(new DefaultComboBoxModel(new String[] { "", "Egypt/Cairo", "Lybya", "Palestine", "Soudan" }));
		BusStation.getContentPane().add(cbtoExternal);

		JLabel btnTicketType = new JLabel("Type of ticket");
		btnTicketType.setForeground(new Color(205, 92, 92));
		btnTicketType.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnTicketType.setBounds(10, 39, 109, 30);
		BusStation.getContentPane().add(btnTicketType);

		JComboBox cbToInternal = new JComboBox();// will take toInternal
		cbToInternal.setBounds(345, 168, 122, 20);
		cbToInternal.setModel(new DefaultComboBoxModel(new String[] { "", "Alexandria", "Asswan", "Cairo", "Tanta" }));
		BusStation.getContentPane().add(cbToInternal);
		boolean RoundTrip = true;

		JRadioButton rdbtnInternal = new JRadioButton("Internal");
		rdbtnInternal.setForeground(new Color(255, 255, 255));
		rdbtnInternal.setBackground(new Color(205, 92, 92));
		rdbtnInternal.setBounds(154, 15, 109, 23);
		rdbtnInternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cbtoExternal.setVisible(false);
				cbHide.setVisible(false);
				cbToInternal.setVisible(true);
				cbHide2.setVisible(false);
				cbFromExternal.setVisible(false);
				cbFromInternal.setVisible(true);
				cbTypeOfVehicleInternal.setVisible(true);
				cbTypeOfVehicleExternal.setVisible(false);
				cbEmpty.setVisible(false);

			}
		});
		buttonGroup_1.add(rdbtnInternal);
		BusStation.getContentPane().add(rdbtnInternal);

		JRadioButton rdbtnExternal = new JRadioButton("External");
		rdbtnExternal.setForeground(new Color(255, 255, 255));
		rdbtnExternal.setBackground(new Color(233, 150, 122));
		rdbtnExternal.setBounds(265, 15, 99, 23);
		rdbtnExternal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				cbToInternal.setVisible(false);
				cbHide.setVisible(false);
				cbtoExternal.setVisible(true);
				cbHide2.setVisible(false);
				cbFromExternal.setVisible(true);
				cbFromInternal.setVisible(false);

				cbTypeOfVehicleInternal.setVisible(false);
				cbTypeOfVehicleExternal.setVisible(true);
				cbEmpty.setVisible(false);

			}
		});
		buttonGroup_1.add(rdbtnExternal);
		BusStation.getContentPane().add(rdbtnExternal);

		JLabel lblNewLabel_1 = new JLabel("Travelling date");
		lblNewLabel_1.setForeground(new Color(165, 42, 42));
		lblNewLabel_1.setBounds(58, 80, 91, 14);
		BusStation.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_4 = new JLabel("From");
		lblNewLabel_4.setForeground(new Color(165, 42, 42));
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_4.setBounds(84, 165, 65, 20);
		BusStation.getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("To");
		lblNewLabel_5.setForeground(new Color(165, 42, 42));
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel_5.setBounds(297, 168, 45, 18);
		BusStation.getContentPane().add(lblNewLabel_5);

		JDateChooser dateTravelling = new JDateChooser();
		dateTravelling.setBounds(159, 75, 205, 20);
		dateTravelling.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		BusStation.getContentPane().add(dateTravelling);

		JLabel lblReturningDate = new JLabel("Returning date");
		lblReturningDate.setForeground(new Color(165, 42, 42));
		lblReturningDate.setBounds(58, 106, 109, 14);
		BusStation.getContentPane().add(lblReturningDate);

		JLabel lblTypeOfVehicle = new JLabel("TYPE OF VEHICLE:");
		lblTypeOfVehicle.setForeground(new Color(165, 42, 42));
		lblTypeOfVehicle.setFont(new Font("SansSerif", Font.PLAIN, 14));
		lblTypeOfVehicle.setBounds(10, 138, 139, 14);
		BusStation.getContentPane().add(lblTypeOfVehicle);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 295, 308, 145);
		BusStation.getContentPane().add(scrollPane);
		
				JList list_1 = new JList();
				scrollPane.setViewportView(list_1);

		JButton btnSavingChoises = new JButton("Load Available Trips!");
		btnSavingChoises.setBackground(new Color(220, 20, 60));
		btnSavingChoises.setForeground(new Color(255, 255, 255));
		btnSavingChoises.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnSavingChoises.setBounds(159, 228, 308, 41);
		btnSavingChoises.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String ToExternal = cbtoExternal.getSelectedItem().toString();
				String FromExternal = cbFromExternal.getSelectedItem().toString();

				String ToInternal = cbToInternal.getSelectedItem().toString();
				String FromInternal = cbFromInternal.getSelectedItem().toString();
				if (cbToInternal.isVisible()) {
					x = object1.Searching_From_To_Internal(FromInternal, ToInternal);

					DefaultListModel listModel = new DefaultListModel();
					for (int i = 0; i < x.size(); i++) {

						input = x.get(i).getFrom() + "-" + x.get(i).getTo() + "-" + x.get(i).getTime() + "-"
								+ x.get(i).getStops();
						listModel.addElement(input);
					}

					list_1.setModel(listModel);

				} else {
					x = object1.Searching_From_To_External(cbFromExternal.getSelectedItem().toString(),
							cbtoExternal.getSelectedItem().toString());

					DefaultListModel listModel = new DefaultListModel();
					for (int i = 0; i < x.size(); i++) {

						input = x.get(i).getFrom() + "-" + x.get(i).getTo() + "-" + x.get(i).getTime() + "-"
								+ x.get(i).getStops();
						listModel.addElement(input);

					}

					list_1.setModel(listModel);
				}

			}
		});
		BusStation.getContentPane().add(btnSavingChoises);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(509, 48, 367, 242);
		BusStation.getContentPane().add(textArea);

		JComboBox cbTypeOfTrip = new JComboBox();
		cbTypeOfTrip.setBackground(new Color(233, 150, 122));
		cbTypeOfTrip.setBounds(159, 46, 205, 20);
		cbTypeOfTrip.setModel(new DefaultComboBoxModel(new String[] { "", "Single Ticket", "Round Trip" }));
		BusStation.getContentPane().add(cbTypeOfTrip);

		cbTypeOfTrip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cbTypeOfTrip.getSelectedItem() == "Single Ticket") {
					dateReturning.setVisible(false);
					typeOfTrip = cbTypeOfTrip.getSelectedItem().toString();

				}

				if (cbTypeOfTrip.getSelectedItem() == "Round Trip") {
					dateReturning.setVisible(true);
					typeOfTrip = cbTypeOfTrip.getSelectedItem().toString();

				}
			}

		});

		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBackground(new Color(220, 20, 60));
		btnCalculate.setForeground(new Color(255, 255, 255));
		btnCalculate.setFont(new Font("SansSerif", Font.BOLD, 11));
		btnCalculate.setBounds(32, 295, 87, 66);
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				selected = (String) list_1.getSelectedValue();

				if (selected != null) {

					if (cbToInternal.isVisible()) {

						cal = objOfCal.readPriceFromFile_Internal(cbFromInternal.getSelectedItem().toString(),
								cbToInternal.getSelectedItem().toString(), typeOfTrip, vehicle);
						String[] line = selected.split("-");

						if (line[3].equals("No stop"))
							cal = cal + 50;

					} else {
						cal = objOfCal.readPriceFromFile_External(cbFromExternal.getSelectedItem().toString(),
								cbtoExternal.getSelectedItem().toString(), typeOfTrip, vehicle);
						String[] line = selected.split("-");
						if (line[3].equals("No stop"))
							cal = cal + 50;
					}
					textField.setText(cal.toString());
				} else {
					JOptionPane.showMessageDialog(BusStation, "Select a Trip First!");
				}

			}
		});
		BusStation.getContentPane().add(btnCalculate);

		textField = new JTextField();
		textField.setBounds(32, 361, 87, 79);
		BusStation.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(233, 150, 122));
		separator.setBackground(new Color(105, 105, 105));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(497, 0, 2, 461);
		BusStation.getContentPane().add(separator);
		
		JLabel lblNewLabel = new JLabel("Your Trip's Information");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 17));
		lblNewLabel.setBounds(591, 13, 224, 24);
		BusStation.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 150, 122));
		panel.setBounds(497, 295, 389, 166);
		BusStation.getContentPane().add(panel);
		panel.setLayout(null);
				
						JButton btnSave = new JButton("Save");
						btnSave.setFont(new Font("SansSerif", Font.PLAIN, 17));
						btnSave.setBackground(new Color(220, 20, 60));
						btnSave.setBounds(69, 32, 265, 49);
						panel.add(btnSave);
						btnSave.setForeground(new Color(255, 255, 255));
						btnSave.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								selected = (String) list_1.getSelectedValue();
								Arrays array1 = new Arrays();
								array1.readFromReservedTripsFile();
								String[] list = selected.split("-");
								DateFormat dateFormat = new SimpleDateFormat("MMM/d/yyyy");
								String date = dateFormat.format(dateTravelling.getDate());

								array1.addToReservedTripsList(new ReservedTrips(list[0], list[1], list[2], list[3], vehicle, typeOfTrip,
										cal, StaticClass.currentMemberID, date));
								array1.writeToReservedTripsFile();

								textArea.setText("Your Trip Has Been Save!");
								String info = "\nFrom: " + list[0] + "\nTo: " + list[1];
								info += "\nTime " + list[2] + "\nStops: " + list[3] + "\nVehicle: " + vehicle;
								info += "\nType Of Trip: " + typeOfTrip + "\nPrice: " + cal.toString() + "LE";
								textArea.setText(textArea.getText() + info);

							}
						});
		
				JButton btnReset = new JButton("Reset");
				btnReset.setFont(new Font("SansSerif", Font.PLAIN, 17));
				btnReset.setBackground(new Color(220, 20, 60));
				btnReset.setBounds(212, 87, 122, 53);
				panel.add(btnReset);
				btnReset.setForeground(new Color(255, 255, 255));
				
						JButton btnExit = new JButton("Exit");
						btnExit.setFont(new Font("SansSerif", Font.PLAIN, 17));
						btnExit.setForeground(new Color(255, 255, 255));
						btnExit.setBackground(new Color(220, 20, 60));
						btnExit.setBounds(71, 87, 133, 53);
						panel.add(btnExit);
						btnExit.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								BusStation = new JFrame("Exit");
								if (JOptionPane.showConfirmDialog(BusStation, "Confirm if you want to Exit", "Ticketing system",
										JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
									System.exit(0);
								}

							}
						});
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						dateTravelling.setDate(null);
						dateReturning.setDate(null);

						rdbtnInternal.setSelected(false);
						rdbtnExternal.setSelected(false);
						cbTypeOfVehicleInternal.setSelectedItem(null);
						cbTypeOfVehicleExternal.setSelectedItem(null);
						cbFromInternal.setSelectedItem(null);
						cbToInternal.setSelectedItem(null);
						cbFromExternal.setSelectedItem(null);
						cbtoExternal.setSelectedItem(null);
						textField.setText(null);
						textArea.setText(null);

					}
				});

	}
}
