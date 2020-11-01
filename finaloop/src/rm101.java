import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class rm101 {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private JFrame frame;
	private JTable table;

	public static void rm101() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rm101 window = new rm101();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public rm101() {
		initialize();
		viewall();
	}

	public ArrayList<User> userList() {
		ArrayList<User> userList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccsrmschedule", "root", "");
			String sql = "select * from room_101";
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
		Object[] column = new Object[6];
		for (int i = 0; i < all.size(); i++) {
			column[0] = all.get(i).getPeriod();
			column[1] = all.get(i).getMonday();
			column[2] = all.get(i).getTuesday();
			column[3] = all.get(i).getWednesday();
			column[4] = all.get(i).getThursday();
			column[5] = all.get(i).getFriday();
			model.addRow(column);

		}

	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 950, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allsched.mainall();
				frame.dispose();
			}
		});
		btnBack.setBounds(0, 488, 89, 23);
		btnBack.setBorderPainted(false);
		frame.getContentPane().add(btnBack);

		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 10));
		table.setOpaque(true);
		table.setRowMargin(0);
		table.setRowHeight(50);
		table.setBounds(new Rectangle(0, 0, 0, 0));
		table.setEnabled(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column" }));
		table.setBounds(0, 16, 934, 495);
		frame.getContentPane().add(table);

		JLabel lblPeriod = new JLabel("Period");
		lblPeriod.setBounds(49, 2, 59, 14);
		frame.getContentPane().add(lblPeriod);

		JLabel lblMonday = new JLabel("Monday");
		lblMonday.setBounds(216, 2, 59, 14);
		frame.getContentPane().add(lblMonday);

		JLabel lblTuesday = new JLabel("Tuesday");
		lblTuesday.setBounds(366, 2, 59, 14);
		frame.getContentPane().add(lblTuesday);

		JLabel lblWednesday = new JLabel("Wednesday");
		lblWednesday.setBounds(505, 2, 101, 14);
		frame.getContentPane().add(lblWednesday);

		JLabel lblThursday = new JLabel("Thursday");
		lblThursday.setBounds(676, 2, 59, 14);
		frame.getContentPane().add(lblThursday);

		JLabel lblFriday = new JLabel("Friday");
		lblFriday.setBounds(838, 2, 59, 14);
		frame.getContentPane().add(lblFriday);
	}
}
