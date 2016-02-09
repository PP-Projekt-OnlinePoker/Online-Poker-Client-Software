package de.szut.onlinepoker.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import de.szut.onlinepoker.helper.CommWay;
import de.szut.onlinepoker.helper.Event;
import de.szut.onlinepoker.helper.PacketType;
import net.sf.json.JSONObject;

public class PacketSeperator implements Runnable {

	private InputStream in;
	private boolean terminated = false;
	private BufferedReader reader;
	JSONObject json;
	private PipedOutputStream ansPck;
	private PipedOutputStream upPck;
	private PipedInputStream ansIn;
	private PipedInputStream upIn;
	
	
	public PacketSeperator(InputStream input){
		in = input;
		reader = new BufferedReader(new InputStreamReader(in));
		ansPck = new PipedOutputStream();
		ansIn = new PipedInputStream();
		try {
			ansPck.connect(ansIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
		upPck = new PipedOutputStream();
		upIn = new PipedInputStream();
		try {
			upPck.connect(upIn);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		String answer;
		PacketType pt;
		CommWay cw;
		while(!terminated){

			try {
				answer = reader.readLine();
				json = JSONObject.fromObject(answer);
				 pt = (PacketType) json.get(Event.EVENT_PACKETTYPE);
				 cw = (CommWay) json.get(Event.EVENT_COMMWAY);
				 if(cw == CommWay.UPDATE){
					 upPck.write(answer.getBytes());
				 }else if(cw == CommWay.ANSWER){
					 ansPck.write(answer.getBytes());
				 }
				 
			} catch (IOException err) {
				err.printStackTrace();
			}
		}
		
	}
	
	public void stop(){
		terminated = true;
	}
	
	public PipedInputStream getAnswerPipe(){
		return ansIn;
	}
	
	public PipedInputStream getUpdatePipe(){
		return upIn;
		
	}
	
}
