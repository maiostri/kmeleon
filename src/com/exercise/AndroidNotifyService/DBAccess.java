package com.exercise.AndroidNotifyService;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DBAccess {
	private static final String TAG = "DBAccess";

	private static final String DATABASE_NAME = "iguana";
	//@todo verify the database version
	private static final int DATABASE_VERSION = 3;

	private static final String CREATE_NETWORK_TABLE =
    "create table network (id integer primary key autoincrement, "
    + "ssid text not null);";
	
	private static final String CREATE_ALARM_TABLE =
	"create table alarm (id integer primary key autoincrement, "
    + "name text not null, "
	+ "status integer not null, "
	+ "time text not null, "
	+ "id_network integer not null, "
	+ "foreign key(id_network) references network(id));";

	private final Context context; 
    
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public DBAccess(Context ctx) 
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
        
    }
        
    private static class DatabaseHelper extends SQLiteOpenHelper 
    {
        DatabaseHelper(Context context) 
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) 
        {
            db.execSQL(CREATE_NETWORK_TABLE);
            db.execSQL(CREATE_ALARM_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, 
        int newVersion) 
        {
            Log.w(TAG, "Upgrading database from version " + oldVersion 
                    + " to "
                    + newVersion + ", which will destroy all old data");
            db.execSQL("DROP TABLE IF EXISTS network");
            db.execSQL("DROP TABLE IF EXISTS alarm");
            onCreate(db);
        }
    }    
    
    //---opens the database---
    public DBAccess open() throws SQLException 
    {
        db = DBHelper.getWritableDatabase();
        return this;
    }

    //---closes the database---    
    public void close() 
    {
        DBHelper.close();
    }
    
    // Insert the initialValues into the table
    public long insertIntoTable(ContentValues initialValues, String table) {
    	return db.insert(table, null, initialValues);    	
    }
    
    // Delete from table the record whose primary_field is equal to rowId
    public boolean deleteFromTable(String table, String primary_field, long rowId) {
    	return db.delete(table, primary_field + "=" + rowId, null) > 0;
    }
    
    // Update from table the record whose primary_field is equal to rowId
    public boolean updateFromTable(ContentValues updateValues, String table, String primary_field, long rowId) {
    	 return db.update(table, updateValues, primary_field + "=" + rowId, null) > 0;
    	
    }
    
    // Execute a query in a table and returns the cursor
    public Cursor runSelectionQuery(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy) {
    	return db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy);
    }
    
}



