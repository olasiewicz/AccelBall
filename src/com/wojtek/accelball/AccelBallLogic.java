package com.wojtek.accelball;

import java.io.File;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class AccelBallLogic extends Thread {

	private SurfaceHolder surficeHolder;
	private AccelBallView accelBallView;
	private int gameState;
	private int gameLevel;

	private int counter = 1;
	File plik;

	Canvas canvas;

	public static final int PAUSE = 0;
	public static final int READY = 1;
	public static final int RUNNING = 2;
	public static final int WIN = 3;
	boolean isPaused = true;

	// constructor - pulling surface and view and sets this values in variables
	public AccelBallLogic(SurfaceHolder surfaceHolder,
			AccelBallView accelBallView) {
		super();
		this.surficeHolder = surfaceHolder;
		this.accelBallView = accelBallView;

	}

	// set up actual state of the game (when state = RUNNING, main loop is
	// running)
	public void setState(int state) {
		this.gameState = state;
	}

	public int getGameState() {
		return gameState;
	}

	public void setGameState(int state) {
		gameState = state;
	}

	// set up actual level (this value is used to unlocked next levels)
	public void setGameLevel(int level) {
		this.gameLevel = level;
	}

	public int getGameLevel() {
		return gameLevel;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	// new thread is executed inside this method
	@SuppressLint("WrongCall")
	@Override
	public void run() {

		// when state is running, canvas is locked to this thread, then methods
		// update() and onDraw(canvas) are called, finally canvas is unlocked
		while (gameState == RUNNING) {

			canvas = null;

			try {

				canvas = this.surficeHolder.lockCanvas();
				synchronized (surficeHolder) {
					try {
						Thread.sleep(30);
					} catch (InterruptedException e1) {
					}

					this.accelBallView.update();
					this.accelBallView.onDraw(canvas);

				}

			} finally {
				if (canvas != null)
					surficeHolder.unlockCanvasAndPost(canvas);
			}
		}
	}
}
