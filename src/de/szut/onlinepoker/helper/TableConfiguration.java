package de.szut.onlinepoker.helper;


/**
 * Configuration Class for Table
 * @author dqi12brinkmann
 *
 */
public class TableConfiguration {

	private int maxBet;
	private int maxPlayer;
	private int ID;
	private int smallBlind;
	private String name;
	public int getMaxBet() {
		return maxBet;
	}
	
	/**
	 * maximum Bet a player can make in on bet/raise
	 * 0 means unlimited
	 * @param maxBet
	 */
	public void setMaxBet(int maxBet) {
		this.maxBet = maxBet;
	}
	public int getMaxPlayer() {
		return maxPlayer;
	}
	
	/**
	 * maxmimum Number of Players 
	 * @param maxPlayer
	 */
	public void setMaxPlayer(int maxPlayer) {
		this.maxPlayer = maxPlayer;
	}
	public int getID() {
		return ID;
	}
	
	/**
	 * id the table gets. should be unique
	 * @param iD
	 */
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getSmallBlind() {
		return smallBlind;
	}
	
	/**
	 * smallBlind. Bigblind implicit
	 * @return
	 */
	public void setSmallBlind(int smallBlind) {
		this.smallBlind = smallBlind;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
}
