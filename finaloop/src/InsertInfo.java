import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class InsertInfo {

	private JFrame frmVoagCcsBuilding;
	private JTextField txtftime;
	private JTextArea textArea;
	private JComboBox comboBox_day, comboBox_room;
	private JLabel lblclock;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public static void maininfo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertInfo window = new InsertInfo();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public InsertInfo() {
		initialize();
		clock();
	}

	public void clock() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while (true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int mon = cal.get(Calendar.MONTH);
						int yr = cal.get(Calendar.YEAR);
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hr = cal.get(Calendar.HOUR);
						lblclock.setText(
								"Time: " + hr + ":" + min + ":" + sec + " Date: " + mon + "/" + day + "/" + yr);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		clock.start();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setBounds(100, 100, 450, 300);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 444, 271);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		comboBox_day = new JComboBox();
		comboBox_day.setBorder(null);
		comboBox_day.setModel(
				new DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
		comboBox_day.setName("");
		comboBox_day.setBackground(new Color(255, 250, 250));
		comboBox_day.setBounds(161, 64, 105, 20);
		panel.add(comboBox_day);

		comboBox_room = new JComboBox();
		comboBox_room.setBorder(null);
		comboBox_room.setModel(new DefaultComboBoxModel(
				new String[] { "room_101", "room_102", "room_103", "room_106", "room_107", "room_108", "room_201",
						"room_202", "room_203", "room_204", "room_205", "room_206", "room_207", "Old_HS_Lib" }));
		comboBox_room.setBackground(new Color(255, 250, 250));
		comboBox_room.setBounds(10, 64, 105, 20);
		panel.add(comboBox_room);

		JLabel lblTime = new JLabel("Time Format(in - out)");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTime.setBounds(117, 81, 188, 33);
		panel.add(lblTime);

		txtftime = new JTextField();
		txtftime.setBackground(new Color(255, 250, 250));
		txtftime.setBounds(117, 113, 162, 20);
		panel.add(txtftime);
		txtftime.setColumns(10);

		JLabel lblNewLabel = new JLabel("Instructor: Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 179, 122, 20);
		panel.add(lblNewLabel);

		JLabel lblCodeSubject = new JLabel("Code Subject:");
		lblCodeSubject.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCodeSubject.setForeground(Color.BLACK);
		lblCodeSubject.setBounds(10, 155, 122, 20);
		panel.add(lblCodeSubject);

		JLabel lblCourseyrsection = new JLabel("Course/Yr/Section:");
		lblCourseyrsection.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCourseyrsection.setForeground(Color.BLACK);
		lblCourseyrsection.setBounds(10, 203, 122, 20);
		panel.add(lblCourseyrsection);

		textArea = new JTextArea();
		textArea.setBackground(new Color(255, 250, 250));
		textArea.setLineWrap(true);
		textArea.setBounds(133, 144, 146, 89);
		panel.add(textArea);

		JButton btnsubmit = new JButton("In");
		btnsubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnsubmit.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Yes-icon.png"));
		btnsubmit.setBorder(null);
		btnsubmit.setBorderPainted(false);
		btnsubmit.setBackground(new Color(255, 250, 250));
		btnsubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtftime.getText().equals("") || textArea.getText().equals("")) {
					JOptionPane.showMessageDialog(frmVoagCcsBuilding, "Please Input!");
				}

				else {
					try {
						Class.forName("com.mysql.jdbc.Driver");
					} catch (ClassNotFoundException ef) {
						ef.printStackTrace();
					}
					try {
						String sql = "INSERT INTO " + comboBox_room.getSelectedItem().toString() + "(Period, "
								+ comboBox_day.getSelectedItem().toString() + ") VALUES (?,?)";
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccsrmlog", "root", "");
						pst = con.prepareStatement(sql);
						pst.setString(1, txtftime.getText());
						pst.setString(2, textArea.getText());
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Insert Successfuly");

					} catch (SQLException | HeadlessException ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				}
			}
		});
		btnsubmit.setBounds(317, 64, 89, 40);
		panel.add(btnsubmit);

		JButton btnmenu = new JButton("Main");
		btnmenu.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnmenu.setBackground(new Color(255, 250, 250));
		btnmenu.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Very-Basic-Menu-icon.png"));
		btnmenu.setBorder(null);
		btnmenu.setBorderPainted(false);
		btnmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
		btnmenu.setBounds(317, 114, 89, 40);
		panel.add(btnmenu);

		JButton btnback = new JButton("Back");
		btnback.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnback.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		btnback.setBorder(null);
		btnback.setBorderPainted(false);
		btnback.setBackground(new Color(255, 250, 250));
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.log();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnback.setBounds(317, 162, 89, 40);
		panel.add(btnback);

		lblclock = new JLabel("");
		lblclock.setForeground(Color.GREEN);
		lblclock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblclock.setBounds(25, 11, 231, 26);
		panel.add(lblclock);
	}
}
