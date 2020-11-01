import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class delete {

	private JFrame frmVoagCcsBuilding;
	private JComboBox cbtime, cbday, cbroom;
	private JTextArea textArea;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public static void out() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete window = new delete();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public delete() {
		initialize();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setBounds(100, 100, 523, 283);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JLabel lblRoomUpdateSelection = new JLabel("Room Out Selection");
		lblRoomUpdateSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomUpdateSelection.setForeground(Color.WHITE);
		lblRoomUpdateSelection.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblRoomUpdateSelection.setBounds(38, 25, 422, 37);
		frmVoagCcsBuilding.getContentPane().add(lblRoomUpdateSelection);

		cbroom = new JComboBox();
		cbroom.setModel(new DefaultComboBoxModel(
				new String[] { "room_101", "room_102", "room_103", "room_106", "room_107", "room_108", "room_201",
						"room_202", "room_203", "room_204", "room_205", "room_206", "room_207", "old_hs_lib" }));
		cbroom.setBorder(null);
		cbroom.setBackground(new Color(255, 250, 250));
		cbroom.setBounds(54, 100, 105, 20);
		frmVoagCcsBuilding.getContentPane().add(cbroom);

		cbtime = new JComboBox();
		cbtime.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				String tmp = (String) cbtime.getSelectedItem();
				String sql = "select * from " + cbroom.getSelectedItem().toString() + " where Period=?";
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, tmp);
					rs = pst.executeQuery();
					if (rs.next()) {
						String day = rs.getString(cbday.getSelectedItem().toString());
						textArea.setText(day);

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		cbtime.setBorder(null);
		cbtime.setBackground(new Color(255, 250, 250));
		cbtime.setBounds(346, 100, 110, 20);
		frmVoagCcsBuilding.getContentPane().add(cbtime);

		cbday = new JComboBox();
		cbday.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				String tmp = (String) cbtime.getSelectedItem();
				String sql = "select * from " + cbroom.getSelectedItem().toString() + " where Period=?";
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, tmp);
					rs = pst.executeQuery();
					if (rs.next()) {
						String time = rs.getString(cbday.getSelectedItem().toString());
						textArea.setText(time);

					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		cbday.setModel(
				new DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
		cbday.setName("");
		cbday.setBorder(null);
		cbday.setBackground(new Color(255, 250, 250));
		cbday.setBounds(198, 100, 105, 20);
		frmVoagCcsBuilding.getContentPane().add(cbday);

		JLabel label_1 = new JLabel("Room List");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(54, 73, 105, 26);
		frmVoagCcsBuilding.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("Time Period");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(346, 75, 110, 24);
		frmVoagCcsBuilding.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("Day");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_3.setBounds(198, 73, 91, 26);
		frmVoagCcsBuilding.getContentPane().add(label_3);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 517, 254);
		frmVoagCcsBuilding.getContentPane().add(panel);

		JButton btndelete = new JButton("Out");
		btndelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null,"Do you want to out?","Room-Out",JOptionPane.YES_NO_OPTION);
				if(textArea.getText().equals("")){
					JOptionPane.showMessageDialog(frmVoagCcsBuilding, "Please Input!");
				}
				else if(confirm == 0) {
				try {
					String sql = "DELETE from " + cbroom.getSelectedItem().toString() + " where Period='"
							+ cbtime.getSelectedItem().toString() + "'";
					pst = con.prepareStatement(sql);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Successfuly Out!");
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);
				}
			}
			}
		});
		btndelete.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\delete-property-16.png"));
		btndelete.setForeground(Color.BLACK);
		btndelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btndelete.setBorderPainted(false);
		btndelete.setBorder(null);
		btndelete.setBackground(new Color(255, 250, 250));
		btndelete.setBounds(402, 160, 105, 36);
		panel.add(btndelete);

		JButton btn_back = new JButton("Back");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				position.pos();
				frmVoagCcsBuilding.dispose();
			}
		});
		btn_back.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		btn_back.setForeground(Color.BLACK);
		btn_back.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_back.setBorderPainted(false);
		btn_back.setBorder(null);
		btn_back.setBackground(new Color(255, 250, 250));
		btn_back.setBounds(402, 207, 105, 36);
		panel.add(btn_back);

		JButton btn_refresh = new JButton("");
		btn_refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException ef) {
					ef.printStackTrace();
				}
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ccsrmlog", "root", "");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				cbtime.removeAllItems();
				if (cbroom.getSelectedItem() == "room_101") {
					try {
						String sql = "select * from room_101";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception ew) {
						JOptionPane.showMessageDialog(null, ew);
					}
				}

				if (cbroom.getSelectedItem() == "room_102") {
					try {
						String sql = "select * from room_102";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception el) {
						JOptionPane.showMessageDialog(null, el);
					}
				}

				if (cbroom.getSelectedItem() == "room_103") {
					try {
						String sql = "select * from room_103";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_106") {
					try {
						String sql = "select * from room_106";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_107") {
					try {
						String sql = "select * from room_107";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_108") {
					try {
						String sql = "select * from room_108";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_201") {
					try {
						String sql = "select * from room_201";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_202") {
					try {
						String sql = "select * from room_202";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_203") {
					try {
						String sql = "select * from room_203";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_204") {
					try {
						String sql = "select * from room_204";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_205") {
					try {
						String sql = "select * from room_205";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_206") {
					try {
						String sql = "select * from room_206";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "room_207") {
					try {
						String sql = "select * from room_207";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (cbroom.getSelectedItem() == "old_hs_lib") {
					try {
						String sql = "select * from old_hs_lib";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							cbtime.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
			}
		});
		btn_refresh.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Refresh-icon.png"));
		btn_refresh.setBorderPainted(false);
		btn_refresh.setBorder(null);
		btn_refresh.setBounds(460, 96, 30, 26);
		panel.add(btn_refresh);

		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(255, 250, 250));
		textArea.setBounds(201, 154, 146, 89);
		panel.add(textArea);

		JLabel label_4 = new JLabel("Code Subject:");
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(78, 165, 122, 20);
		panel.add(label_4);

		JLabel label_5 = new JLabel("Instructor: Name");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(78, 189, 122, 20);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Course/Yr/Section:");
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(78, 213, 122, 20);
		panel.add(label_6);
	}
}
