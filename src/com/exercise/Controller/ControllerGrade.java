package com.exercise.Controller;

import java.util.Vector;

import android.content.ContentValues;
import android.database.Cursor;

import com.exercise.Model.Grade;

public class ControllerGrade extends Controller {

	public ControllerGrade() {
		super();
	}
	
	public Vector<Grade> getGrade(Integer network) {
		Vector<Grade> vgrade = new Vector<Grade>();
		Cursor c = db.runSelectionQuery("grade", 
				new String[] { "initial_time", 
								"final_time", 
								"day_of_week",
								"status",
								"time",								
								},"id_network = "+network);
		while (!c.isLast()) {        
			Grade grade = new Grade(c.getString(0),c.getString(0),c.getInt(2),c.getInt(3),c.getString(4));
			vgrade.add(grade);
			c.moveToNext();
		}	                
	    return vgrade;
	}
	
	public void insertGrade(String initial_time, String final_time, String day_of_week, int id_network) {
		ContentValues init = new ContentValues();
		init.put("initial_time", initial_time);
		init.put("final_time", final_time);
		init.put("day_of_week", day_of_week);
		init.put("id_network", id_network);
		db.insertIntoTable(init, "grade");
	}
	
	public void updateGrade(String initial_time, String final_time, String day_of_week, int id_network) {
		ContentValues init = new ContentValues();
		init.put("initial_time", initial_time);
		init.put("final_time", final_time);
		init.put("day_of_week", day_of_week);
		init.put("id_network", id_network);
		db.updateFromTable(init, "grade","id", id);
	}
	
	public void removeGrade(String id) {
		db.deleteFromTable("grade", "id",id);
	}
	
}
