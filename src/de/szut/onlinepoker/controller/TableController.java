package de.szut.onlinepoker.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import de.szut.onlinepoker.action.AllIn;
import de.szut.onlinepoker.action.Bet;
import de.szut.onlinepoker.action.Call;
import de.szut.onlinepoker.action.Fold;
import de.szut.onlinepoker.action.LeaveTable;
import de.szut.onlinepoker.action.Raise;
import de.szut.onlinepoker.communication.Protocoll;
import de.szut.onlinepoker.gui.GUI;
import de.szut.onlinepoker.helper.Event;
import net.sf.json.JSONObject;

public class TableController {

	private Protocoll p;
	private GUI ui;
	private final int ID;
	private final String TABLENAME;
	private BufferedReader in;
	private JSONObject json;
	private int playerId;
	
	public TableController(int id, String name, int playerId, InputStream input){
		ID= id;
		TABLENAME = name;
		this.playerId = playerId;
		in = new BufferedReader(new InputStreamReader(input));
		
		new Thread(new Runnable(){

			private boolean terminated;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				String packet = null;
				while(!terminated){
					try {
						packet = in.readLine();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					json = JSONObject.fromObject(packet);
					
				}
		
			}
		
		}).start();
	
	
	}
	
	public void call(){
		Event e = new Event(new Call(ID, playerId));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	public void raise(int amount){
		Event e = new Event(new Raise(playerId, ID, amount));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	public void fold(){
		Event e = new Event(new Fold(playerId, ID));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	public void allIn(){
		Event e = new Event(new AllIn(playerId, ID));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	public void bet(int amount){
		Event e = new Event(new Bet(playerId, ID, amount));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	public void leaveTable(){
		Event e = new Event(new LeaveTable(playerId, ID));
		Controller.getInstance().getProtocoll().sendPacket(e.getJSONString());
	}
	
	
	
	
	
	
	
}
