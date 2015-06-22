package com.wojtek.accelball;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.provider.SyncStateContract.Helpers;
import android.util.Log;

public class Level1 extends AccelBallView {

	private boolean booleanDraw = false;
	private int heightPol;

	public Level1(Context context) {
		super(context);

		granica_minX1 = widthScreen / 7;
		granica_maxX1 = widthScreen / 1.2;
		granica_minY1 = heightScreen / 10;
		granica_maxY1 = (heightScreen / 1.3) - height * 8;

		granica_minX2 = widthScreen / 3.5;
		granica_maxX2 = widthScreen / 2.3;
		granica_minY2 = heightScreen / 3.5;
		granica_maxY2 = heightScreen / 1.3;

		granica_minX3 = widthScreen / 2.5;
		granica_maxX3 = widthScreen / 1.35;
		granica_minY3 = heightScreen / 4.3; // l v 2p
		granica_maxY3 = 0;

		granica_minY3 = heightScreen / 4.5; // l v 2p
		granica_maxY3 = 0;

		granica_maxX4 = widthScreen / 1.97; // L H 1g
		granica_maxY4 = heightScreen / 2.15;

		granica_minX6 = widthScreen / 4.3; // L H 2g
		granica_minY6 = heightScreen / 4.5;
		granica_maxX6 = widthScreen / 2.3;

		granica_minX7 = widthScreen / 4.5; // L v 2l
		granica_minY7 = heightScreen / 4.5;
		granica_maxY7 = heightScreen / 3;

		granica_maxY8 = heightScreen / 1.56;// L H 2d
		granica_maxX8 = widthScreen / 2.9;

		granica_maxX9 = widthScreen / 1.51;// L v 3p
		granica_minY9 = heightScreen / 2.85;
		granica_maxY9 = heightScreen/2.12;

		granica_minX10 = widthScreen / 2.9;

		granica_minX11 = widthScreen / 2.7;
		granica_minY11 = granica_minY9 + heightScreen / 25;// ball
		granica_maxX11 = widthScreen / 1.6;
		granica_maxY11 = heightScreen / 1.76;

		granica_minX12 = widthScreen / 6;// zasuwa
		granica_maxX12 = widthScreen / 1.96;

		liczbaBonusow = 13;
		licznikBonusow = 13;
		liczbaBomb1 = 1;

		liczbaLinii1 = 3;
		liczbaLinii2 = 3;
		liczbaLinii3 = 3;
		liczbaLinii4 = 3;
		liczbaLinii5 = 3;
		liczbaLinii6 = 3;
		liczbaLinii7 = 2;
		liczbaLinii8 = 2;
		liczbaLinii9 = 2;
		liczbaLinii10 = 1;
		liczbaLinii11 = 1;
		liczbaLinii12 = 1;

		lines1 = new SpriteObject[liczbaLinii1];
		lines2 = new SpriteObject[liczbaLinii2];
		lines3 = new SpriteObject[liczbaLinii3];
		lines4 = new SpriteObject[liczbaLinii4];
		lines5 = new SpriteObject[liczbaLinii5];
		lines6 = new SpriteObject[liczbaLinii6];
		lines7 = new SpriteObject[liczbaLinii7];
		lines8 = new SpriteObject[liczbaLinii8];
		lines9 = new SpriteObject[liczbaLinii9];
		lines10 = new SpriteObject[liczbaLinii10];
		lines11 = new SpriteObject[liczbaLinii11];
		lines12 = new SpriteObject[liczbaLinii12];

		bonus = new SpriteObject[liczbaBonusow];

		bombs1 = new SpriteObject[liczbaBomb1];

		lives = new SpriteObject[zycia];
		osX = 0;
		osY = heightScreen / 20;
		for (int i = 0; i < zycia; i++) {
			osX += widthScreen / 25;
			lives[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.serce), osX, osY, width / 1.3,
					height / 1.3);
		}

		for (int i = 0; i < liczbaBonusow; i++) {
			// lewa srodek
			bonus[0] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX11 * 1.1,
					granica_maxY8 - heightScreen / 9, width, height);

			bonus[1] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX9
					- widthScreen / 10, granica_minY9 + heightScreen / 11,
					width, height);

			bonus[2] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX6
					+ widthScreen / 35, granica_minY6 + heightScreen / 20,
					width, height);

			bonus[3] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX6
					+ widthScreen / 3.8, granica_minY6 + heightScreen / 20,
					width, height);

			bonus[4] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX6
					+ widthScreen / 3.8, granica_maxY1 + heightScreen / 5.5,
					width, height);

			bonus[5] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 30, granica_maxY1 + heightScreen / 5.5,
					width, height);

			bonus[6] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 30, granica_minY6 - heightScreen / 13,
					width, height);

			bonus[7] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1
					- widthScreen / 20, granica_minY6 - heightScreen / 13,
					width, height);

			bonus[8] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1
					- widthScreen / 20, granica_minY6 + heightScreen / 5,
					width, height);

			bonus[9] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1
					- widthScreen / 20, granica_minY6 + heightScreen / 2.1,
					width, height);

			bonus[10] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 10, granica_minY4 + heightScreen / 25,
					width, height);

			bonus[11] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1
					- widthScreen / 9, granica_minY4 + heightScreen / 25,
					width, height);

			bonus[12] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX2 * 1.06,
					granica_maxY2 + heightScreen / 30, width, height);
		}
		// linia pionowa 1 od prawej
		y = granica_minY1;
		x = granica_maxX1;

		for (int i = 0; i < liczbaLinii1; i++) {

			lines1[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);

			y = y + heightScreen / 4;

		}

		x = granica_minX1;
		y = granica_maxY2;

		for (int i = 0; i < liczbaLinii2; i++) {

			lines2[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);

			x += widthScreen / 5;

		}
		// pionowa 2 od prawej
		x = widthScreen / 1.33;
		y = heightScreen / 1.7;

		for (int i = 0; i < liczbaLinii3; i++) {

			lines3[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y -= heightScreen / 4;

		}

		// pozioma 1 od gory
		x = granica_minX1;
		y = granica_minY1;

		for (int i = 0; i < liczbaLinii4; i++) {

			lines4[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);

			x += widthScreen / 5;

		}
		// pionowa 1 od lewej
		x = granica_minX1;
		y = granica_minY1;

		for (int i = 0; i < liczbaLinii5; i++) {

			lines5[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y += heightScreen / 4;

		}

		// pozioma 2 od gory
		x = granica_minX6;
		y = granica_minY6;

		for (int i = 0; i < liczbaLinii6; i++) {

			lines6[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 5;

		}

		// pionowa 2 od lewej
		x = granica_minX7;
		y = granica_minY7;
		for (int i = 0; i < liczbaLinii7; i++) {

			lines7[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y += heightScreen / 4;

		}

		x = granica_minX7;
		y = granica_maxY8;

		for (int i = 0; i < liczbaLinii8; i++) {

			lines8[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 5;

		}

		x = granica_maxX9;
		y = granica_minY9;
		for (int i = 0; i < liczbaLinii9; i++) {

			lines9[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y += heightScreen / 7;
		}

		x = granica_minX10;
		y = granica_minY9;
		for (int i = 0; i < liczbaLinii10; i++) {

			lines10[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}
		heightPol = height / 2;
		x = granica_minX10;
		// y = granica_minY9;
		for (int i = 0; i < liczbaLinii11; i++) {

			lines11[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, heightPol);
		}

		x = granica_maxX12;
		y = granica_minY6;
		for (int i = 0; i < liczbaLinii12; i++) {

			lines12[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			lines12[i].setMoveY(0);
			lines12[i].setMoveX(bomb_moveSpeed2);

		}

		x = granica_minX11;
		y = granica_minY11;
		for (int i = 0; i < liczbaBomb1; i++) {

			bombs1[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.golfball), x, y, width, height);
			bombs1[i].setMoveX(bomb_moveSpeed3 * 1.5);
			bombs1[i].setMoveY(bomb_moveSpeed3);
		}

		// create AccelBallLogic instance and post actual surface and view
		// (SurfaceHolder, AccelBallView)
		accelBallLogic = new AccelBallLogic(getHolder(), Level1.this);
		getHolder().addCallback(Level1.this);

	}

	// this method is responsible to draw actual state of the game
	@Override
	protected void onDraw(Canvas canvas) {

		super.onDraw(canvas);

		canvas.drawColor(Color.CYAN);

		for (int i = 0; i < zycia; i++) {
			lives[i].draw(canvas);
		}

		character.draw(canvas);

		for (int i = 0; i < liczbaBonusow; i++) {
			bonus[i].draw(canvas);
		}

		for (int i = 0; i < liczbaBomb1; i++) {
			bombs1[i].draw(canvas);
		}

		for (int i = 0; i < liczbaLinii12; i++) {
			lines12[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii2; i++) {
			lines2[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii4; i++) {
			lines4[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii1; i++) {
			lines1[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii5; i++) {
			lines5[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii6; i++) {
			lines6[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii3; i++) {
			lines3[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii7; i++) {
			lines7[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii8; i++) {
			lines8[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii10; i++) {
			lines10[i].drawHL(canvas);
		}
		
		for (int i = 0; i < liczbaLinii9; i++) {
			lines9[i].drawVL6(canvas);
		}

		for (int i = 0; i < liczbaLinii11; i++) {
			lines11[i].drawVL(canvas);
		}

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

			for (int i = 0; i < liczbaLinii1; i++) {

				if (lines1[i].getY() >= granica_maxY1) {
					lines1[i].setY(granica_maxY1);
				}
				lines1[i].update();
			}

			for (int i = 0; i < liczbaLinii2; i++) {
				if (lines2[i].getX() >= granica_maxX2) {
					lines2[i].setX(granica_maxX2);
				}
				lines2[i].update();
			}

			for (int i = 0; i < liczbaLinii3; i++) {
				if (lines3[i].getY() >= granica_maxY1) {
					lines3[i].setY(granica_maxY1);
				}

				if (lines3[i].getY() <= granica_minY3) {
					lines3[i].setY(granica_minY3);
				}
				lines3[i].update();
			}

			for (int i = 0; i < liczbaLinii4; i++) {
				if (lines4[i].getX() >= granica_maxX4) {
					lines4[i].setX(granica_maxX4);
				}
				lines4[i].update();
			}

			for (int i = 0; i < liczbaLinii5; i++) {
				if (lines5[i].getY() >= granica_maxY4) {
					lines5[i].setY(granica_maxY4);
				}
				lines5[i].update();
			}

			for (int i = 0; i < liczbaLinii6; i++) {
				if (lines6[i].getX() >= granica_maxX6) {
					lines6[i].setX(granica_maxX6);
				}
				lines6[i].update();
			}

			for (int i = 0; i < liczbaLinii7; i++) {
				if (lines7[i].getY() >= granica_maxY7) {
					lines7[i].setY(granica_maxY7);
				}
				lines7[i].update();
			}

			for (int i = 0; i < liczbaLinii8; i++) {
				if (lines8[i].getX() >= granica_maxX8) {
					lines8[i].setX(granica_maxX8);
				}
				lines8[i].update();
			}
			
			for (int i = 0; i < liczbaLinii9; i++) {
				if (lines9[i].getY() >= granica_maxY9) {
					lines9[i].setY(granica_maxY9);
				}
				lines9[i].update();
			}

			for (int i = 0; i < liczbaLinii12; i++) {
				if (lines12[i].getX() >= granica_maxX12) {
					lines12[i].setMoveX(-bomb_moveSpeed1);
				}
				if (lines12[i].getX() <= granica_minX12) {
					lines12[i].setMoveX(bomb_moveSpeed1);
				}
				lines12[i].update();
			}

			for (int i = 0; i < liczbaBomb1; i++) {
				if (bombs1[i].getY() >= granica_maxY11) {
					bombs1[i].setMoveY(-bomb_moveSpeed3);
					bombs1[i].setMoveX(-bomb_moveSpeed3 * 2);
				}
				if (bombs1[i].getY() <= granica_minY11) {
					bombs1[i].setMoveY(bomb_moveSpeed3);
					bombs1[i].setMoveX(bomb_moveSpeed3 * 2);
				}
				bombs1[i].update();
			}

			// checking the collisions between sprites and called
			// collideWithBomb() method when collision is detected
			for (int i = 0; i < liczbaLinii1; i++) {
				if (character.collide(lines1[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();

				}

			}

			for (int i = 0; i < liczbaLinii2; i++) {
				if (character
						.collide(lines2[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();

				}
			}

			for (int i = 0; i < liczbaLinii3; i++) {
				if (character.collide(lines3[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();

				}
			}

			for (int i = 0; i < liczbaLinii4; i++) {
				if (character
						.collide(lines4[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaLinii5; i++) {
				if (character.collide(lines5[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}

			}

			for (int i = 0; i < liczbaLinii6; i++) {
				if (character
						.collide(lines6[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();
				}

			}

			for (int i = 0; i < liczbaLinii7; i++) {
				if (character.collide(lines7[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}

			}

			for (int i = 0; i < liczbaLinii8; i++) {
				if (character
						.collide(lines8[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaLinii9; i++) {
				if (character.collide(lines9[i], width, height, VERTICAL_LINE_6)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaLinii10; i++) {
				if (character.collide(lines10[i], width, height,
						HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaLinii11; i++) {
				if (character.collide(lines11[i], width, heightPol,
						VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaLinii12; i++) {
				if (character.collide(lines12[i], width, height,
						HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaBomb1; i++) {
				if (character.collide(bombs1[i], width, height, BALL)) {

					collideWithBomb();
				}
			}

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
				state.setLevel(2);
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

			character.update();

		}

	}

}
