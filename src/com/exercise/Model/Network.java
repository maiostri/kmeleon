package com.exercise.Model;

import com.exercise.Database.DBAccess;

import android.content.ContentValues;

public class Network {

	private int id;
	private int status;
	private String ssid;
	private int numalarms;
	private DBAccess db;
	
	public Network(String ssid, DBAccess db) { 
		setDB(db);
		setSSID(ssid);
		ContentValues init = new ContentValues();
		init.put("ssid", this.ssid);
		this.db.insertIntoTable(init, "network");
	}
	
	public void Remove() {
		this.db.deleteFromTable("network", "id", this.id);
	}
	
	public void Update() {
		ContentValues update = new ContentValues();
		update.put("ssid", this.ssid);
		this.db.updateFromTable(update,"network", "id", this.id);
	}
	
	public void setID(int id) {		
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	
	public void setStatus(int status) {		
		this.status = status;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setSSID(String ssid) {
		this.ssid = ssid;
	}
	
	public String getSSID() {
		return this.ssid;
	}
	
	public void setDB(DBAccess db) {
		this.db = db;
	}
	
	public DBAccess getDB() {
		return this.db;
	}
	
	public void setNumAlarms(int numalarms) {
		this.numalarms = numalarms;
	}
	
	public int getNumAlarms() {
		return this.numalarms;
	}
	
	public void createAlarm(int hour) { }
	
	public void destroyAlarm(int hour) { }
	
}