package com.example.mock;

/**
 * This Greeting class has dependency to DBHelper.
 */
public class Greeting {
	private DBHelper dbh = null;
	
	public Greeting(DBHelper dbh) {
		this.dbh = dbh;
	}
	
	public String greetById(String user_id) {
		String sUserName = dbh.getUserNameById(user_id);
		return "Good day! " + sUserName + ".";
	}
}
