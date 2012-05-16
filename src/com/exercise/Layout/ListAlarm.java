package com.exercise.Layout;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Pair;
import android.widget.ListView;

import com.exercise.AndroidNotifyService.R;
import com.exercise.Database.DBAccess;
import com.exercise.Model.Alarm;

public class ListAlarm extends Activity {
	  @Override
	    public void onCreate(Bundle savedInstanceState, String network) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.list_alarm);
	        
	        // Startup the alarm list
	        ListView Alarms = (ListView) findViewById(R.id.lvAlarms);
	        Context context = getApplicationContext();
	        DBAccess db = new DBAccess(context);
	        db.open();
	        // query selection
	        Cursor c = db.runSelectionQuery("alarms",
	        					new String[] {"name", "status", "time"},
	        					"id_network = "+network,
	        					null, null, null, null);
	        
	        ArrayList<Alarm> alist = new ArrayList<Alarm>();
	        while (!c.isLast()) {
	        	alist.add(object)
	        	
	        	
	        	
	        }
	        
	new ArrayList<Alarm>(Arrays.asList(array))
	List<ClassName> list = Arrays.asList(array)
        
	
	ArrayList itemList = new ArrayList<ArrayList<Pair<Integer, String>>;
	        itemList.add(object)
	        		
	        //@todo item list carregar banco
	        
			ListAlarmAdapter list1 = new ListAlarmAdapter(getApplicationContext(),itemList);
			list1.setAdapter(listaConsultores);
			list1.setSelector(android.R.color.transparent);
	        
	  }
}
