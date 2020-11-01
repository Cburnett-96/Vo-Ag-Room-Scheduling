import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class samplegui {

	private JFrame frmVoagCcsBuilding;
	private JLabel lblClock;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					samplegui window = new samplegui();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	public samplegui() {
		initialize();
		clock();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\admin\\Downloads\\Icons8-Ios7-Logos-Register-Editor.ico"));
		frmVoagCcsBuilding.setBounds(100, 100, 467, 284);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 461, 255);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		lblClock = new JLabel("");
		lblClock.setForeground(Color.GREEN);
		lblClock.setBounds(153, 32, 231, 26);
		panel.add(lblClock);
		lblClock.setFont(new Font("Times New Roman", Font.BOLD, 15));

		JButton btnNewButton = new JButton("View Schedule");
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Data-View-Details-icon.png"));
		btnNewButton.setBackground(new Color(255, 250, 250));
		btnNewButton.setBounds(28, 187, 174, 31);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.mainview();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JButton btnRoomLogin = new JButton("Room Login");
		btnRoomLogin.setBorderPainted(false);
		btnRoomLogin.setBorder(null);
		btnRoomLogin.setVerticalAlignment(SwingConstants.TOP);
		btnRoomLogin.setForeground(Color.BLACK);
		btnRoomLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				position.pos();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnRoomLogin.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnRoomLogin.setBackground(new Color(255, 250, 250));
		btnRoomLogin.setBounds(140, 145, 168, 31);
		panel.add(btnRoomLogin);
		btnRoomLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JButton btnUpdateSchedule = new JButton("Update Schedule");
		btnUpdateSchedule.setBorderPainted(false);
		btnUpdateSchedule.setBorder(null);
		btnUpdateSchedule.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Edit-icon.png"));
		btnUpdateSchedule.setForeground(Color.BLACK);
		btnUpdateSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_update.log();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnUpdateSchedule.setBackground(new Color(255, 250, 250));
		btnUpdateSchedule.setBounds(246, 187, 190, 31);
		panel.add(btnUpdateSchedule);
		btnUpdateSchedule.setFont(new Font("Comic Sans MS", Font.BOLD, 15));

		JLabel lblVoagRoomScheduling = new JLabel("Vo-Ag Room \r\nScheduling");
		lblVoagRoomScheduling.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Schedule-icon.png"));
		lblVoagRoomScheduling.setForeground(Color.WHITE);
		lblVoagRoomScheduling.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblVoagRoomScheduling.setBounds(10, 11, 426, 142);
		panel.add(lblVoagRoomScheduling);
	}
}
