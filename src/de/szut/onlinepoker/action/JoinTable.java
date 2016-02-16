package de.szut.onlinepoker.action;

public class JoinTable {

	public int tableId;
	public int playerId;
	public int stake;
	public JoinTable(int tableId, int playerId, int stake) {
		this.tableId = tableId;
		this.playerId = playerId;
		this.stake = stake;
	}

}
