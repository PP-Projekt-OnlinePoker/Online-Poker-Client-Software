package de.szut.onlinepoker.action;

public class Fold {

	public int playerId;
	public int tableId;
	public Fold(int playerId, int tableId) {
		this.playerId = playerId;
		this.tableId = tableId;
	}

}
