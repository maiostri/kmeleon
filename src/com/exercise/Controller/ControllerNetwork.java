package com.exercise.Controller;

import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;

import com.exercise.Model.Alarm;
import com.exercise.Model.Network;

public class ControllerNetwork extends Controller {
	
	public ControllerNetwork() {
		super();		
	}
	
	public Vector<Network> getNetworks() {
		Vector<Network> vnetwork = new Vector<Network>();
		Cursor c = db.runSelectionQuery("network", new String[] {"name", "status", "time"},"id_network = "+network);
		while (!c.isLast()) {
			Network network = new Network(c.getString(0),c.getInt(1),c.getString(2));
			vnetwork.add(network);
			c.moveToNext();
		}	                
	    db.close();
	    return vnetwork;
	}
	
	public void insertNetwork(String name, int status, String time, int id_network) {
		ContentValues init = new ContentValues();
		init.put("name", name);
		init.put("status", status);
		init.put("time", time);
		db.insertIntoTable(init, "network");
	}
	
	public void updateNetwork(String name, int status, String time, int id) {
		ContentValues init = new ContentValues();
		init.put("name", name);
		init.put("status", status);
		init.put("time", time);
		db.updateFromTable(init, "alarm","name", id);
	}
	
	public void removeNetwork(String id) {
		db.deleteFromTable("network", "ssid",id);
	}
}
