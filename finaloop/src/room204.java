import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class room204 {

	private JFrame frame;
	private JTable table;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public static void rm204() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					room204 window = new room204();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public room204() {
		initialize();
		viewall();
	}

	public ArrayList<User> userList() {
		ArrayList<User> userList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccsrmschedule", "root", "");
			String sql = "select * from room_204";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			User user;

			while (rs.next()) {
				user = new User(rs.getString("Period"), rs.getString("Monday"), rs.getString("Tuesday"),
						rs.getString("Wednesday"), rs.getString("Thursday"), rs.getString("Friday"));
				userList.add(user);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		return userList;
	}

	public void viewall() {
		ArrayList<User> all = userList();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Object[] row = new Object[6];
		for (int i = 0; i < all.size(); i++) {
			row[0] = all.get(i).getPeriod();
			row[1] = all.get(i).getMonday();
			row[2] = all.get(i).getTuesday();
			row[3] = all.get(i).getWednesday();
			row[4] = all.get(i).getThursday();
			row[5] = all.get(i).getFriday();
			model.addRow(row);

		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allsched.mainall();
				frame.dispose();
			}
		});
		button.setBorderPainted(false);
		button.setBounds(0, 486, 89, 23);
		frame.getContentPane().add(button);

		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowMargin(0);
		table.setRowHeight(50);
		table.setOpaque(true);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		table.setEnabled(true);
		table.setBounds(new Rectangle(0, 0, 0, 0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setBounds(0, 14, 934, 495);
		frame.getContentPane().add(table);

		JLabel label = new JLabel("Period");
		label.setBounds(49, 0, 59, 14);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("Monday");
		label_1.setBounds(216, 0, 59, 14);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Tuesday");
		label_2.setBounds(366, 0, 59, 14);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Wednesday");
		label_3.setBounds(505, 0, 101, 14);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("Thursday");
		label_4.setBounds(676, 0, 59, 14);
		frame.getContentPane().add(label_4);

		JLabel label_5 = new JLabel("Friday");
		label_5.setBounds(838, 0, 59, 14);
		frame.getContentPane().add(label_5);
	}

}
