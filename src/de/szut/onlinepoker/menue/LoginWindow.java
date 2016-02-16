package de.szut.onlinepoker.menue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.szut.onlinepoker.action.Login;
import de.szut.onlinepoker.controller.Controller;
import de.szut.onlinepoker.model.Player;

public class LoginWindow {
	private JFrame frame;
	private JLabel imageBackground;
	private JTextField nameText;
	private JPasswordField passText;
	
	public final static String TITLE = "Bremen Hold'em";
	
	private static LoginWindow instance = null;

	public static void main(String[] args) {
		LoginWindow window = new LoginWindow();
		window.frame.setVisible(true);
	}
	
	public static LoginWindow getInstance(){
		if(instance == null){
			instance = new LoginWindow();
		}
		return instance;
	}
	
	public void displayError(String error){
		JOptionPane.showMessageDialog(frame, error, "Fehler", JOptionPane.ERROR_MESSAGE);
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	private LoginWindow(){
		frame = new JFrame(TITLE);
		
		frame.setResizable(false);
		frame.setBounds(100, 100, 610, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		imageBackground = new JLabel();
		imageBackground.setBounds(0, 0, 610, 400);
		
		imageBackground.setIcon(new ImageIcon("src/image/image.jpg"));
		
		nameText = new JTextField("Username");
		nameText.setColumns(10);
		nameText.setBounds(10, 315, 158, 36);
		
		passText = new JPasswordField("Password");
		passText.setBounds(178, 315, 158, 36);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(346, 315, 114, 36);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(470, 315, 114, 36);
		
		loginButton.setEnabled(false);
		
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {					
				Login login = new Login();
				login.setPassword(passText.getName());
				login.setUsername(nameText.getName());
				Controller.getInstance().loginClicked(login);			
			}
		});
		
		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterWindow.getInstance().getFrame().setVisible(true);;
				
			}
			
		});
		
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(passText);
		frame.getContentPane().add(registerButton);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(imageBackground);
		
		loginButton.requestFocus();
		
		nameText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent arg0) {
				if(nameText.getText().equals("Username")){
					nameText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(nameText.getText().length() == 0){
					nameText.setText("Username");
					loginButton.setEnabled(false);
				}else{
					if(String.valueOf(passText.getPassword()).length() != 0 && !String.valueOf(passText.getPassword()).equals("Password")){
						loginButton.setEnabled(true);
					}
				}
			}
		});
		
		passText.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passText.getPassword()).equals("Password")){
					passText.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passText.getPassword()).length() == 0){
					passText.setText("Password");
					loginButton.setEnabled(false);
				}else{
					if(nameText.getText().length() != 0 && !nameText.getText().equals("Username")){
						loginButton.setEnabled(true);
					}
				}
			}
			
		});
		
	}
}
