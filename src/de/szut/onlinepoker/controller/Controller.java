package de.szut.onlinepoker.controller;

import java.io.IOException;
import java.net.InetAddress;

import de.szut.onlinepoker.action.GetTableList;
import de.szut.onlinepoker.action.JoinTable;
import de.szut.onlinepoker.action.LogOut;
import de.szut.onlinepoker.action.Login;
import de.szut.onlinepoker.action.Register;
import de.szut.onlinepoker.communication.Protocoll;
import de.szut.onlinepoker.communication.RecieveHandler;
import de.szut.onlinepoker.communication.UpdateRecieveHandler;
import de.szut.onlinepoker.helper.Event;
import de.szut.onlinepoker.helper.TableConfiguration;
import de.szut.onlinepoker.menue.LoginWindow;
import de.szut.onlinepoker.model.Table;
import net.sf.json.JSONObject;

public class Controller {

	private static Controller inst;
	private Protocoll p;
	private String ip;
	private int PORT = 4567;
	private RecieveHandler re;
	private UpdateRecieveHandler upre;
	private String answer;
	JSONObject json;
	private int playerId;
	
	private Controller(){
		
	}
	
	public static Controller getInstance(){
		if(inst==null){
			inst = new Controller();
		}
		return inst;
	}
	
	public void init(){
		ip = "127.0.0.1";
		try {
			p = new Protocoll(ip, PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		re = p.getRecieveHandler();
		upre = p.getUpdateRecieveHandler();
		new Thread(upre).start();
		
	}
	
	
	public void start(){
		
	}
	/**
	 * this method is called when loginbutton is clicked
	 * @param l
	 */
	public void loginClicked(Login l){
		Event e = new Event(l.getUsername(), l.getPassword());
		p.sendPacket(e.getJSONString());
		answer = re.waitForAnswer();
		json = JSONObject.fromObject(answer);
		boolean good = json.getBoolean(Event.EVENT_RESULT);
		if(good){
			playerId = json.getInt(Event.EVENT_PLAYERID);
			//TODO login close, lobby open
		}else{
			error(json.getString(Event.ERROR));
		}
	}
	
	public void registerClicked(Register r){
		Event e = new Event(r.getUsername(), r.getPassword(), r.getEmail(), r.getRealName());
		p.sendPacket(e.getJSONString());
		answer = re.waitForAnswer();
		json = JSONObject.fromObject(answer);
		boolean good = json.getBoolean(Event.EVENT_RESULT);
		if(good){
			//TODO login close, lobby open
		}else{
			error(json.getString(Event.ERROR));
		}
	}
	
	
		
	
	
	public void logOutClicked(){
		Event e = new Event(new LogOut(playerId));
		p.sendPacket(e.getJSONString());
		//TODO end
	}
	
	public void joinTable(int tableId, int stake){
		Event e = new Event(new JoinTable(tableId, playerId, stake));
		p.sendPacket(e.getJSONString());
		answer = re.waitForAnswer();
		json = JSONObject.fromObject(answer);
		boolean good = json.getBoolean(Event.EVENT_RESULT);
		if(good){
			//TODO tisch offnen, tablecontroller
		}else{
			error(json.getString(Event.ERROR));
		}
	}
	
	public void updateTableListClicked(){
		Event e = new Event(new GetTableList());
		p.sendPacket(e.getJSONString());
		answer = re.waitForAnswer();
		json = JSONObject.fromObject(answer);
		boolean good = json.getBoolean(Event.EVENT_RESULT);
		if(good){
			//TODO table list aktualisieren
		}else{
			error(json.getString(Event.ERROR));
		}
	}
	
		
	public void createTableClicked(){
		//TODO open createTableWindow
	}
	
	public void createTable(TableConfiguration tc){
		Event e = new Event(tc);
		p.sendPacket(e.getJSONString());
		answer = re.waitForAnswer();
		json = JSONObject.fromObject(answer);
		boolean good = json.getBoolean(Event.EVENT_RESULT);
		if(good){
			//TODO tisch offnen, tablecontroller
		}else{
			error(json.getString(Event.ERROR));
		}
	}

	
	
	/**
	 * shows an error
	 * @param string error
	 */
	public void error(String string) {
		LoginWindow.getInstance().displayError(string);
		
	}
	
	public Protocoll getProtocoll(){
		return p;
	}
	
	public static void main(String[] arg){
		Controller c = Controller.getInstance();
		c.init();
		c.start();
	}
}
