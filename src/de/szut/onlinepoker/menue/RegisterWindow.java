package de.szut.onlinepoker.menue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class RegisterWindow {

	private JFrame frame;
	private JPasswordField passwordText;
	private JLabel registerLabel; 
	private JTextField mailText;
	private JTextField nameText;
	private JButton finishButton;
	private JButton cancelButton;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {		
					RegisterWindow window = new RegisterWindow();
					window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public RegisterWindow() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		registerLabel = new JLabel("Registieren");
		registerLabel.setBounds(182, 10, 68, 19);
		
		mailText = new JTextField("Mail Addresse");
		mailText.setBounds(132, 91, 165, 40);
		mailText.setColumns(10);
		
		nameText = new JTextField("Name");
		nameText.setBounds(132, 40, 165, 40);
		
		nameText.setColumns(10);
		
		passwordText = new JPasswordField("Password");
		passwordText.setBounds(132, 142, 165, 40);
		passwordText.setColumns(10);
		
		
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
		
		
		finishButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 System.out.println(passwordText.getText());
	         }          
	      });
				
	}
}
