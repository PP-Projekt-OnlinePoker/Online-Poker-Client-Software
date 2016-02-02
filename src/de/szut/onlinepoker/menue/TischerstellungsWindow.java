package de.szut.onlinepoker.menue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.JTextField;

import com.sun.corba.se.impl.encoding.CodeSetConversion.BTCConverter;

public class TischerstellungsWindow {

	public JFrame frame; 
	private JTextField textField;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TischerstellungsWindow window = new TischerstellungsWindow();
		window.frame.setVisible(true);

	}

	public TischerstellungsWindow(){
		frame =  new JFrame("Tisch Erstellung");
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel labelSpielerAnzahl = new JLabel("Spieler Anzahl");
		labelSpielerAnzahl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSpielerAnzahl.setBounds(10, 32, 200, 50);
		
		JLabel labelSmallBlind = new JLabel("Small Blind");
		labelSmallBlind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelSmallBlind.setBounds(10, 93, 200, 50);
		
		JLabel labelBigBlind = new JLabel("Big Blind");
		labelBigBlind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelBigBlind.setBounds(10, 154, 200, 50);
		
		JLabel labelTischName = new JLabel("Tisch Name");
		labelTischName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelTischName.setBounds(10, 215, 200, 50);
		
		JLabel labelMaxStartGeld = new JLabel("Maximales Start Geld");
		labelMaxStartGeld.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelMaxStartGeld.setBounds(10, 276, 200, 50);
		
		JButton buttonTischErstellen = new JButton("Tisch Erstellen");
		buttonTischErstellen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonTischErstellen.setBounds(10, 337, 200, 50);
		
		JButton buttonCancel = new JButton("Cancel");
		buttonCancel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		buttonCancel.setBounds(216, 337, 200, 50);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(216, 32, 200, 50);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(216, 93, 200, 50);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(216, 154, 200, 50);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(216, 276, 200, 50);
		
		JTextField textField = new JTextField("Tisch Name");
		textField.setBounds(216, 215, 200, 50);
		
		textField.setColumns(10);
		
		
		frame.getContentPane().add(labelSpielerAnzahl);
		frame.getContentPane().add(labelSmallBlind);
		frame.getContentPane().add(labelBigBlind);
		frame.getContentPane().add(labelTischName);
		frame.getContentPane().add(labelMaxStartGeld);
		frame.getContentPane().add(buttonTischErstellen);
		frame.getContentPane().add(buttonCancel);
		frame.getContentPane().add(spinner);
		frame.getContentPane().add(spinner_1);
		frame.getContentPane().add(spinner_2);
		frame.getContentPane().add(spinner_4);
		frame.getContentPane().add(textField);
		
		
	}
}
