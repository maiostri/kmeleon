package com.exercise.AndroidNotifyService;

public class Network {

	private int status;
	private String ssid;
	private int numalarms;
	
	public Network(String ssid) { 
		// Search the file whose name is the same that the ssid network
		// If it doesn't exist, create it;
		Vector<Alarms>alarms = new Vector<Alarms>();
		
		// Populate the vector with the entries of the file
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
	
	public void setNumAlarms(int numalarms) {
		this.numalarms = numalarms;
	}
	
	public int getNumAlarms() {
		return this.numalarms;
	}
	
	public Alarm getAlarm(int id) { 
		
	}
	
	public void createAlarm(int hour) { }
	
	public void destroyAlarm(int hour) { }
	
}
