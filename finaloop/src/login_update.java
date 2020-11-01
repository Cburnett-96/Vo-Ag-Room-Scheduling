import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class login_update {

	private JFrame frmVoagCcsBuilding;
	private JTextField txtfuser;
	private JPasswordField passwordField;

	public static void log() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_update window = new login_update();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public login_update() {
		initialize();
	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setBounds(100, 100, 530, 256);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 524, 227);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBorderPainted(false);
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(new Color(255, 250, 250));
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(259, 162, 102, 36);
		panel.add(btnSubmit);

		JButton btnBack = new JButton("Back");
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(255, 250, 250));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(374, 162, 97, 36);
		panel.add(btnBack);

		passwordField = new JPasswordField();
		passwordField.setBounds(259, 111, 212, 20);
		panel.add(passwordField);

		txtfuser = new JTextField();
		txtfuser.setBounds(259, 65, 212, 20);
		panel.add(txtfuser);
		txtfuser.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setBounds(152, 62, 97, 23);
		panel.add(lblUsername);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(152, 108, 97, 23);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel label = new JLabel("");
		label.setBounds(0, 0, 141, 155);
		panel.add(label);
		label.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Schedule-icon.png"));
		
		JLabel lblUpdateRoomLogin = new JLabel("Update Room Login");
		lblUpdateRoomLogin.setForeground(Color.WHITE);
		lblUpdateRoomLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUpdateRoomLogin.setBounds(293, 11, 155, 26);
		panel.add(lblUpdateRoomLogin);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});

		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String uname = txtfuser.getText();
				String pass = passwordField.getText();

				if (uname.equals("ccsvoag") && pass.equals("ccsvoag")) {
					JOptionPane.showMessageDialog(frmVoagCcsBuilding, "Successfully Login!");
					updaterm.update();
					frmVoagCcsBuilding.dispose();
				} else if (txtfuser.getText().equals("") || passwordField.getText().equals("")) {
					JOptionPane.showMessageDialog(frmVoagCcsBuilding, "Please Input!");
				} else {
					JOptionPane.showMessageDialog(frmVoagCcsBuilding, "Incorrect Username or Password");
				}
			}
		});
	}
}
