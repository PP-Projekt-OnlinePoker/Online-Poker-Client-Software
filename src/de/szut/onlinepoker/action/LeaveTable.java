package de.szut.onlinepoker.action;

public class LeaveTable {
	
	public int playerId;
	public int tableId;
	public LeaveTable(int playerId, int tableId) {
		this.playerId = playerId;
		this.tableId = tableId;
	}
	
}
