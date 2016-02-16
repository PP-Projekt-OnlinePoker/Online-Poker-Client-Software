package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

public class UpdateRecieveHandler implements Runnable{
	
	private BufferedReader reader;
	private boolean terminated;
	private JSONObject json;
	
	public UpdateRecieveHandler(InputStream in){
		
		reader = new BufferedReader(new InputStreamReader(in));
		
	}
	
	@Override
	public void run(){
		
		String update = null;
		
		while(!terminated){
			try {
				update = reader.readLine();
				
				//TODO handleUpdate
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			json = JSONObject.fromObject(update);
			
		}
		
	}
	
	public void stop(){
		terminated=true;
	}

}
