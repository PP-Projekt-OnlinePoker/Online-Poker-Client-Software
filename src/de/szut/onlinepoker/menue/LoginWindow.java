package de.szut.onlinepoker.menue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import de.szut.onlinepoker.model.Player;

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
		
		passText = new JTextField("Password");
		passText.setBounds(178, 315, 158, 36);
		
		JButton registerButton = new JButton("Register");
		registerButton.setBounds(346, 315, 114, 36);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(470, 315, 114, 36);
		
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Player player = new Player(nameText.getName(), passText.getName());
				
				
				
				System.out.println("test");
			}
		}); 
		
		
		frame.getContentPane().add(nameText);
		frame.getContentPane().add(passText);
		frame.getContentPane().add(registerButton);
		frame.getContentPane().add(loginButton);
		frame.getContentPane().add(imageBackground);
		
	
		
		nameText.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent arg0) {
				if (nameText.getText().equals("Username")){
					nameText.setText("");
				}				
			}
			public void mouseEntered(MouseEvent arg0) {	}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		
		passText.addMouseListener(new MouseListener() {
			
			public void mouseClicked(MouseEvent arg0) {
				if (passText.getText().equals("Password")){
					passText.setText("");
				}				
			}
			public void mouseEntered(MouseEvent arg0) {	}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
		});
            
        
		
		
		
	}
}
