package com.exercise.AndroidNotifyService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class AndroidNotifyService extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button buttonStartService = (Button)findViewById(R.id.startservice);
		Button buttonStopService = (Button)findViewById(R.id.stopservice);

		buttonStartService.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				//cricao do Service(roda em bg)
				Intent intent = new Intent(AndroidNotifyService.this, com.exercise.AndroidNotifyService.NotifyService.class);
				AndroidNotifyService.this.startService(intent);
			}
		} );

    }
}
