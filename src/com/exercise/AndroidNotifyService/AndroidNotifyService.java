package com.exercise.AndroidNotifyService;

import android.app.Activity;
import android.content.Intent;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.view.View;

public class AndroidNotifyService extends Activity {

	private Network icmcNet;
	private Network homeNet;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		//Bandeijao

		Button buttonStartService = (Button)findViewById(R.id.startservice);
		Button buttonStopService = (Button)findViewById(R.id.stopservice);

		buttonStartService.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//interface com usuario
				Context context = getApplicationContext();
				Toast.makeText(context, "Alarme do Bandeijão ativado", Toast.LENGTH_LONG).show();
				//cricao do Service(roda em bg)
				Intent intent = new Intent(AndroidNotifyService.this, com.exercise.AndroidNotifyService.NotifyService.class);
				AndroidNotifyService.this.startService(intent);
			}
		} );

		//Aulas Silenciosas

		Button buttonStartSilentService = (Button)findViewById(R.id.startsilent);
		Button buttonStopSilentService = (Button)findViewById(R.id.stopsilent);

		buttonStartSilentService.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//interface com usuario
				Context context = getApplicationContext();
				Toast.makeText(context, "Silent mode durante as aulas", Toast.LENGTH_LONG).show();
				//cricao do Service(roda em bg)
				Intent intent = new Intent(AndroidNotifyService.this, com.exercise.AndroidNotifyService.SilentService.class);
				AndroidNotifyService.this.startService(intent);
			}
		} );

    }

	private void createNetworks(int numNets) {
		if (numNets != 2)
			return;
		this.homeNet = new Network("HOME");
		this.icmcNet = new Network("ICMC");
		// Alarmes diarios: qdo disparados o dispositivo entra ou sai de silent mode
		// 1) 08:10 --> entra em silent mode
		// 2) 09:50 --> sai de silent mode
		// 3) 10:10 --> entra em silent mode
		// 4) 11:50 --> sai de silent mode
		// 5) 13:30 --> entra em silent mode
		// 6) 15:50 --> sai de silent mode
		// 7) 16:20 --> entra em silent mode
		// 8) 19:00 --> sai de silent mode
		icmcNet.setNumAlarms(8); 
	}
}
