package de.szut.onlinepoker.controller;

import de.szut.onlinepoker.model.Login;
import de.szut.onlinepoker.model.Register;
import de.szut.onlinepoker.model.Table;

public class Controller {

	private static Controller inst;
	
	private Controller(){
		
	}
	
	public static Controller getInstance(){
		if(inst==null){
			inst = new Controller();
		}
		return inst;
	}
	
	private void init(){
		
	}
	
	public void loginClicked(Login l){
		
	}
	
	public void registerClicked(Register r){
		
	}
	
	public void allInClicked(){
		
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
	
	public void createTable(Table t){
		
	}
	
}
