package com.exercise.AndroidNotifyService;

public class Alarm {

	private String name;
	private int status;
	private int hour;
	private int minute;
	private int sec;
	private int milisec;
	private int id;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	public int getStatus() {
		return this.status;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	public void setHour(int hour) { 
		this.hour = hour;
	}
	
	public int getHour() { 
		return this.hour;
	}	
	
	public void setMinute(int minute) { 
		this.minute = minute;
	}
	
	public int getMinute() { 
		return this.minute;
	}
	
	public void setSec(int sec) { 
		this.sec = sec;
	}
	
	public int getSec() { 
		return this.sec;
	}
	
	public void setMiliSec(int milisec) { 
		this.milisec = milisec;
	}
	
	public int getMiliSec() { 
		return this.milisec;
	}
}
