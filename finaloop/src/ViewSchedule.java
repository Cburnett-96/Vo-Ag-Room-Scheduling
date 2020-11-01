import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;

public class ViewSchedule {

	private JFrame frmVoagCcsBuilding;
	private JComboBox comboBox_room, comboBox_period, comboBox_day;
	private JLabel lblClock;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	private final JPanel panel = new JPanel();

	public static void main1(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSchedule window = new ViewSchedule();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewSchedule() {
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
						lblClock.setText(
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
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.getContentPane().setName("");
		frmVoagCcsBuilding.setBounds(100, 100, 523, 283);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JLabel lblRoomSelection = new JLabel("Room Active Selection");
		lblRoomSelection.setForeground(Color.WHITE);
		lblRoomSelection.setHorizontalAlignment(SwingConstants.CENTER);
		lblRoomSelection.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		lblRoomSelection.setBounds(38, 25, 422, 37);
		frmVoagCcsBuilding.getContentPane().add(lblRoomSelection);

		comboBox_room = new JComboBox();
		comboBox_room.setBorder(null);
		comboBox_room.setBackground(new Color(255, 250, 250));
		comboBox_room.setModel(new DefaultComboBoxModel(
				new String[] { "room_101", "room_102", "room_103", "room_106", "room_107", "room_108", "room_201",
						"room_202", "room_203", "room_204", "room_205", "room_206", "room_207", "old_hs_lib" }));
		comboBox_room.setBounds(54, 100, 105, 20);
		frmVoagCcsBuilding.getContentPane().add(comboBox_room);

		comboBox_period = new JComboBox();
		comboBox_period.addPopupMenuListener(new PopupMenuListener() {
			public void popupMenuCanceled(PopupMenuEvent arg0) {
			}

			public void popupMenuWillBecomeInvisible(PopupMenuEvent arg0) {
				String tmp = (String) comboBox_period.getSelectedItem();
				String sql = "select * from " + comboBox_room.getSelectedItem().toString() + " where Period=?";
				try {
					pst = con.prepareStatement(sql);
					pst.setString(1, tmp);
					rs = pst.executeQuery();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex);

				}
			}

			public void popupMenuWillBecomeVisible(PopupMenuEvent arg0) {
			}
		});
		comboBox_period.setBorder(null);
		comboBox_period.setBackground(new Color(255, 250, 250));
		comboBox_period.setBounds(346, 100, 110, 20);
		frmVoagCcsBuilding.getContentPane().add(comboBox_period);

		comboBox_day = new JComboBox();
		comboBox_day.setBorder(null);
		comboBox_day.setBackground(new Color(255, 250, 250));
		comboBox_day.setModel(
				new DefaultComboBoxModel(new String[] { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" }));
		comboBox_day.setName("");
		comboBox_day.setBounds(198, 100, 105, 20);
		frmVoagCcsBuilding.getContentPane().add(comboBox_day);

		JLabel lblNewLabel = new JLabel("Room List");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(54, 73, 105, 26);
		frmVoagCcsBuilding.getContentPane().add(lblNewLabel);

		JLabel lblPeriod = new JLabel("Time Period");
		lblPeriod.setForeground(Color.WHITE);
		lblPeriod.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPeriod.setBounds(346, 75, 110, 24);
		frmVoagCcsBuilding.getContentPane().add(lblPeriod);

		JLabel lblDay = new JLabel("Day");
		lblDay.setForeground(Color.WHITE);
		lblDay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDay.setBounds(198, 73, 91, 26);
		frmVoagCcsBuilding.getContentPane().add(lblDay);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 517, 254);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnMenu = new JButton("Main");
		btnMenu.setBorderPainted(false);
		btnMenu.setBorder(null);
		btnMenu.setForeground(Color.BLACK);
		btnMenu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnMenu.setBounds(206, 155, 105, 36);
		panel.add(btnMenu);
		btnMenu.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Very-Basic-Menu-icon.png"));
		btnMenu.setBackground(new Color(255, 250, 250));

		JButton btnSearch = new JButton("Search");
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setForeground(Color.BLACK);
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSearch.setBounds(81, 155, 109, 37);
		panel.add(btnSearch);
		btnSearch.setBackground(new Color(255, 250, 250));
		btnSearch.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Magnifier-icon.png"));

		JButton button_14 = new JButton("Back");
		button_14.setBorderPainted(false);
		button_14.setBorder(null);
		button_14.setForeground(Color.BLACK);
		button_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_14.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		button_14.setBackground(new Color(255, 250, 250));
		button_14.setBounds(327, 155, 105, 36);
		panel.add(button_14);

		lblClock = new JLabel("");
		lblClock.setForeground(Color.GREEN);
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblClock.setBounds(145, 202, 231, 26);
		panel.add(lblClock);

		JButton btnRefresh = new JButton("");
		btnRefresh.setBorder(null);
		btnRefresh.setBorderPainted(false);
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Refresh-icon.png"));
		btnRefresh.addActionListener(new ActionListener() {
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
				comboBox_period.removeAllItems();
				if (comboBox_room.getSelectedItem() == "room_101") {
					try {
						String sql = "select * from room_101";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception ew) {
						JOptionPane.showMessageDialog(null, ew);
					}
				}

				if (comboBox_room.getSelectedItem() == "room_102") {
					try {
						String sql = "select * from room_102";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception el) {
						JOptionPane.showMessageDialog(null, el);
					}
				}

				if (comboBox_room.getSelectedItem() == "room_103") {
					try {
						String sql = "select * from room_103";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_106") {
					try {
						String sql = "select * from room_106";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_107") {
					try {
						String sql = "select * from room_107";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_108") {
					try {
						String sql = "select * from room_108";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_201") {
					try {
						String sql = "select * from room_201";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_202") {
					try {
						String sql = "select * from room_202";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_203") {
					try {
						String sql = "select * from room_203";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_204") {
					try {
						String sql = "select * from room_204";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_205") {
					try {
						String sql = "select * from room_205";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_206") {
					try {
						String sql = "select * from room_206";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "room_207") {
					try {
						String sql = "select * from room_207";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
				if (comboBox_room.getSelectedItem() == "old_hs_lib") {
					try {
						String sql = "select * from old_hs_lib";
						pst = con.prepareStatement(sql);
						rs = pst.executeQuery();
						while (rs.next()) {
							String period = rs.getString("Period");
							comboBox_period.addItem(period);
						}
					} catch (Exception en) {
						JOptionPane.showMessageDialog(null, en);
					}
				}
			}
		});
		btnRefresh.setBounds(460, 96, 30, 26);
		panel.add(btnRefresh);
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.mainview();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox_room.getSelectedItem() == "room_102") {
					String sql = "select * from room_102 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_101") {
					String sql = "select * from room_101 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_103") {
					String sql = "select * from room_103 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_106") {
					String sql = "select * from room_106 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_107") {
					String sql = "select * from room_107 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_108") {
					String sql = "select * from room_108 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_201") {
					String sql = "select * from room_201 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_202") {
					String sql = "select * from room_202 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_203") {
					String sql = "select * from room_203 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_204") {
					String sql = "select * from room_204 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_205") {
					String sql = "select * from room_205 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_206") {
					String sql = "select * from room_206 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "room_207") {
					String sql = "select * from room_207 where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else if (comboBox_room.getSelectedItem() == "old_hs_lib") {
					String sql = "select * from old_hs_lib where Period=?";
					String tmp = (String) comboBox_period.getSelectedItem();
					try {
						pst = con.prepareStatement(sql);
						pst.setString(1, tmp);
						rs = pst.executeQuery();
						if (rs.next()) {
							String mon = rs.getString(comboBox_day.getSelectedItem().toString());
							JOptionPane.showMessageDialog(null, mon);
						} else if (comboBox_day.getSelectedItem().toString() != null) {
							JOptionPane.showMessageDialog(null, "No Classes");
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(null, ex);
					}
				} else {
					JOptionPane.showMessageDialog(null, "No Classes");
				}
			}
		});
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
	}
}
