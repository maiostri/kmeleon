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
import android.media.AudioManager;

public class OnSilentBroadcastReceiver extends BroadcastReceiver
{
	private static final int MY_NOTIFICATION_ID = 1;

	@Override
	public void onReceive(Context context, Intent intent)
	{
		if (isUspNetwork(context)) {
			//turn on silent mode
			final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
		}
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
