package com.wojtek.accelball;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class RestartActivity extends Activity {
	
	AccelBallView accleGameView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
		finish();
		System.exit(0);
}

}
