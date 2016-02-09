package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.szut.onlinepoker.controller.Controller;

public class RecieveHandler {
	
	private BufferedReader reader;
	
	public RecieveHandler(InputStream input){
		
		reader = new BufferedReader(new InputStreamReader(input));
		
	}
	
	public String waitForAnswer() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Controller.getInstance().error("no connection to server");
		}
		return null;
	}
	
}
