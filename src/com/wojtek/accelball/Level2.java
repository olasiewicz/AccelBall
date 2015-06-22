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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Environment;
import android.os.Vibrator;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Level2 extends AccelBallView {

	public Level2(Context context) {
		super(context);

		granica_minX1 = widthScreen / 7;
		granica_maxX1 = widthScreen / 1.2;
		granica_minY1 = heightScreen / 10;
		granica_maxY1 = heightScreen / 1.3;

		granica_minX2 = widthScreen / 3.5;
		granica_maxX2 = widthScreen / 1.5;
		granica_minY2 = heightScreen / 3.5;
		granica_maxY2 = heightScreen / 1.75;// 1.7

		granica_minX3 = widthScreen / 2.5;
		granica_maxX3 = widthScreen / 1.8;

		liczbaBonusow = 14;
		licznikBonusow = 14;
		liczbaBomb1 = 26;// 39
		liczbaBomb2 = 13;// 20
		liczbaBomb3 = 1;

		liczbaLinii1 = 1;
		liczbaLinii2 = 1;

		bonus = new SpriteObject[liczbaBonusow];

		bombs1 = new SpriteObject[liczbaBomb1];
		bombs2 = new SpriteObject[liczbaBomb2];
		bombs3 = new SpriteObject[liczbaBomb3];

		lines1 = new SpriteObject[liczbaLinii1];
		lines2 = new SpriteObject[liczbaLinii2];

		lives = new SpriteObject[zycia];
		osX = 0;
		osY = heightScreen / 20;
		for (int i = 0; i < zycia; i++) {
			osX += widthScreen / 25;
			// osY = height1/17;
			lives[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.serce), osX, osY, width / 1.3,
					height / 1.3);
		}

		for (int i = 0; i < liczbaBonusow; i++) {

			bonus[0] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX3 * 1.1,
					granica_maxY2 / 1.37, width, height);
			bonus[1] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX3 * 1.3,
					granica_maxY2 / 1.37, width, height);
			bonus[2] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1 / 1.05,
					granica_minY1 * 1.6, width, height);
			bonus[3] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1 * 1.3,
					granica_minY1 * 1.6, width, height);
			bonus[4] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1 * 1.3,
					granica_maxY1 / 1.1, width, height);
			bonus[5] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1 / 1.05,
					granica_maxY1 / 1.1, width, height);
			bonus[6] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1 / 3,
					granica_maxY1 * 1.08, width, height);
			bonus[7] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1 / 1.3,
					granica_maxY1 * 1.08, width, height);
			bonus[8] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek),
					(granica_minX1 + granica_maxX1) / 2, granica_minY2 / 1.3,
					width, height);
			bonus[9] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek),
					(granica_minX1 + granica_maxX1) / 1.5, granica_minY1 / 2.3,
					width, height);
			bonus[10] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1 * 1.05,
					(granica_minY1 + granica_maxY1) / 1.5, width, height);
			bonus[11] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX2 / 1.2,
					(granica_minY2 + granica_maxY2) / 2, width, height);
			bonus[12] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX2 * 1.06,
					(granica_minY2 + granica_maxY2) / 2.4, width, height);
			bonus[13] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX2 * 1.06,
					(granica_minY2 + granica_maxY2) / 1.6, width, height);
		}

		y = granica_minY1;
		x = granica_maxX1 + widthScreen / 10;

		for (int i = 0; i < liczbaLinii1; i++) {

			lines1[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		y = granica_maxY2 - heightScreen / 12;
		x = granica_minX1 - widthScreen / 10;

		for (int i = 0; i < liczbaLinii2; i++) {

			lines2[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		y = -1.6 * widthScreen;

		for (int i = 0; i < liczbaBomb1; i++) {

			bombs1[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.golfball), granica_minX1, y,
					width, height);
			bombs1[i].setState(SpriteObject.DEAD);
			y = y + widthScreen / 13;// 20

		}

		for (int i = 0; i < liczbaBomb1; i++) {

			bombs1[i].setState(SpriteObject.ALIVE);
			bombs1[i].setMoveX(0);
			bombs1[i].setMoveY(bomb_moveSpeed1);
		}

		x = granica_maxX2;
		y = granica_minY2;

		for (int i = 0; i < liczbaBomb2; i++) {

			bombs2[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.golfball), x, y, width, height);
			bombs2[i].setState(SpriteObject.DEAD);

			x -= widthScreen / 13;// 20
		}

		for (int i = 0; i < liczbaBomb2; i++) {

			bombs2[i].setState(SpriteObject.ALIVE);
			bombs2[i].setMoveX(bomb_moveSpeed2);
			bombs2[i].setMoveY(0);
		}

		y = (granica_maxY2 / 1.37);
		x = granica_minX3;

		for (int i = 0; i < liczbaBomb3; i++) {
			bombs3[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.golfball), x, y, width, height);
			bombs3[i].setState(SpriteObject.DEAD);
			x = granica_minX3;
		}

		for (int i = 0; i < liczbaBomb3; i++) {
			bombs3[i].setState(SpriteObject.ALIVE);
			bombs3[i].setMoveX(bomb_moveSpeed3);
			bombs3[i].setMoveY(0);
		}

		// create AccelBallLogic instance and post actual surface and view
		// (SurfaceHolder, AccelBallView)
		accelBallLogic = new AccelBallLogic(getHolder(), Level2.this);
		getHolder().addCallback(Level2.this);

	}

	// this method is responsible to draw actual state of the game
	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);
		// mBitmap = Bitmap.createScaledBitmap(ball, 20, 20, true);

		canvas.drawColor(Color.CYAN);

		for (int i = 0; i < zycia; i++) {
			lives[i].draw(canvas);
		}

		character.draw(canvas);

		for (int i = 0; i < liczbaBonusow; i++) {
			bonus[i].draw(canvas);
		}

		for (int i = 0; i < liczbaLinii1; i++) {
			lines1[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii2; i++) {
			lines2[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaBomb1; i++) {
			bombs1[i].draw(canvas);
		}

		for (int i = 0; i < liczbaBomb2; i++) {
			bombs2[i].draw(canvas);
		}

		bombs3[0].draw(canvas);

	}

	// this method is responsible to update actual position of the sprites and
	// check collisions between them
	public void update() {

		if (getPause() == false) {

			if (character.getState() == SpriteObject.START) {

				character.setX(widthScreen / 20);
				character.setY(widthScreen / 20);
				character.setState(1);
			}

			// checking the collisions between sprites and called
			// collideWithBomb() method when collision is detected
			for (int i = 0; i < liczbaLinii1; i++) {
				if (character.collide(lines1[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();

				}

			}

			for (int i = 0; i < liczbaLinii2; i++) {
				if (character.collide(lines2[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();

				}
			}

			for (int i = 0; i < liczbaBomb1; i++) {

				if (bombs1[i].getY() >= granica_maxY1
						&& bombs1[i].getX() <= granica_maxX1) {
					// bomb_moveSpeed = 25;
					bombs1[i].setY(granica_maxY1);
					// bombs1[i].setX(granica_maxX1);
					bombs1[i].setMoveY(0);
					bombs1[i].setMoveX(bomb_moveSpeed1);
				}

				else if (bombs1[i].getX() >= granica_maxX1
						&& bombs1[i].getY() >= granica_maxY1) {
					// bomb_moveSpeed = 25;
					bombs1[i].setX(granica_maxX1);
					// bomb[i].setY(bomb_moveY/1.35);
					bombs1[i].setMoveY(-bomb_moveSpeed1);
					bombs1[i].setMoveX(0);
				}

				else if (bombs1[i].getY() <= granica_minY1
						&& bombs1[i].getX() >= granica_maxX1) {
					// bomb_moveSpeed = 25;
					// bomb[i].setX(granica_maxX);
					bombs1[i].setY(granica_minY1);// min y
					bombs1[i].setMoveX(-bomb_moveSpeed1);
					bombs1[i].setMoveY(0);
				}

				else if (bombs1[i].getX() <= granica_minX1
						&& bombs1[i].getY() <= granica_minY1) {
					// bomb_moveSpeed = 25;
					bombs1[i].setX(granica_minX1);
					bombs1[i].setMoveX(0);
					bombs1[i].setMoveY(bomb_moveSpeed1);
				}
			}

			for (int i = 0; i < liczbaBomb2; i++) {

				if (bombs2[i].getX() <= granica_minX2
						&& bombs2[i].getY() >= granica_maxY2) {
					// bomb_moveSpeed = 25;
					bombs2[i].setX(granica_minX2);
					bombs2[i].setMoveX(0);
					bombs2[i].setMoveY(-bomb_moveSpeed2);
				}

				else if (bombs2[i].getY() <= granica_minY2
						&& bombs2[i].getX() <= granica_minX2) {
					// bomb_moveSpeed = 25;
					bombs2[i].setY(granica_minY2);
					// bombs1[i].setX(granica_maxX1);
					bombs2[i].setMoveY(0);
					bombs2[i].setMoveX(bomb_moveSpeed2);
				}

				else if (bombs2[i].getX() >= granica_maxX2
						&& bombs2[i].getY() <= granica_minY2) {
					// bomb_moveSpeed = 25;
					bombs2[i].setY(granica_minY2);
					bombs2[i].setX(granica_maxX2);
					bombs2[i].setMoveY(bomb_moveSpeed2);
					bombs2[i].setMoveX(0);
				}

				else if (bombs2[i].getY() >= granica_maxY2
						&& bombs2[i].getX() >= granica_maxX2) {

					bombs2[i].setMoveX(-bomb_moveSpeed2);
					bombs2[i].setMoveY(0);
				}

			}

			if (bombs3[0].getX() >= granica_maxX3) {
				bombs3[0].setMoveX(-bomb_moveSpeed3);
			} else if (bombs3[0].getX() <= granica_minX3) {
				bombs3[0].setMoveX(bomb_moveSpeed3);
			}

			for (int i = 0; i < liczbaBomb1; i++) {
				if (character.collide(bombs1[i], width, height, BALL)) {

					collideWithBomb();

				}

			}

			for (int i = 0; i < liczbaBomb2; i++) {
				if (character.collide(bombs2[i], width, height, BALL)) {

					collideWithBomb();

				}

			}

			if (character.collide(bombs3[0], width, height, BALL)) {

				collideWithBomb();

			}

			// else if(character.collide(bonus[], width, height))
			// bonus1.setState(SpriteObject.DEAD);

			// booleanOdjeto = false;
			for (int i = 0; i < liczbaBonusow; i++) {
				// booleanOdjeto = false;
				if (character.collide(bonus[i], width, height, BALL)) {
					if (bonus[i].getCollide() == false) {
						bonus[i].setCollide(true);
						playSound(2);

						bonus[i].setState(SpriteObject.DEAD);
						licznikBonusow = licznikBonusow - 1;
					}
				}
			}

			if (licznikBonusow == 0) {

				// gameLogic.setState(gameLogic.WIN);
				// bonus.setState(SpriteObject.DEAD);
				playSound(3);

				for (int i = 0; i < liczbaBonusow; i++) {
					bonus[i].setCollide(false);
				}

				state = new State();
				state.setLevel(3);
				state.setLives(3);
				state.setNewGame(false);
				try {
					fos = new FileOutputStream(plik);
					oos = new ObjectOutputStream(fos);
					oos.writeObject(state);
					oos.close();

				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Intent backIntent = new Intent(getContext(),
						RestartActivity.class);
				// setLevel(2);
				// backIntent.putExtra("levelkey", "" + level);

				getContext().startActivity(backIntent);
				((Activity) context).finish();

			}

			if (character.getX() >= getWidth()) {
				character.setX(-width + 2);
			}
			if (character.getX() <= -width - 2) {
				character.setX(getWidth());
			}

			if (character.getY() >= getHeight()) {
				character.setY(-height + 2);
			}
			if (character.getY() <= -height - 2) {
				character.setY(getHeight());
			}

			for (int i = 0; i < liczbaBomb3; i++) {

				bombs3[i].update();
			}

			for (int i = 0; i < liczbaBomb1; i++) {
				bombs1[i].update();
			}

			for (int i = 0; i < liczbaBomb2; i++) {
				bombs2[i].update();
			}

			character.update();

		}

	}

}
