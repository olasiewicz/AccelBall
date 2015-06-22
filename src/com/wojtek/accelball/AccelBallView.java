package com.wojtek.accelball;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StreamCorruptedException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager.LayoutParams;


public class AccelBallView extends SurfaceView implements SurfaceHolder.Callback {

	public static final int BALL = 0;
	public static final int VERTICAL_LINE = 1;
	public static final int HORIZONTAL_LINE = 2;
	public static final int VERTICAL_LINE_DOUBLE = 3;
	public static final int HORIZONTAL_LINE_DOUBLE = 4;
	public static final int VERTICAL_LINE_SHORT = 5;
	public static final int HORIZONTAL_LINE_SHORT = 6;
	public static final int HORIZONTAL_LINE_DOUBLE_LONG = 7;
	public static final int VERTICAL_LINE_6 = 8;

	private boolean booleanPause = false;
	protected AccelBallLogic accelBallLogic;
	protected SpriteObject character;
	protected SpriteObject[] bombs1;
	protected SpriteObject[] bombs2;
	protected SpriteObject[] bombs3;

	protected SpriteObject[] lines1;
	protected SpriteObject[] lines2;
	protected SpriteObject[] lines3;
	protected SpriteObject[] lines4;
	protected SpriteObject[] lines5;
	protected SpriteObject[] lines6;
	protected SpriteObject[] lines7;
	protected SpriteObject[] lines8;
	protected SpriteObject[] lines9;
	protected SpriteObject[] lines10;
	protected SpriteObject[] lines11;
	protected SpriteObject[] lines12;
	protected SpriteObject[] lines13;
	protected SpriteObject[] lines14;
	protected SpriteObject[] lines15;
	protected SpriteObject[] lines16;
	protected SpriteObject[] lines17;
	protected SpriteObject[] lines18;
	protected SpriteObject[] lines19;
	protected SpriteObject[] lines20;

	protected SpriteObject[] bonus;
	protected SpriteObject[] lives;
	protected Vibrator vibrator;
	
	protected Context context;
	protected SoundPool soundPool;
	protected int ID_game_over = 1;
	protected int ID_point = 2;
	protected int ID_next_level = 3;
	protected int ID_missed = 4;

	
	protected int widthScreen;
	protected int heightScreen;
	
	protected int bomb_moveX;
	protected double bomb_moveSpeed1;
	protected double bomb_moveSpeed2;
	protected double bomb_moveSpeed3;
	protected double bomb_moveSpeed4;
	protected double bomb_moveSpeed5;

	protected boolean booleanSound = true;
	protected int level = 1;
	protected int zycia = 3;
	protected int width;
	protected int height;


	protected int liczbaBonusow;
	protected int licznikBonusow;

	protected int liczbaBomb1;
	protected int licznikBomb1;
	protected int liczbaBomb2;
	protected int licznikBomb2;
	protected int liczbaBomb3;

	protected int liczbaLinii1;
	protected int liczbaLinii2;
	protected int liczbaLinii3;
	protected int liczbaLinii4;
	protected int liczbaLinii5;
	protected int liczbaLinii6;
	protected int liczbaLinii7;
	protected int liczbaLinii8;
	protected int liczbaLinii9;
	protected int liczbaLinii10;
	protected int liczbaLinii11;
	protected int liczbaLinii12;
	protected int liczbaLinii13;
	protected int liczbaLinii14;
	protected int liczbaLinii15;
	protected int liczbaLinii16;
	protected int liczbaLinii17;
	protected int liczbaLinii18;
	protected int liczbaLinii19;
	protected int liczbaLinii20;

	protected double bomb_moveY;

	protected double granica_minX1;
	protected double granica_maxX1;
	protected double granica_minY1;
	protected double granica_maxY1;
	protected double granica_minX2;
	protected double granica_maxX2;
	protected double granica_minY2;
	protected double granica_maxY2;
	protected double granica_minX3;
	protected double granica_maxX3;
	protected double granica_minY3;
	protected double granica_maxY3;
	protected double granica_minX4;
	protected double granica_maxX4;
	protected double granica_minY4;
	protected double granica_maxY4;
	protected double granica_minX5;
	protected double granica_maxX5;
	protected double granica_minY5;
	protected double granica_maxY5;
	protected double granica_minX6;
	protected double granica_maxX6;
	protected double granica_minY6;
	protected double granica_maxX7;
	protected double granica_maxY7;
	protected double granica_maxY6;
	protected double granica_minX7;
	protected double granica_minY7;
	protected double granica_minX8;
	protected double granica_maxX8;
	protected double granica_minY8;
	protected double granica_maxY8;
	protected double granica_minX9;
	protected double granica_maxX9;
	protected double granica_minY9;
	protected double granica_maxY9;
	protected double granica_minX10;
	protected double granica_maxX10;
	protected double granica_minY10;
	protected double granica_maxY10;
	protected double granica_minX11;
	protected double granica_maxX11;
	protected double granica_minY11;
	protected double granica_maxY11;
	protected double granica_minX12;
	protected double granica_maxX12;
	protected double granica_minY12;
	protected double granica_maxY12;
	protected double granica_minY13;
	protected double granica_maxY13;
	protected double granica_minX13;
	protected double granica_maxX13;
	protected double granica_minY14;
	protected double granica_maxY14;
	protected double granica_minX14;
	protected double granica_maxX14;
	protected double granica_minY15;
	protected double granica_maxY15;
	protected double granica_minX15;
	protected double granica_maxX15;
	protected double granica_minY16;
	protected double granica_maxY16;
	protected double granica_minX16;
	protected double granica_maxX16;
	protected double granica_minY17;
	protected double granica_maxY17;
	protected double granica_minX17;
	protected double granica_maxX17;
	protected double granica_minY18;
	protected double granica_maxY18;
	protected double granica_minX18;
	protected double granica_maxX18;
	protected double granica_minY19;
	protected double granica_maxY19;
	protected double granica_minX19;
	protected double granica_maxX19;
	protected double granica_minY20;
	protected double granica_maxY20;
	protected double granica_minX20;
	protected double granica_maxX20;

	protected double osX;
	protected double osY;
	protected double x;
	protected double y;

	protected FileInputStream fis;
	protected FileOutputStream fos;
	protected ObjectInputStream ois;
	protected ObjectOutputStream oos;

	protected State state;
	protected File plik;

	public int getWidthScreen() {
		return widthScreen;
	}

	public int getHeightScreen() {
		return heightScreen;
	}

	public void setPause(boolean p) {
		this.booleanPause = p;
	}

	public boolean getPause() {
		return booleanPause;
	}

	public AccelBallView(Context context) {
		super(context);

		this.context = context;

		state = new State();

		vibrator = (Vibrator) getContext().getSystemService(
				context.VIBRATOR_SERVICE);

		plik = new File(Environment.getExternalStorageDirectory().getPath()
				+ "/obiekt.txt/");

		if (!plik.exists()) {
			
			state.setLevel(1);

		}

		try {
			fis = new FileInputStream(plik);
			ois = new ObjectInputStream(fis);
			state = (State) ois.readObject();
			ois.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
        // download screen width
		widthScreen = getContext().getResources().getDisplayMetrics().widthPixels;
		// download screen height
		heightScreen = getContext().getResources().getDisplayMetrics().heightPixels;
		width = widthScreen / 30;
		height = heightScreen / 30;
		bomb_moveX = widthScreen;
		bomb_moveY = heightScreen;
        
		
		//set how fast ball are going to move
		bomb_moveSpeed1 = widthScreen * 0.0017;
		bomb_moveSpeed2 = widthScreen * 0.0013;
		bomb_moveSpeed3 = widthScreen * 0.0010;
		bomb_moveSpeed5 = widthScreen * 0.0008;
		bomb_moveSpeed4 = widthScreen * 0.0003;

		//create new major sprite object which size is depend of screen size available
		character = new SpriteObject(BitmapFactory.decodeResource(
				getResources(), R.drawable.ball), widthScreen / 20,
				heightScreen / 20, width, height);
		character.update();

		//create object responsible to play proper sound (depending of existing situation)
		soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
		
		ID_game_over = soundPool.load(context, R.raw.game_over, 1);
		ID_point = soundPool.load(context, R.raw.point, 1);
		ID_next_level = soundPool.load(context, R.raw.win, 1);
		ID_missed = soundPool.load(context, R.raw.oo, 1);

		setFocusable(true);

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {

		//start a major loop of the game in a separate thread
		accelBallLogic.setState(accelBallLogic.RUNNING);
		accelBallLogic.start();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

		soundPool.release();
		
	}
	
	//this method is responsible to draw actual state of the game
	@Override
	protected void onDraw(Canvas canvas) {

	super.onDraw(canvas);

	}

	//this method is responsible to update actual position of the sprites and check collisions between them
	public void update() {

	}
    
	//this method is called when the accelerometer change values
	public void accelerometerEvent(float x, float y, float z) {
		character.setMoveX(x);
		character.setMoveY(y);
		invalidate();
	}

	//responsible to play proper sound
	public void playSound(int sound_id) {
		soundPool.play(sound_id, 1.0f, 1.0f, 1, 0, 1.0f);

	}

	//check situation in game after collision with bomb (take proper steps depending of quantities lives available)
	public void collideWithBomb() {

		character.setState(SpriteObject.START);
		playSound(4);
		vibrator.vibrate(500);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		state = new State();

		try {
			fis = new FileInputStream(plik);
			ois = new ObjectInputStream(fis);

			state = (State) ois.readObject();

			if (state.getLives() > 1) {
				state.setLives(zycia--);
				update();

				fos = new FileOutputStream(plik);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(state);
				ois.close();
				oos.close();

			} else if (state.getLives() == 1) {

				state.setNewGame(true);
				state.setLives(3);

				fos = new FileOutputStream(plik);
				oos = new ObjectOutputStream(fos);
				oos.writeObject(state);
				oos.close();

				playSound(1);

				Thread.sleep(3000);
				character.setState(SpriteObject.START);
				update();

				Intent backIntent = new Intent(context, RestartActivity.class);

				context.startActivity(backIntent);

				((Activity) context).finish();

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (StreamCorruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
}