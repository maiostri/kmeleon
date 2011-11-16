package com.exercise.AndroidNotifyService;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;

public class AlarmBroadcastReceiver extends BroadcastReceiver
{
	private static final int MY_NOTIFICATION_ID = 1;

	@Override
	public void onReceive(Context context, Intent intent)
	{
		if (isUspNetwork(context)) {
			notificationStatus(context);
		}
	}

	private void notificationStatus(Context context)
	{
		final NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

		final int icon = R.drawable.icon;
		final CharSequence tickerText = context.getString(R.string.app_name);
		final long when = System.currentTimeMillis();

		final Notification notification = new Notification(icon, context.getString(R.string.RUNotification), when);
		//add sound
		notification.defaults |= Notification.DEFAULT_SOUND;
		//final Intent notificationIntent = new Intent(context.getApplicationContext(), AndroidNotifyService.class);
		final Intent notificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(context.getString(R.string.RUweb)));
		final PendingIntent contentIntent = PendingIntent.getActivity(context.getApplicationContext(), 0, notificationIntent, 0);

		notification.setLatestEventInfo(context, tickerText, context.getString(R.string.RUNotification), contentIntent);
		mNotificationManager.notify(1, notification);
	}

	private boolean isUspNetwork(Context context)
	{
		final WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		if (wifiManager.isWifiEnabled()) {
				final WifiInfo wInfo = (WifiInfo) wifiManager.getConnectionInfo();
				Toast.makeText(context, wInfo.getSSID(), Toast.LENGTH_LONG).show();
				return ((wInfo.getSSID()).equals("ICMC"));
		}
		return false;
	}
	
}
