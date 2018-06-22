
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class LoginFrame {

	private JFrame frame;
	private JTextField textField_1;
	private JButton btnNewButton_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
		Arrays arr1 = new Arrays();
		arr1.readFromTripsFile();
		
	}

	/**
	 * Create the application.
	 */
	public LoginFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(205, 92, 92));
		frame.setBounds(100, 100, 669, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(416, 214, 135, 20);
		frame.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel = new JLabel("UserID");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblNewLabel.setBounds(413, 114, 74, 20);
		frame.getContentPane().add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.BLACK);
		separator.setBounds(435, 172, 189, 13);
		frame.getContentPane().add(separator);
		
		


		textField_1 = new JTextField();
		textField_1.setBounds(435, 145, 189, 30);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.GRAY);
		separator_1.setBackground(Color.BLACK);
		separator_1.setBounds(435, 273, 189, 2);
		frame.getContentPane().add(separator_1);

		btnNewButton_1 = new JButton("Reset TextFields");
		btnNewButton_1.setBackground(new Color(220, 20, 60));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
				textField_1.setText(null);
			}
		});
		btnNewButton_1.setBounds(413, 420, 211, 30);
		frame.getContentPane().add(btnNewButton_1);

		passwordField = new JPasswordField();
		passwordField.setBounds(435, 245, 189, 30);
		frame.getContentPane().add(passwordField);
		
				JButton btnNewButton = new JButton("Login");
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnNewButton.setBounds(413, 342, 211, 50);
				frame.getContentPane().add(btnNewButton);
				btnNewButton.setOpaque(true);
				btnNewButton.setForeground(new Color(255, 255, 255));
				btnNewButton.setBackground(new Color(220, 20, 60));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String ID = textField_1.getText();
						String password = passwordField.getText();
						ManagerLogic managerObject = new ManagerLogic();
						managerObject.readPassWords();

						if (managerObject.passwordCheck(ID, password)) {

							StaticClass.currentMemberID = ID;
							FrameUser1 obj1 = new FrameUser1();
							obj1.FrameUser1();
							

						} else if (ID.equals("ADMIN") && password.equals("123")) {
							frame.setVisible(false);

							ManagerInterFace MIF = new ManagerInterFace();
							MIF.main();
						
							frame.dispose();

						} else {
							JOptionPane.showMessageDialog(null, "Invalid LogIn Details", "LogIn Error",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				});
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 386, 488);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/images/img3.jpg")));
		lblNewLabel_2.setBounds(0, -21, 391, 550);
		panel.add(lblNewLabel_2);
	}
}
