package com.exercise.AndroidNotifyService;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import java.util.Calendar;
import android.app.AlarmManager;
import android.widget.Toast;


public class NotifyService extends Service {

	private static int lunchRequestCODE = 0;
	private static int dinnerRequestCODE = 1;

	//private final int START_STICKY = 0; //onStartCommand()

	//The system calls this method when the service is first created, to perform one-time setup procedures
	//(before it calls either onStartCommand() or onBind()).
	//If the service is already running, this method is not called.
	@Override
	public void onCreate () {
		lunchMessage();
		dinnerMessage();
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
		//Toast.makeText(context, "Alarme do Bandeijão desativado", Toast.LENGTH_LONG).show();
	}

	//******* fim de implementacao de metodos abstratos


	public void lunchMessage() {
		Intent intent = new Intent(NotifyService.this, AlarmBroadcastReceiver.class);
		PendingIntent pintent = PendingIntent.getBroadcast(NotifyService.this, lunchRequestCODE, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		//Calendar -- Hora do bandeijao(almoco)
		Calendar RULunch = Calendar.getInstance();
		RULunch.set(Calendar.HOUR_OF_DAY,13);
		RULunch.set(Calendar.MINUTE,5);
		RULunch.set(Calendar.SECOND,0);
		RULunch.set(Calendar.MILLISECOND,0);
		//alarm.set(AlarmManager.RTC_WAKEUP, RULunch.getTimeInMillis(), pintent);
		//alarm.set(AlarmManager.RTC_WAKEUP, RULunch.getTimeInMillis()+(24*60*60*1000), pintent);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, RULunch.getTimeInMillis(), 24*60*60*1000, pintent);
		//alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, RULunch.getTimeInMillis(), 24*60*60*1000, pintent);
	}

	public void dinnerMessage() {
		Intent intent = new Intent(NotifyService.this, AlarmBroadcastReceiver.class);
		PendingIntent pintent = PendingIntent.getBroadcast(NotifyService.this, dinnerRequestCODE, intent, 0);
		AlarmManager alarm = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
		//Calendar -- Hora do bandeijao(janta)
		Calendar RUDinner = Calendar.getInstance();
		RUDinner.set(Calendar.HOUR_OF_DAY,19);
		RUDinner.set(Calendar.MINUTE,5);
		RUDinner.set(Calendar.SECOND,0);
		RUDinner.set(Calendar.MILLISECOND,0);
		//alarm.set(AlarmManager.RTC_WAKEUP, RUDinner.getTimeInMillis(), pintent);
		//alarm.set(AlarmManager.RTC_WAKEUP, RUDinner.getTimeInMillis()+(24*60*60*1000), pintent);
		alarm.setRepeating(AlarmManager.RTC_WAKEUP, RUDinner.getTimeInMillis(), 24*60*60*1000, pintent);
		//alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, RUDinner.getTimeInMillis(), 24*60*60*1000, pintent);
	}
}
