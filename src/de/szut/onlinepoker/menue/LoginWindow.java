package de.szut.onlinepoker.menue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.JLabel;

public class LoginWindow {
	private JFrame frame;
	private JLabel imageBackground;
	private JTextField nameText;
	private JTextField passText;

	public static void main(String[] args) {
		LoginWindow window = new LoginWindow();
		window.frame.setVisible(true);
	}
	public LoginWindow(){
		frame = new JFrame("Bremen Hold'em");
		frame.setBounds(100, 100, 610, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		imageBackground = new JLabel();
		imageBackground.setBounds(0, 0, 594, 362);
		
		imageBackground.setIcon(new ImageIcon("src/image/image.jpg"));
		
		
		nameText = new JTextField("Name");
		nameText.setColumns(10);
		nameText.setBounds(10, 315, 158, 36);
		
		
		passText = new JTextField("Password");
		passText.setBounds(178, 315, 158, 36);
		
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(346, 315, 114, 36);
		
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(470, 315, 114, 36);
		
		
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(passText);
		frame.getContentPane().add(registerButton);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(imageBackground);
		
	
		
		
		
		
	}
}
