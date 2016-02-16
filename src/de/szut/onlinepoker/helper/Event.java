
package de.szut.onlinepoker.helper;

import java.net.Socket;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import de.szut.onlinepoker.action.AllIn;
import de.szut.onlinepoker.action.Bet;
import de.szut.onlinepoker.action.Call;
import de.szut.onlinepoker.action.Check;
import de.szut.onlinepoker.action.Fold;
import de.szut.onlinepoker.action.GetTableList;
import de.szut.onlinepoker.action.JoinTable;
import de.szut.onlinepoker.action.LeaveTable;
import de.szut.onlinepoker.action.LogOut;
import de.szut.onlinepoker.action.Raise;
import de.szut.onlinepoker.model.Player;
import de.szut.onlinepoker.model.Table;

public class Event {

	//JSON Keys
	public static final String EVENT_PACKETTYPE = "packettype";
	public static final String EVENT_PLAYERID = "playerId";
	public static final String EVENT_TABLEID = "tableId";
	public static final String EVENT_COMMWAY = "commway";
	public static final String EVENT_USERNAME = "username";
	public static final String EVENT_PASSWORD = "password";
	public static final String EVENT_EMAIL = "email";
	public static final String EVENT_NAME = "realname";
	public static final String EVENT_AMOUNT = "amount";
	public static final String EVENT_STAKE = "stake";
	public static final String EVENT_TABLENAME = "tablename";
	public static final String EVENT_RESULT = "result";
	public static final String EVENT_TABLES = "tables";
	public static final String MAX_BET = "maxbet";
	public static final String MAX_PLAYER = "maxplayer";
	public static final String SMALL_BLIND = "smallbind";
	public static final String ERROR = "error";
	
	private Integer tableId=null;
	private Integer playerId=null;
	private PacketType type=null;
	private JSONObject json=null;
	private CommWay commWay=null;
	private Player player=null;
	private Socket socket=null;
	private String error=null;
	private boolean result=false;
	private Integer amount=null;
	private Object email;
	private Object password;
	private Object username;
	
	/**
	 * Server constructor, when the server receives the Packet, this constructor is called.
	 * 
	 * @param json
	 * @param socket
	 */
	private Event(String json, Socket socket){
		this.json = JSONObject.fromObject(json);
		
		this.type = (PacketType) this.json.get(EVENT_PACKETTYPE);
		this.tableId = this.json.getInt(EVENT_TABLEID);
		this.playerId = this.json.getInt(EVENT_PLAYERID);
		this.commWay = (CommWay) this.json.get(EVENT_COMMWAY);
	}
	
	/**
	 * Get Table List constructor
	 * 
	 * @param tables The tables currently available 
	 * @param socket The socket from out client
	 */
	public Event(ArrayList<Table> tables){
		JSONArray arr = new JSONArray();
		JSONObject tableObj = new JSONObject();
		
		for(Table t: tables){
			tableObj.put(Event.EVENT_TABLEID, t.tablename);
			tableObj.put(Event.EVENT_TABLENAME, t.tableId);
			
			arr.add(tableObj);
			tableObj.clear();
		}
		
		this.json.put(Event.EVENT_RESULT, true);
		this.json.put(Event.EVENT_TABLES, arr);
	}
	
	/**
	 * Login constructor
	 * 
	 * @param type
	 * @param playerId
	 */
	public Event(String username, String password){
		this.player = new Player(username, password);
		this.type = PacketType.LOGIN;
		json.put(Event.EVENT_PACKETTYPE, PacketType.LOGIN);
		json.put(Event.EVENT_USERNAME, username);
		json.put(Event.EVENT_PASSWORD, password);
	}
	/**
	 * register
	 * @param username
	 * @param password
	 * @param email
	 * @param realname
	 */
	public Event(String username, String password, String email, String realname){
		this.player = new Player(username, password);
		player.eMail=email;
		player.setNachname(realname);
		type = PacketType.REGISTER;
		json.put(Event.EVENT_PACKETTYPE, PacketType.REGISTER);
		json.put(Event.EVENT_USERNAME, username);
		json.put(Event.EVENT_PASSWORD, password);
		json.put(Event.EVENT_EMAIL, email);
		json.put(Event.EVENT_NAME, realname);
	}
	
	/**
	 * Answer (bad) constructor
	 * @return
	 */
	public Event(Socket socket, String error){
		this.error = error;
		this.socket = socket;
		this.commWay = CommWay.ANSWER;
	}
	
	/**
	 * Answer (good) constructor
	 * @return
	 */
	public Event(){
		this.result = true;
		this.commWay = CommWay.ANSWER;
	}
	
	/**
	 * Call
	 * @param c
	 */
	public Event(Call c){
		json.put(Event.EVENT_PACKETTYPE, PacketType.CALL);
		json.put(Event.EVENT_PLAYERID, c.playerID);
		json.put(Event.EVENT_TABLEID, c.tableID);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Check
	 * @param c
	 */
	public Event(Check c){
		json.put(Event.EVENT_PACKETTYPE, PacketType.CHECK);
		json.put(Event.EVENT_PLAYERID, c.playerID);
		json.put(Event.EVENT_TABLEID, c.tableID);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Raise
	 * @param r
	 */
	public Event(Raise r){
		json.put(Event.EVENT_PACKETTYPE, PacketType.RAISE);
		json.put(Event.EVENT_PLAYERID, r.playerId);
		json.put(Event.EVENT_TABLEID, r.tableId);
		json.put(Event.EVENT_AMOUNT, r.amount);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Bet
	 * @param b
	 */
	public Event(Bet b){
		json.put(Event.EVENT_PACKETTYPE, PacketType.BET);
		json.put(Event.EVENT_PLAYERID, b.playerId);
		json.put(Event.EVENT_TABLEID, b.tableId);
		json.put(Event.EVENT_AMOUNT, b.amount);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Fold
	 * @param f
	 */
	public Event(Fold f){
		json.put(Event.EVENT_PACKETTYPE, PacketType.FOLD);
		json.put(Event.EVENT_PLAYERID, f.playerId);
		json.put(Event.EVENT_TABLEID, f.tableId);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Logout
	 * @param o
	 */
	public Event(LogOut o){
		json.put(Event.EVENT_PACKETTYPE, PacketType.LOGOUT);
		json.put(Event.EVENT_PLAYERID, o.playerId);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * AllIn
	 * @param a
	 */
	public Event(AllIn a){
		json.put(Event.EVENT_PACKETTYPE, PacketType.FOLD);
		json.put(Event.EVENT_PLAYERID, a.playerId);
		json.put(Event.EVENT_TABLEID, a.tableId);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	
	/**
	 * Create table
	 * @param tc
	 */
	public Event(TableConfiguration tc){
		json.put(Event.EVENT_PACKETTYPE, PacketType.CREATETABLE);
		json.put(Event.EVENT_TABLENAME, tc.getName());
		json.put(Event.MAX_BET, tc.getMaxBet());
		json.put(Event.MAX_PLAYER, tc.getMaxPlayer());
		json.put(Event.SMALL_BLIND, tc.getSmallBlind());
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	
	
	
	/**
	 * LeaveTable
	 * @param a
	 */
	public Event(LeaveTable a) {
		json.put(Event.EVENT_PACKETTYPE, PacketType.LEAVETABLE);
		json.put(Event.EVENT_PLAYERID, a.playerId);
		json.put(Event.EVENT_TABLEID, a.tableId);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * JoinTable
	 * @param jt
	 */
	public Event(JoinTable jt){
		json.put(Event.EVENT_PACKETTYPE, PacketType.JOINTABLE);
		json.put(Event.EVENT_PLAYERID, jt.tableId);
		json.put(Event.EVENT_TABLEID, jt.playerId);
		json.put(Event.EVENT_STAKE, jt.stake);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	/**
	 * Get Table List
	 * @param gtl
	 */
	public Event(GetTableList gtl){
		json.put(Event.EVENT_PACKETTYPE, PacketType.GETTABLELIST);
		json.put(Event.EVENT_COMMWAY, CommWay.REQUEST);
	}
	
	public static Event fromString(String json, Socket client){
		Event event = new Event(json, client);
		JSONObject obj = JSONObject.fromObject(json);
		
		switch(event.type){
		case ALLIN:
			break;
		case BET:
		case RAISE:
			event.amount = obj.getInt(EVENT_AMOUNT);
			break;
		case CALL:
			break;
		case CHECK:
			break;
		case CREATETABLE:
			break;
		case FOLD:
			break;
		case GETTABLELIST:
			break;
		case JOINTABLE:
			break;
		case LOGIN:
			Player player = new Player(obj.getString(EVENT_USERNAME), obj.getString(EVENT_PASSWORD));
			event.player = player;
			break;
		case LOGOUT:
			break;
		
		case REGISTER:
			break;
		case STATUS:
			break;
		default:
			break;
		}
		
		return event;
	}
	
	public String getJSONString(){
		
		return json.toString();
	}
	
	public PacketType getType(){
		return this.type;
	}
	
	public Integer getPlayerId(){
		return this.playerId;
	}
	
	public Integer getTableId(){
		return this.tableId;
	}
	
	private void setCommWay(CommWay comm){
		this.commWay = comm;
	}
	
	public Socket getClientSocket(){
		return socket;
	}
	/**
	 * To answer to the Event that occured.
	 * 
	 * @param e
	 * @throws CouldntAnswerException
	 */
	

	
}
