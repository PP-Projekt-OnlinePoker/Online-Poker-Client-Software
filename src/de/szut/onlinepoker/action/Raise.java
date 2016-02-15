package de.szut.onlinepoker.action;

public class Raise {

	public int playerId;
	public int tableId;
	public int amount;
	public Raise(int playerId, int tableId, int amount) {
		this.playerId = playerId;
		this.tableId = tableId;
		this.amount = amount;
	}

}
