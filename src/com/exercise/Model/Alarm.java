package com.exercise.Model;

public class Alarm {

	private int id;
	private String name;
	private int status;
	private String time;
	private int id_network;
	
	public Alarm(String name, int status, String time, int id_network) {
		setName(name);
		setStatus(status);
		setTime(time);
		setIDNetwork(id_network);
	}
	
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
	
	public void setTime(String time) { 
		this.time = time;
	}
	
	public String getTime(String time) { 
		return this.time;
	}	
	
	public void setIDNetwork(int id_network) { 
		this.id_network = id_network;
	}
	
	public int getIDNetwork() { 
		return this.id_network;
	}
	
}