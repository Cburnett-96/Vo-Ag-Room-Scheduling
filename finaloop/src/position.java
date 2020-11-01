import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class position {

	private JFrame frmVoagCcsBuilding;

	public static void pos() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					position window = new position();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public position() {
		initialize();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setBounds(100, 100, 325, 290);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 319, 261);
		frmVoagCcsBuilding.getContentPane().add(panel);

		JButton btnInstructorstaff = new JButton("Instructor/Staff");
		btnInstructorstaff.setBorderPainted(false);
		btnInstructorstaff.setBorder(null);
		btnInstructorstaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.log();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnInstructorstaff.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Users-Administrator-icon.png"));
		btnInstructorstaff.setForeground(Color.BLACK);
		btnInstructorstaff.setFont(new Font("Arial", Font.BOLD, 16));
		btnInstructorstaff.setBackground(new Color(255, 250, 250));
		btnInstructorstaff.setBounds(58, 50, 190, 45);
		panel.add(btnInstructorstaff);

		JButton btnStudentvisitor = new JButton("Student/Visitor");
		btnStudentvisitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.stu();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnStudentvisitor.setBorderPainted(false);
		btnStudentvisitor.setBorder(null);
		btnStudentvisitor.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Teacher-icon.png"));
		btnStudentvisitor.setForeground(Color.BLACK);
		btnStudentvisitor.setFont(new Font("Arial", Font.BOLD, 16));
		btnStudentvisitor.setBackground(new Color(255, 250, 250));
		btnStudentvisitor.setBounds(51, 106, 207, 45);
		panel.add(btnStudentvisitor);

		JButton button_2 = new JButton("Back");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
		button_2.setBorderPainted(false);
		button_2.setBorder(null);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		button_2.setForeground(Color.BLACK);
		button_2.setBackground(new Color(255, 250, 250));
		button_2.setBounds(108, 216, 98, 34);
		panel.add(button_2);
		
		JLabel lblRoomLogin = new JLabel("Room Login");
		lblRoomLogin.setForeground(Color.WHITE);
		lblRoomLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRoomLogin.setBounds(100, 0, 126, 34);
		panel.add(lblRoomLogin);
		
		JButton btnout = new JButton("Room Out");
		btnout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				delete.out();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnout.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\delete-property-16.png"));
		btnout.setForeground(Color.BLACK);
		btnout.setFont(new Font("Arial", Font.BOLD, 16));
		btnout.setBorderPainted(false);
		btnout.setBorder(null);
		btnout.setBackground(new Color(255, 250, 250));
		btnout.setBounds(58, 159, 190, 45);
		panel.add(btnout);
	}
}
