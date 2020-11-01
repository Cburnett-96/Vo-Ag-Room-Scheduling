
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.ImageIcon;

public class allsched {

	private JFrame frmVoagCcsBuilding;

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	public static void mainall() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					allsched window = new allsched();
					window.frmVoagCcsBuilding.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public allsched() {
		initialize();

	}

	private void initialize() {
		frmVoagCcsBuilding = new JFrame();
		frmVoagCcsBuilding.setResizable(false);
		frmVoagCcsBuilding.setTitle("Vo-Ag CCS Building Room Scheduling");
		frmVoagCcsBuilding.setBounds(100, 100, 603, 381);
		frmVoagCcsBuilding.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVoagCcsBuilding.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 597, 352);
		frmVoagCcsBuilding.getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnrm207 = new JButton("Room 207");
		btnrm207.setBorder(null);
		btnrm207.setBorderPainted(false);
		btnrm207.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room207.rm207();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm207.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm207.setBackground(new Color(255, 250, 250));
		btnrm207.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm207.setForeground(Color.BLACK);
		btnrm207.setBounds(373, 295, 119, 35);
		panel.add(btnrm207);

		JButton btnrm206 = new JButton("Room 206");
		btnrm206.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room206.rm206();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm206.setBorder(null);
		btnrm206.setBorderPainted(false);
		btnrm206.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm206.setBackground(new Color(255, 250, 250));
		btnrm206.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm206.setForeground(Color.BLACK);
		btnrm206.setBounds(439, 251, 119, 33);
		panel.add(btnrm206);

		JButton btnrm204 = new JButton("Room 204");
		btnrm204.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room204.rm204();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm204.setBorder(null);
		btnrm204.setBorderPainted(false);
		btnrm204.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm204.setBackground(new Color(255, 250, 250));
		btnrm204.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm204.setForeground(Color.BLACK);
		btnrm204.setBounds(439, 205, 119, 35);
		panel.add(btnrm204);

		JButton btnrm202 = new JButton("Room 202");
		btnrm202.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room202.rm202();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm202.setBorder(null);
		btnrm202.setBorderPainted(false);
		btnrm202.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm202.setBackground(new Color(255, 250, 250));
		btnrm202.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm202.setForeground(Color.BLACK);
		btnrm202.setBounds(439, 159, 119, 35);
		panel.add(btnrm202);

		JButton btnrm108 = new JButton("Room 108");
		btnrm108.setBorder(null);
		btnrm108.setBorderPainted(false);
		btnrm108.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room108.rm108();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm108.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm108.setBackground(new Color(255, 250, 250));
		btnrm108.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm108.setForeground(Color.BLACK);
		btnrm108.setBounds(439, 113, 119, 35);
		panel.add(btnrm108);

		JButton btnrm107 = new JButton("Room 107");
		btnrm107.setBorder(null);
		btnrm107.setBorderPainted(false);
		btnrm107.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room107.rm107();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm107.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm107.setBackground(new Color(255, 250, 250));
		btnrm107.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm107.setForeground(Color.BLACK);
		btnrm107.setBounds(310, 113, 119, 35);
		panel.add(btnrm107);

		JButton btnrm201 = new JButton("Room 201");
		btnrm201.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room201.rm201();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm201.setBorder(null);
		btnrm201.setBorderPainted(false);
		btnrm201.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm201.setBackground(new Color(255, 250, 250));
		btnrm201.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm201.setForeground(Color.BLACK);
		btnrm201.setBounds(310, 159, 119, 35);
		panel.add(btnrm201);

		JButton btnrm203 = new JButton("Room 203");
		btnrm203.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room203.rm203();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm203.setBorder(null);
		btnrm203.setBorderPainted(false);
		btnrm203.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm203.setBackground(new Color(255, 250, 250));
		btnrm203.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm203.setForeground(Color.BLACK);
		btnrm203.setBounds(310, 205, 119, 35);
		panel.add(btnrm203);

		JButton btnrm205 = new JButton("Room 205");
		btnrm205.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room205.rm205();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm205.setBorder(null);
		btnrm205.setBorderPainted(false);
		btnrm205.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm205.setBackground(new Color(255, 250, 250));
		btnrm205.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm205.setForeground(Color.BLACK);
		btnrm205.setBounds(310, 251, 119, 33);
		panel.add(btnrm205);

		JButton btnback = new JButton("Back");
		btnback.setBorder(null);
		btnback.setBorderPainted(false);
		btnback.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Arrow-Back-2-icon.png"));
		btnback.setBackground(new Color(255, 250, 250));
		btnback.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnback.setForeground(Color.BLACK);
		btnback.setBounds(170, 280, 102, 29);
		panel.add(btnback);

		JButton btnMainMenu = new JButton("Main");
		btnMainMenu.setBorder(null);
		btnMainMenu.setBorderPainted(false);
		btnMainMenu.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Very-Basic-Menu-icon.png"));
		btnMainMenu.setBackground(new Color(255, 250, 250));
		btnMainMenu.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMainMenu.setForeground(Color.BLACK);
		btnMainMenu.setBounds(55, 280, 102, 29);
		panel.add(btnMainMenu);

		JButton btnrmold = new JButton("Old HS Library");
		btnrmold.setBorder(null);
		btnrmold.setBorderPainted(false);
		btnrmold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oldlibrary.old();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrmold.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrmold.setBackground(new Color(255, 250, 250));
		btnrmold.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnrmold.setForeground(Color.BLACK);
		btnrmold.setBounds(63, 205, 187, 35);
		panel.add(btnrmold);

		JButton btnrm103 = new JButton("Room 103");
		btnrm103.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rm103.rm103();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm103.setBorder(null);
		btnrm103.setBorderPainted(false);
		btnrm103.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm103.setBackground(new Color(255, 250, 250));
		btnrm103.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm103.setForeground(Color.BLACK);
		btnrm103.setBounds(39, 159, 118, 35);
		panel.add(btnrm103);

		JButton btnrm101 = new JButton("Room 101");
		btnrm101.setBorder(null);
		btnrm101.setBorderPainted(false);
		btnrm101.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm101.setBackground(new Color(255, 250, 250));
		btnrm101.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm101.setForeground(Color.BLACK);
		btnrm101.setBounds(39, 113, 118, 35);
		panel.add(btnrm101);

		JButton btnrm102 = new JButton("Room 102");
		btnrm102.setBorder(null);
		btnrm102.setBorderPainted(false);
		btnrm102.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm102.setBackground(new Color(255, 250, 250));
		btnrm102.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm102.setForeground(Color.BLACK);
		btnrm102.setBounds(170, 113, 118, 35);
		panel.add(btnrm102);

		JButton btnrm106 = new JButton("Room 106");
		btnrm106.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room106.rm106();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm106.setBorder(null);
		btnrm106.setBorderPainted(false);
		btnrm106.setIcon(new ImageIcon("C:\\Users\\admin\\Downloads\\Door-icon.png"));
		btnrm106.setBackground(new Color(255, 250, 250));
		btnrm106.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnrm106.setForeground(Color.BLACK);
		btnrm106.setBounds(170, 159, 118, 35);
		panel.add(btnrm106);

		JLabel label = new JLabel("Normal Rooms");
		label.setForeground(Color.WHITE);
		label.setBounds(39, 70, 233, 32);
		panel.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel label_2 = new JLabel("Laboratory Rooms");
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(327, 69, 202, 35);
		panel.add(label_2);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Arial", Font.BOLD, 18));

		JLabel label_1 = new JLabel("Room List Selection");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(79, 22, 422, 37);
		panel.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
		btnrm102.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rm102.rm102();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnrm101.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rm101.rm101();
				frmVoagCcsBuilding.dispose();
			}
		});
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				samplegui.main(null);
				frmVoagCcsBuilding.dispose();
			}
		});
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.mainview();
				frmVoagCcsBuilding.dispose();
			}
		});
	}
}
