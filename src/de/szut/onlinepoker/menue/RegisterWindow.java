package de.szut.onlinepoker.menue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import de.szut.onlinepoker.action.Register;
import de.szut.onlinepoker.controller.Controller;

public class RegisterWindow {

	private JFrame frame;
	private JPasswordField passwordText;
	private JLabel registerLabel; 
	private JTextField mailText;
	private JTextField nameText;
	private JTextField usernameText;
	private JButton finishButton;
	private JButton cancelButton;
	
	private static RegisterWindow instance = null;
	
	public void clear(){
		nameText.setText("Name");
		usernameText.setText("Username");
		passwordText.setText("Password");
		mailText.setText("Mail Adresse");
	}
	
	public JFrame getFrame(){
		return frame;
	}
	
	public static RegisterWindow getInstance(){
		if(instance == null){
			instance = new RegisterWindow();
		}
		return instance;
	}

	/**
	 * Create the application.
	 */
	private RegisterWindow() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		registerLabel = new JLabel("Registrieren");
		registerLabel.setBounds(182, 0, 165, 19);
		
		nameText = new JTextField("Name");
		nameText.setBounds(132, 20, 165, 20);
		
		nameText.setColumns(10);
		
		usernameText = new JTextField("Username");
		usernameText.setBounds(132, 60, 165, 20);
		
		passwordText = new JPasswordField("Password");
		passwordText.setBounds(132, 100, 165, 20);
		passwordText.setColumns(10);
		
		mailText = new JTextField("Mail Addresse");
		mailText.setBounds(132, 140, 165, 20);
		mailText.setColumns(10);
		
		
		finishButton = new JButton("Finish");
		finishButton.setBounds(50, 193, 133, 47);
		
		cancelButton = new JButton("Cancel");
		cancelButton.setBounds(258, 193, 133, 47);
		
		
		frame.getContentPane().add(finishButton);
		frame.getContentPane().add(cancelButton);
		frame.getContentPane().add(mailText);
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(passwordText);
		frame.getContentPane().add(registerLabel);
		frame.getContentPane().add(usernameText);
		
		
		finishButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//create a register object
				Register register = new Register();
				register.setEmail(mailText.getText());
				register.setPassword(passwordText.getPassword().toString());
				register.setRealName(nameText.getText());
				register.setUsername(usernameText.getText());
				
				//give it to the controller for further processing
				Controller.getInstance().registerClicked(register);
				
				frame.setVisible(false);
				RegisterWindow.getInstance().clear();
			}          
	    });
		
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				RegisterWindow.getInstance().clear();
			}
		});
	}
}
