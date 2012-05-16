package com.exercise.Controller;

import java.util.Vector;

import com.exercise.Database.DBAccess;
import com.exercise.Model.Alarm;

import android.content.ContentValues;
import android.database.Cursor;

public class ControllerAlarm extends Controller {
	
	public ControllerAlarm() {
		super();
	}
	
	public Vector<Alarm> getAlarms(Integer network) {
		Vector<Alarm> valarm = new Vector<Alarm>();
		Cursor c = db.runSelectionQuery("alarms", new String[] {"name", "status", "time"},"id_network = "+network);
		while (!c.isLast()) {        
			Alarm alarm = new Alarm(c.getString(0),c.getInt(1),c.getString(2));
			valarm.add(alarm);
			c.moveToNext();
		}	                
	    db.close();
	    return valarm;
	}
	
	public void insertAlarm(String name, int status, String time, int id_network) {
		ContentValues init = new ContentValues();
		init.put("name", name);
		init.put("status", status);
		init.put("time", time);
		db.insertIntoTable(init, "alarm");
	}
	
	public void updateAlarm(String name, int status, String time, int id) {
		ContentValues init = new ContentValues();
		init.put("name", name);
		init.put("status", status);
		init.put("time", time);
		db.updateFromTable(init, "alarm","name", id);
	}
	
	public void removeAlarm(int id) {
		db.deleteFromTable("alarm", "name",id);
	}
}
