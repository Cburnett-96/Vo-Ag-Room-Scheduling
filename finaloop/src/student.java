import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class student {

	private JFrame frmVoagCcsBuilding;
	private JTextField textField_time;
	private JLabel lblclock;
	private JComboBox comboBox_room, comboBox_day;
	private JTextArea textArea;
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public static void stu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public student() {
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
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 444, 271);
		frmVoagCcsBuilding.getContentPane().add(panel);
		
		comboBox_day = new JComboBox();
		comboBox_day.setForeground(Color.BLACK);
		comboBox_day.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"}));
		comboBox_day.setName("");
		comboBox_day.setBorder(null);
		comboBox_day.setBackground(new Color(255, 250, 250));
		comboBox_day.setBounds(155, 66, 105, 20);
		panel.add(comboBox_day);
		
		comboBox_room = new JComboBox();
		comboBox_room.setForeground(Color.BLACK);
		comboBox_room.setModel(new DefaultComboBoxModel(new String[] {"room_101", "room_102", "room_103", "room_106", "room_107", "room_108", "room_201", "room_202", "room_203", "room_204", "room_205", "room_206", "room_207", "Old_HS_Lib"}));
		comboBox_room.setBorder(null);
		comboBox_room.setBackground(new Color(255, 250, 250));
		comboBox_room.setBounds(10, 66, 105, 20);
		panel.add(comboBox_room);
		
		JLabel label = new JLabel("Time Format(in - out)");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(85, 97, 194, 26);
		panel.add(label);
		
		textField_time = new JTextField();
		textField_time.setColumns(10);
		textField_time.setBackground(new Color(255, 250, 240));
		textField_time.setBounds(85, 123, 162, 20);
		panel.add(textField_time);
		
		JLabel lblReason = new JLabel("Reason:");
		lblReason.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblReason.setForeground(Color.BLACK);
		lblReason.setBounds(10, 200, 99, 20);
		panel.add(lblReason);
		
		JLabel lblName = new JLabel("Position:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setForeground(Color.BLACK);
		lblName.setBounds(10, 154, 99, 20);
		panel.add(lblName);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(65, 153, 194, 89);
		panel.add(textArea);
		
		JButton btnIn = new JButton("In");
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnIn.setForeground(Color.BLACK);
		btnIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField_time.getText().equals("") || textArea.getText().equals("")){
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
					pst.setString(1, textField_time.getText());
					pst.setString(2, textArea.getText());
					pst.executeUpdate();

					JOptionPane.showMessageDialog(null, "Insert Successfuly");
					textArea.setText("");
				} catch (SQLException | HeadlessException ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
				}
			}
		});
		btnIn.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Yes-icon.png"));
		btnIn.setBorderPainted(false);
		btnIn.setBorder(null);
		btnIn.setBackground(new Color(255, 250, 250));
		btnIn.setBounds(318, 56, 89, 40);
		panel.add(btnIn);
		
		JButton button_1 = new JButton("Main");
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(255, 250, 250));
		button_1.setForeground(Color.BLACK);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Very-Basic-Menu-icon.png"));
		button_1.setBorderPainted(false);
		button_1.setBorder(null);
		button_1.setBounds(318, 113, 89, 40);
		panel.add(button_1);
		
		JButton button_2 = new JButton("Back");
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setForeground(Color.BLACK);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				position.pos();
				frmVoagCcsBuilding.dispose();
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setBackground(new Color(255, 250, 250));
		button_2.setBounds(318, 169, 89, 40);
		panel.add(button_2);
		
		lblclock = new JLabel("");
		lblclock.setForeground(Color.GREEN);
		lblclock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblclock.setBounds(26, 11, 231, 26);
		panel.add(lblclock);
		
		JLabel label_1 = new JLabel("Name:");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(10, 178, 99, 20);
		panel.add(label_1);
		
	}
}
