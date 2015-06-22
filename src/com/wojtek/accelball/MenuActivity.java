package com.wojtek.accelball;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageButton;

public class MenuActivity extends Activity implements SensorEventListener {

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	AccelBallView accelBallView;
	int width;
	int height;
	private int win = 0;
	private File plik;
	private int lives;
	private boolean booleanBegin;
	private FileInputStream fis;
	private FileOutputStream fos;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private State state;
	AlertDialog.Builder newDialog;
	private ImageButton[] buttons;
	private ImageButton buttonReset;
	private int poziom = 1;
	private Vibrator vibrator;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_activity);
		getActionBar().hide();
		accelBallView = new AccelBallView(this);

		final AlertDialog.Builder resetDialog = new AlertDialog.Builder(this);

		vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

		mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		mAccelerometer = mSensorManager
				.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

		plik = new File(Environment.getExternalStorageDirectory().getPath()
				+ "/obiekt.txt/");

		try {

			fis = new FileInputStream(plik);
			ois = new ObjectInputStream(fis);
			state = (State) ois.readObject();
			ois.close();

			booleanBegin = state.getNewGame();
			poziom = state.getLevel();

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		plik.delete();

		if (plik.exists() == false) {

			state = new State();
			state.setLives(3);
			state.setLevel(poziom);
			state.setNewGame(false);

			try {
				fos = new FileOutputStream(plik);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(state);
				oos.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {

			fis = new FileInputStream(plik);
			ois = new ObjectInputStream(fis);
			state = (State) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		buttons = new ImageButton[5];

		buttons[0] = (ImageButton) findViewById(R.id.button1);
		buttons[1] = (ImageButton) findViewById(R.id.button2);
		buttons[2] = (ImageButton) findViewById(R.id.button3);
		buttons[3] = (ImageButton) findViewById(R.id.button4);
		buttons[4] = (ImageButton) findViewById(R.id.button5);
		buttonReset = (ImageButton) findViewById(R.id.buttonReset);

		//creating scalable buttons depending of screen width
		Drawable drLock = getResources().getDrawable(R.drawable.lock);
		Bitmap bitmapLock = ((BitmapDrawable) drLock).getBitmap();
		Drawable lock = new BitmapDrawable(getResources(),
				Bitmap.createScaledBitmap(bitmapLock,
						accelBallView.getWidthScreen() / 18,
						accelBallView.getWidthScreen() / 13, true));

		Drawable drUnlock = getResources().getDrawable(R.drawable.unlock);
		Bitmap bitmapUnlock = ((BitmapDrawable) drUnlock).getBitmap();
		Drawable unlock = new BitmapDrawable(getResources(),
				Bitmap.createScaledBitmap(bitmapUnlock,
						accelBallView.getWidthScreen() / 18,
						accelBallView.getWidthScreen() / 13, true));

		Drawable drReset = getResources().getDrawable(R.drawable.reset);
		Bitmap bitmapReset = ((BitmapDrawable) drReset).getBitmap();
		Drawable reset = new BitmapDrawable(getResources(),
				Bitmap.createScaledBitmap(bitmapReset,
						accelBallView.getWidthScreen() / 10,
						accelBallView.getWidthScreen() / 10, true));

		Drawable drResetDisable = getResources()
				.getDrawable(R.drawable.disable);
		Bitmap bitmapResetDisable = ((BitmapDrawable) drResetDisable)
				.getBitmap();
		Drawable resetDisable = new BitmapDrawable(getResources(),
				Bitmap.createScaledBitmap(bitmapResetDisable,
						accelBallView.getWidthScreen() / 10,
						accelBallView.getWidthScreen() / 10, true));
		
        //First all buttons disabled
		for (int i = 0; i < buttons.length; i++) {
			buttons[i].setEnabled(false); // false
			buttons[i].setBackground(lock);
		}

		//changing buttons status to enable(depending of level value)
		for (int i = 0; i < state.getLevel(); i++) {
			buttons[i].setEnabled(true);
			buttons[i].setBackground(unlock);
		}
        
		//if your progress equals 1, reset button is inactive
		if (state.getLevel() == 1) {
			buttonReset.setBackground(resetDisable);
		} else {
			buttonReset.setBackground(reset);
		}
        
		
		//start level 1 (if button enabled)
		buttons[0].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				vibrator.vibrate(500);
				accelBallView = new Level1(MenuActivity.this);
				setContentView(accelBallView);
			}
		});
		
		//start level 2 (if button enabled)
		buttons[1].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				vibrator.vibrate(500);
				accelBallView = new Level2(MenuActivity.this);
				setContentView(accelBallView);
			}
		});

		//start level 3 (if button enabled)
		buttons[2].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				vibrator.vibrate(500);
				accelBallView = new Level3(MenuActivity.this);
				setContentView(accelBallView);
			}
		});

		//start level 4 (if button enabled)
		buttons[3].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				vibrator.vibrate(500);
				accelBallView = new Level4(MenuActivity.this);
				setContentView(accelBallView);

			}
		});

		//start level 5 (if button enabled)
		buttons[4].setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				vibrator.vibrate(500);
				accelBallView = new Level5(MenuActivity.this);
				setContentView(accelBallView);
			}
		});
        
		//reset your progress
		buttonReset.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (state.getLevel() > 1) {
					vibrator.vibrate(1000);

					resetDialog
							.setTitle(R.string.startActivity_dialogReset_title);
					resetDialog
							.setMessage(R.string.startActivity_dialogReset_message);
					resetDialog.setPositiveButton(R.string.dialog_Restart,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {

									plik.delete();
									startActivity(new Intent(
											MenuActivity.this,
											MenuActivity.class));
								}
							});
					resetDialog.setNegativeButton(R.string.dialog_Cancel,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.cancel();
								}
							});

					resetDialog.show();
				}

			}
		});
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub

		if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {

			float x = event.values[1];
			float y = event.values[0];
			float z = event.values[2];
			accelBallView.accelerometerEvent(x, y, z);
		}
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBackPressed() {
		// super.onBackPressed();
		accelBallView.setPause(true);
		AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
		saveDialog.setTitle(R.string.startActivity_dialogPause_title);
		saveDialog.setMessage(R.string.startActivity_dialogExit_message);
		saveDialog.setPositiveButton(R.string.dialog_Exit,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {

						System.exit(0);
					}
				});
		saveDialog.setNegativeButton(R.string.dialog_Back,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						accelBallView.setPause(false);
					}
				});
		saveDialog.setNeutralButton(R.string.dialog_Menu,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
						startActivity(new Intent(MenuActivity.this,
								MenuActivity.class));
					}
				});
		saveDialog.show();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mSensorManager.registerListener(this, mAccelerometer,
				SensorManager.SENSOR_DELAY_GAME);
		accelBallView.setPause(false);
		
		WindowManager.LayoutParams params = this.getWindow().getAttributes();
		/** Turn on: */
		params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
		//TODO restoring from original value
		params.screenBrightness = 0.9f;
		this.getWindow().setAttributes(params);
	}

	@Override
	protected void onPause() {
		super.onPause();
		System.exit(0);

	}
	
	
}