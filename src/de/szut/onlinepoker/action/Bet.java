package de.szut.onlinepoker.action;

public class Bet {

	public int playerId;
	public int tableId;
	public int amount;
	public Bet(int playerId, int tableId, int amount) {
		this.playerId = playerId;
		this.tableId = tableId;
		this.amount = amount;
	}

}
