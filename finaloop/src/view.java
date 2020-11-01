import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class view {

	private JFrame frmVoagCcsBuilding;

	public static void mainview() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view window = new view();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public view() {
		initialize();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setBounds(100, 100, 321, 287);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 315, 258);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnViewActiveRoom = new JButton("View Active Room");
		btnViewActiveRoom.setBorderPainted(false);
		btnViewActiveRoom.setBorder(null);
		btnViewActiveRoom.setForeground(Color.BLACK);
		btnViewActiveRoom.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Data-View-Details-icon.png"));
		btnViewActiveRoom.setBackground(new Color(255, 250, 250));
		btnViewActiveRoom.setBounds(58, 50, 190, 45);
		panel.add(btnViewActiveRoom);
		btnViewActiveRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewSchedule.main1(null);
				frmVoagCcsBuilding.dispose();
			}
		});
		btnViewActiveRoom.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnViewAllSchedule = new JButton("View All Room Schedule");
		btnViewAllSchedule.setBorderPainted(false);
		btnViewAllSchedule.setBorder(null);
		btnViewAllSchedule.setForeground(Color.BLACK);
		btnViewAllSchedule.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Data-View-Details-icon.png"));
		btnViewAllSchedule.setBackground(new Color(255, 250, 250));
		btnViewAllSchedule.setBounds(40, 117, 228, 45);
		panel.add(btnViewAllSchedule);
		btnViewAllSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				allsched.mainall();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnViewAllSchedule.setFont(new Font("Arial", Font.BOLD, 16));

		JButton btnBack = new JButton("Back");
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setForeground(Color.BLACK);
		btnBack.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		btnBack.setBackground(new Color(255, 250, 250));
		btnBack.setBounds(108, 188, 98, 34);
		panel.add(btnBack);
		
		JLabel lblNewLabel = new JLabel("View Schedule");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(92, 11, 130, 25);
		panel.add(lblNewLabel);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
	}
}
