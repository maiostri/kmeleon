package com.exercise.SilentService;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.Calendar;


import android.app.AlarmManager;
import android.widget.Toast;


public class SilentService extends Service {

	private static int ONRequestCODE1 = 0;	// 08:10
	private static int ONRequestCODE2 = 1;	// 10:10
	private static int ONRequestCODE3 = 2;	// 13:30
	private static int ONRequestCODE4 = 3;	// 16:20

	private static int OFFRequestCODE1 = 4;	// 09:50
	private static int OFFRequestCODE2 = 5;	// 11:50
	private static int OFFRequestCODE3 = 6;	// 15:50
	private static int OFFRequestCODE4 = 7;	// 19:00

	//private final int START_STICKY = 0; //onStartCommand()

	//The system calls this method when the service is first created, to perform one-time setup procedures
	//(before it calls either onStartCommand() or onBind()).
	//If the service is already running, this method is not called.
	@Override
	public void onCreate () {
		onSilentAlarms();
		offSilentAlarms();
	}
	
	// This is the old onStart method that will be called on the pre-2.0
	// // platform.  On 2.0 or later we override onStartCommand() so this
	// // method will not be called.
	@Override
	public void onStart(Intent intent, int startId) {
		//...
	}
	
	/*
	@Override //-- new API versions
	public int onStartCommand(Intent intent, int flags, int startId) {
		handleCommand(intent);
		// We want this service to continue running until it is explicitly
		// stopped, so return sticky.
		return START_STICKY;
	}
	*/
	
	//You must always implement this method, but if you don't want to allow binding, then you should return null.
	@Override
	public IBinder onBind (Intent intent) {
		return null;
	}

	//Called by the system to notify a Service that it is no longer used and is being removed.
	//The service should clean up an resources it holds (threads, registered receivers, etc) at this point.
	//Upon return, there will be no more calls in to this Service object and it is effectively dead. Do not call this method directly.
	@Override
	public void onDestroy () {
		//...
	}

	//******* fim de implementacao de metodos abstratos


	public void onSilentAlarms() {
		Intent intent = new Intent(this, OnSilentBroadcastReceiver.class);
		PendingIntent pintent1 = PendingIntent.getBroadcast(this, ONRequestCODE1, intent, 0);
		PendingIntent pintent2 = PendingIntent.getBroadcast(this, ONRequestCODE2, intent, 0);
		PendingIntent pintent3 = PendingIntent.getBroadcast(this, ONRequestCODE3, intent, 0);
		PendingIntent pintent4 = PendingIntent.getBroadcast(this, ONRequestCODE4, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		//Calendar -- 08:10
		Calendar silentHour1 = Calendar.getInstance();
		silentHour1.set(Calendar.HOUR_OF_DAY,8);
		silentHour1.set(Calendar.MINUTE,10);
		silentHour1.set(Calendar.SECOND,0);
		silentHour1.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour1.getTimeInMillis(), 24*60*60*1000, pintent1);
		//Calendar -- 10:10
		Calendar silentHour2 = Calendar.getInstance();
		silentHour2.set(Calendar.HOUR_OF_DAY,10);
		silentHour2.set(Calendar.MINUTE,10);
		silentHour2.set(Calendar.SECOND,0);
		silentHour2.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour2.getTimeInMillis(), 24*60*60*1000, pintent2);
		//Calendar -- 13:30
		Calendar silentHour3 = Calendar.getInstance();
		silentHour3.set(Calendar.HOUR_OF_DAY,13);
		silentHour3.set(Calendar.MINUTE,30);
		silentHour3.set(Calendar.SECOND,0);
		silentHour3.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour3.getTimeInMillis(), 24*60*60*1000, pintent3);
		//Calendar -- 16:20
		Calendar silentHour4 = Calendar.getInstance();
		silentHour4.set(Calendar.HOUR_OF_DAY,16);
		silentHour4.set(Calendar.MINUTE,20);
		silentHour4.set(Calendar.SECOND,0);
		silentHour4.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour4.getTimeInMillis(), 24*60*60*1000, pintent4);
	}

	public void offSilentAlarms() {
		Intent intent = new Intent(this, OffSilentBroadcastReceiver.class);
		PendingIntent pintent1 = PendingIntent.getBroadcast(this, OFFRequestCODE1, intent, 0);
		PendingIntent pintent2 = PendingIntent.getBroadcast(this, OFFRequestCODE2, intent, 0);
		PendingIntent pintent3 = PendingIntent.getBroadcast(this, OFFRequestCODE3, intent, 0);
		PendingIntent pintent4 = PendingIntent.getBroadcast(this, OFFRequestCODE4, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		//Calendar -- 09:50
		Calendar silentHour1 = Calendar.getInstance();
		silentHour1.set(Calendar.HOUR_OF_DAY,9);
		silentHour1.set(Calendar.MINUTE,50);
		silentHour1.set(Calendar.SECOND,0);
		silentHour1.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour1.getTimeInMillis(), 24*60*60*1000, pintent1);
		//Calendar -- 11:50
		Calendar silentHour2 = Calendar.getInstance();
		silentHour2.set(Calendar.HOUR_OF_DAY,11);
		silentHour2.set(Calendar.MINUTE,50);
		silentHour2.set(Calendar.SECOND,0);
		silentHour2.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour2.getTimeInMillis(), 24*60*60*1000, pintent2);
		//Calendar -- 15:50
		Calendar silentHour3 = Calendar.getInstance();
		silentHour3.set(Calendar.HOUR_OF_DAY,15);
		silentHour3.set(Calendar.MINUTE,50);
		silentHour3.set(Calendar.SECOND,0);
		silentHour3.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour3.getTimeInMillis(), 24*60*60*1000, pintent3);
		//Calendar -- 19:00
		Calendar silentHour4 = Calendar.getInstance();
		silentHour4.set(Calendar.HOUR_OF_DAY,19);
		silentHour4.set(Calendar.MINUTE,00);
		silentHour4.set(Calendar.SECOND,0);
		silentHour4.set(Calendar.MILLISECOND,0);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, silentHour4.getTimeInMillis(), 24*60*60*1000, pintent4);	
	}
}
