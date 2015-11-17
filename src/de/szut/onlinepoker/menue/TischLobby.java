package de.szut.onlinepoker.menue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

public class TischLobby {
	private JFrame frame;

	
	
	
	
	
	
	
	public static void main(String[] args) {		
		TischLobby window = new TischLobby();
		window.frame.setVisible(true);
}
	
	
	public TischLobby(){
		frame =  new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenuItem ausloggen = new JMenuItem("Ausloggen");
		JMenuItem tischErstellen = new JMenuItem("Tisch Erstellen");
		JMenuItem profil = new JMenuItem("Profil");
		
		
		
		menuBar.add(profil);
		menuBar.add(tischErstellen);
		menuBar.add(ausloggen);
				
		ausloggen.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 System.out.println("ausloggen");
	         }          
	      });		
	}
}
