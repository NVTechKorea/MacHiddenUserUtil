package CoreServices;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;

public class CoreNavigator {
	private JFrame frmVerstect;
	private JTextField realname;
	private JTextField loginID;
	private JTextField password;
	private JButton btnMakeHidden;
	private JButton btnHideUser;
	private JButton btnDestroyHiddenUser;
	private JLabel lblMessage;
	private JTextField supw;
	private JLabel lblMainLoginPassword;
	BufferedReader input;
	public static void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					print("Hello.");
					CoreNavigator window = new CoreNavigator();
					window.frmVerstect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public CoreNavigator() {
		initialize();
		print("Initialized.");
		run();
	}
	private void initialize() {
		frmVerstect = new JFrame();
		frmVerstect.getContentPane().setForeground(Color.DARK_GRAY);
		frmVerstect.setForeground(Color.DARK_GRAY);
		frmVerstect.setTitle("Verstect 1.7");
		frmVerstect.setBounds(100, 100, 259, 433);
		frmVerstect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmVerstect.getContentPane().setLayout(null);
		btnMakeHidden = new JButton("Make Hidden User");
		btnMakeHidden.setBounds(6, 96, 247, 29);
		frmVerstect.getContentPane().add(btnMakeHidden);
		btnHideUser = new JButton("Hide a User");
		btnHideUser.setBounds(6, 126, 247, 29);
		frmVerstect.getContentPane().add(btnHideUser);
		btnDestroyHiddenUser = new JButton("Destroy Hidden User");
		btnDestroyHiddenUser.setBounds(6, 155, 247, 29);
		frmVerstect.getContentPane().add(btnDestroyHiddenUser);
		JLabel lblNewLabel = new JLabel("Verstect");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 56));
		lblNewLabel.setBounds(6, 6, 247, 68);
		frmVerstect.getContentPane().add(lblNewLabel);
		JLabel label = new JLabel("1.7");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(6, 68, 40, 16);
		frmVerstect.getContentPane().add(label);
		realname = new JTextField();
		realname.setToolTipText("");
		realname.setBounds(6, 204, 247, 26);
		frmVerstect.getContentPane().add(realname);
		realname.setColumns(10);
		JLabel lblRealname = new JLabel("Realname");
		lblRealname.setBounds(16, 188, 97, 16);
		frmVerstect.getContentPane().add(lblRealname);
		loginID = new JTextField();
		loginID.setToolTipText("");
		loginID.setColumns(10);
		loginID.setBounds(6, 248, 247, 26);
		frmVerstect.getContentPane().add(loginID);
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setBounds(16, 232, 97, 16);
		frmVerstect.getContentPane().add(lblLoginId);
		password = new JTextField();
		password.setToolTipText("");
		password.setColumns(10);
		password.setBounds(6, 296, 247, 26);
		frmVerstect.getContentPane().add(password);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(16, 280, 97, 16);
		frmVerstect.getContentPane().add(lblPassword);
		lblMessage = new JLabel("Idle");
		lblMessage.setForeground(Color.BLACK);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setBounds(6, 375, 247, 16);
		frmVerstect.getContentPane().add(lblMessage);
		
		supw = new JTextField();
		supw.setToolTipText("");
		supw.setColumns(10);
		supw.setBounds(6, 337, 247, 26);
		frmVerstect.getContentPane().add(supw);
		
		lblMainLoginPassword = new JLabel("Superuser password");
		lblMainLoginPassword.setBounds(16, 323, 149, 15);
		frmVerstect.getContentPane().add(lblMainLoginPassword);
	}
	public void run() {
		print("Program is now ready.");
		btnMakeHidden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				testSudo();
			}
		});
		btnDestroyHiddenUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnHideUser.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
	public void testSudo() {
		String[] cmd = {"/bin/bash","sudo touch /testfile",supw.getText()};
	    Process pb;
		try {
			pb = Runtime.getRuntime().exec(cmd);
			String line;
			input = new BufferedReader(new InputStreamReader(pb.getInputStream()));
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void makeHidden() {
		
	}
	public void hide() {
		
	}
	public void destroy() {
		
	}
	public static void print(String print) {
		System.out.println("PROGRAM [INFO]: " + print);
	}
}
