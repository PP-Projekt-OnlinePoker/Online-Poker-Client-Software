package de.szut.onlinepoker.controller;

import java.io.IOException;
import java.net.InetAddress;

import de.szut.onlinepoker.communication.Protocoll;
import de.szut.onlinepoker.communication.RecieveHandler;
import de.szut.onlinepoker.communication.UpdateRecieveHandler;
import de.szut.onlinepoker.helper.Event;
import de.szut.onlinepoker.helper.TableConfiguration;
import de.szut.onlinepoker.model.Login;
import de.szut.onlinepoker.model.Register;
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
	
	private Controller(){
		
	}
	
	public static Controller getInstance(){
		if(inst==null){
			inst = new Controller();
		}
		return inst;
	}
	
	private void init(){
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
			//TODO login close, lobby open
		}else{
			error("Falscher Benutzername oder Kennwort");
		}
	}
	
	public void registerClicked(Register r){
		Event e = new Event(r.getUsername(), r.getPassword(), r.getEmail(), r.getRealName());
	}
	
	public void allInClicked(){
		Event e  = new Event()
	}
	
	public void foldClicked(){
		
	}
	
	public void callClicked(){
		
	}
	
	/**
	 * 
	 * @param amount raise by
	 */
	public void raiseCLicked(int amount){
		
	}
	
	public void logOutClicked(){
		
	}
	
	public void joinTable(int tableId){
		
	}
	
	public void updateTableListClicked(){
		
	}
	
	public void betClicked(int amount){
		
	}
	
	public void checkClicked(){
		
	}
	
	public void createTableClicked(){
		
	}
	
	public void createTable(TableConfiguration tc){
		
	}

	
	
	/**
	 * shows an error
	 * @param string error
	 */
	public void error(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
