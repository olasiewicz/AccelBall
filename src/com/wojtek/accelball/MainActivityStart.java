package com.wojtek.accelball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivityStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity_start);
		getActionBar().hide();
		
		//fluent transition to new thread after 4s
		new Handler().postDelayed(new Thread(){
			@Override 
			public void run()
			{
				Intent startActivityIntent = new Intent(MainActivityStart.this, MenuActivity.class);
				MainActivityStart.this.startActivity(startActivityIntent);
				MainActivityStart.this.finish();
				overridePendingTransition(R.layout.fadein, R.layout.fadeout);
			}
		}, 4000);
		
	}
		
	
}

