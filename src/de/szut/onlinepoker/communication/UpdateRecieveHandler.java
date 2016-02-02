package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class UpdateRecieveHandler implements Runnable{
	
	private BufferedReader reader;
	private boolean terminated;
	
	
	public UpdateRecieveHandler(InputStream in){
		
		reader = new BufferedReader(new InputStreamReader(in));
		
	}
	
	@Override
	public void run(){
		
		String update;
		
		while(!terminated){
			try {
				update = reader.readLine();
				
				//TODO handleUpdate
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
