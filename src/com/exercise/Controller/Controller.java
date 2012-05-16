package com.exercise.Controller;

import android.content.Context;

import com.exercise.Database.DBAccess;

public class Controller {
	protected DBAccess db;
	
	public Controller() {
		Context ctx = getApplicationContext();
		db = new DBAccess(ctx);
		db.open();		
	}	
		
}
