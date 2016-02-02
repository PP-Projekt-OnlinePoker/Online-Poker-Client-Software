package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class recieveHandler {
	
	private BufferedReader reader;
	
	public recieveHandler(InputStream input){
		
		reader = new BufferedReader(new InputStreamReader(input));
		
	}
	
	public String waitForAnswer() throws IOException{
		return reader.readLine();
	}
	
}
