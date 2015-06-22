package com.wojtek.accelball;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;

public class Level5 extends AccelBallView {

	private int heightPol;
	private int widthPol;

	public Level5(Context context) {
		super(context);

		heightPol = height / 2;
		widthPol = width / 2;

		// LINES
		granica_minX1 = widthScreen / 4.3; // L H 1g dluga
		granica_minY1 = heightScreen / 4.5;
		granica_maxX1 = widthScreen / 2.3;

		granica_minX2 = widthScreen / 4.3;
		granica_maxY2 = heightScreen / 1.8;// L H 1d dluga
		granica_maxX2 = widthScreen / 2.3;

		granica_minX3 = widthScreen / 3; // M v 1l
		granica_minY3 = -heightScreen / 3.4;
		granica_maxX3 = widthScreen / 2.3;

		granica_minX4 = widthScreen / 3.7; // M h 1l
		granica_minY4 = heightScreen / 14;
		granica_maxX4 = widthScreen / 2.3;
		granica_maxY4 = heightScreen;

		granica_minX5 = widthScreen / 1.6; // M v 2l
		granica_minY5 = -heightScreen / 7;

		granica_minX6 = widthScreen / 1.78; // M h 2l
		granica_minY6 = heightScreen / 6.2;

		granica_minX8 = widthScreen / 2.25; // tunel 1lg
		granica_minY8 = -heightScreen / 3.5;

		granica_minX9 = widthScreen / 1.86; // tunel 2lg
		granica_minY9 = -heightScreen / 3.5;

		granica_minX10 = widthScreen / 2.25; // tunel 1ld
		granica_minY10 = heightScreen / 1.2;

		granica_minX11 = widthScreen / 1.86; // tunel 2ld
		granica_minY11 = heightScreen / 1.2;

		granica_minX12 = widthScreen / 4.3; // linia v 1ld
		granica_minY12 = heightScreen / 1.8;

		granica_minX13 = widthScreen / 1.33; // linia v 1pd
		granica_minY13 = heightScreen / 1.8;

		granica_minX14 = widthScreen / 4.3; // linia h 1ld
		granica_minY14 = heightScreen / 1.2;
		granica_maxX14 = widthScreen / 1.86;

		granica_minX15 = widthScreen / 1.86; // linia h 1pd
		granica_minY15 = heightScreen / 1.2;

		granica_minX16 = widthScreen / 6.9; // L H 2g
		granica_minY16 = heightScreen / 2.8;

		granica_minX17 = -widthScreen / 10; // Mh h l
		granica_minY17 = heightScreen / 2.3;
		granica_maxX17 = widthScreen / 2.3;

		granica_minX18 = widthScreen / 4.5; // Mh v l
		granica_minY18 = heightScreen / 2.57;
		granica_maxX18 = widthScreen / 2.3;
		granica_maxY18 = heightScreen;

		granica_minX19 = widthScreen / 1.32; // Mh h p
		granica_minY19 = heightScreen / 2.3;

		granica_minX20 = widthScreen / 1.34; // Mh v p
		granica_minY20 = heightScreen / 2.57;

		// BOMBS
		granica_minX7 = widthScreen / 4;
		granica_maxX7 = widthScreen / 1.4;
		granica_minY7 = heightScreen / 1.7; // bombs2
		granica_maxY7 = heightScreen / 1.31;

		liczbaBonusow = 18;
		licznikBonusow = 18;
		liczbaBomb2 = 13;

		liczbaLinii1 = 2;
		liczbaLinii2 = 2;
		liczbaLinii3 = 1;
		liczbaLinii4 = 1;
		liczbaLinii5 = 1;
		liczbaLinii6 = 1;
		liczbaLinii7 = 1;
		liczbaLinii8 = 1;
		liczbaLinii9 = 1;
		liczbaLinii10 = 1;
		liczbaLinii11 = 1;
		liczbaLinii12 = 2;
		liczbaLinii13 = 2;
		liczbaLinii14 = 2;
		liczbaLinii15 = 2;
		liczbaLinii16 = 2;
		liczbaLinii17 = 1;
		liczbaLinii18 = 1;
		liczbaLinii19 = 1;
		liczbaLinii20 = 1;

		lines1 = new SpriteObject[liczbaLinii1];
		lines2 = new SpriteObject[liczbaLinii2];
		lines3 = new SpriteObject[liczbaLinii3];
		lines4 = new SpriteObject[liczbaLinii4];
		lines5 = new SpriteObject[liczbaLinii5];
		lines6 = new SpriteObject[liczbaLinii6];
		// lines7 = new SpriteObject[liczbaLinii7];
		lines8 = new SpriteObject[liczbaLinii8];
		lines9 = new SpriteObject[liczbaLinii9];
		lines10 = new SpriteObject[liczbaLinii10];
		lines11 = new SpriteObject[liczbaLinii11];
		lines12 = new SpriteObject[liczbaLinii12];
		lines13 = new SpriteObject[liczbaLinii13];
		lines14 = new SpriteObject[liczbaLinii14];
		lines15 = new SpriteObject[liczbaLinii15];
		lines16 = new SpriteObject[liczbaLinii16];
		lines17 = new SpriteObject[liczbaLinii17];
		lines18 = new SpriteObject[liczbaLinii18];
		lines19 = new SpriteObject[liczbaLinii19];
		lines20 = new SpriteObject[liczbaLinii20];

		bonus = new SpriteObject[liczbaBonusow];

		bombs2 = new SpriteObject[liczbaBomb2];

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
			// lewy miedzy mlotem i tunelem
			bonus[0] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX2
					+ widthScreen / 6.5, granica_minY2, width, height);

			// prawy miedzy mlotem i tunelem
			bonus[1] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX5
					- widthScreen / 20, granica_minY2, width, height);

			// gora srodek miedzy mlotami
			bonus[2] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX8
					+ widthScreen / 23, granica_minY1 - heightScreen / 16,
					width, height);

			// gora lewy przy lewym mlocie
			bonus[3] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX2
					+ widthScreen / 20, granica_minY2, width, height);

			// gora prawy przy prawym mlocie
			bonus[4] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX5
					+ widthScreen / 19, granica_minY2, width, height);

			// miedzy kulkami lewy 2
			bonus[5] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX7
					+ widthScreen / 8, granica_minY7 + heightScreen / 8.7,
					width, height);

			// miedzy kulkami prawy 2
			bonus[6] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX7
					- widthScreen / 8, granica_maxY7 - heightScreen / 8.6,
					width, height);

			// miedzy kulkami lewy 1
			bonus[7] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 18, granica_minY7 + heightScreen / 8.7,
					width, height);

			// miedzy kulkami prawy 1
			bonus[8] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_maxX1
					+ widthScreen / 4.1, granica_maxY7 - heightScreen / 8.6,
					width, height);

			// tunel dol
			bonus[9] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 4, granica_maxY2 + heightScreen / 3.5,
					width, height);

			// srodek prawy 1 od srodka
			bonus[10] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 2.85, granica_maxY2 - heightScreen / 9,
					width, height);

			// srodek prawy 2 od srodka
			bonus[11] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 2.45, granica_maxY2 - heightScreen / 9,
					width, height);

			// srodek prawy 3 od srodka
			bonus[12] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 2.15, granica_maxY2 - heightScreen / 9,
					width, height);

			// srodek lewy 1 od srodka
			bonus[13] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 5.65, granica_maxY2 - heightScreen / 9,
					width, height);

			// srodek lewy 2 od srodka
			bonus[14] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 8, granica_maxY2 - heightScreen / 9, width,
					height);

			// srodek lewy 3 od srodka
			bonus[15] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX1
					+ widthScreen / 13.3, granica_maxY2 - heightScreen / 9,
					width, height);

			// gora pod lewym mlotem
			bonus[16] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX8
					- widthScreen / 9, granica_minY1 - heightScreen / 10,
					width, height);

			// gora pod prawym mlotem
			bonus[17] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.grzybek), granica_minX8
					+ widthScreen / 5.5, granica_minY1 - heightScreen / 10,
					width, height);
		}

		// LINES

		// l h 1 g
		x = granica_minX1;
		y = granica_minY1;

		for (int i = 0; i < liczbaLinii1; i++) {

			lines1[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 5;

		}

		// l h 1 d
		x = granica_minX2;
		y = granica_maxY2;

		for (int i = 0; i < liczbaLinii2; i++) {

			lines2[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 5;

		}

		// HAMMERS
		// m 1lvg
		x = granica_minX3;
		y = granica_minY3;

		for (int i = 0; i < liczbaLinii3; i++) {

			lines3[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 5;
			lines3[i].setMoveY(bomb_moveSpeed4);
			lines3[i].setMoveX(0);
		}

		// m 1lhg
		x = granica_minX4;
		y = granica_minY4;

		for (int i = 0; i < liczbaLinii4; i++) {

			lines4[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, widthPol, height);
		}

		// m 2lvg
		x = granica_minX5;
		y = granica_minY5;

		for (int i = 0; i < liczbaLinii5; i++) {

			lines5[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			lines5[i].setMoveY(-bomb_moveSpeed4);
			lines5[i].setMoveX(0);

		}

		// m 2lhg
		x = granica_minX6;
		y = granica_minY6;

		for (int i = 0; i < liczbaLinii6; i++) {

			lines6[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, widthPol, height);
		}

		// tunel v 1lg
		x = granica_minX8;
		y = granica_minY8;

		for (int i = 0; i < liczbaLinii8; i++) {

			lines8[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		// tunel v 2lg
		x = granica_minX9;
		y = granica_minY9;

		for (int i = 0; i < liczbaLinii9; i++) {

			lines9[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		// tunel v 1ld
		x = granica_minX10;
		y = granica_minY10;

		for (int i = 0; i < liczbaLinii10; i++) {

			lines10[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		// tunel v 2ld
		x = granica_minX11;
		y = granica_minY11;

		for (int i = 0; i < liczbaLinii11; i++) {

			lines11[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
		}

		// l v 1ld
		x = granica_minX12;
		y = granica_minY12;

		for (int i = 0; i < liczbaLinii12; i++) {

			lines12[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y += heightScreen / 4;
		}

		// l v 1pd
		x = granica_minX13;
		y = granica_minY13;

		for (int i = 0; i < liczbaLinii13; i++) {

			lines13[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			y += heightScreen / 4;
		}

		// l h 1ld
		x = granica_minX14;
		y = granica_minY14;

		for (int i = 0; i < liczbaLinii14; i++) {

			lines14[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 16;
		}

		// l h 1pd
		x = granica_minX15;
		y = granica_minY15;

		for (int i = 0; i < liczbaLinii15; i++) {

			lines15[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 16;
		}

		// l h 2g przerywana
		x = granica_minX16;
		y = granica_minY16;

		for (int i = 0; i < liczbaLinii16; i++) {

			lines16[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			x += widthScreen / 2.5; // przerwa miedzy liniami h 2g

		}

		// mh Lh
		x = granica_minX17;
		y = granica_minY17;

		for (int i = 0; i < liczbaLinii17; i++) {

			lines17[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			lines17[i].setMoveY(0);
			lines17[i].setMoveX(bomb_moveSpeed4);
		}

		// mh Lv
		x = granica_minX18;
		y = granica_minY18;

		for (int i = 0; i < liczbaLinii18; i++) {

			lines18[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, heightPol);

		}

		// mh Ph
		x = granica_minX19;
		y = granica_minY19;

		for (int i = 0; i < liczbaLinii19; i++) {

			lines19[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, height);
			lines19[i].setMoveY(0);
			lines19[i].setMoveX(-bomb_moveSpeed4);
		}

		// mh Pv
		x = granica_minX20;
		y = granica_minY20;

		for (int i = 0; i < liczbaLinii20; i++) {

			lines20[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.square), x, y, width, heightPol);

		}

		// BOMBS

		x = granica_maxX7;
		y = granica_minY7;

		for (int i = 0; i < liczbaBomb2; i++) {

			bombs2[i] = new SpriteObject(BitmapFactory.decodeResource(
					getResources(), R.drawable.golfball), x, y, width, height);
			bombs2[i].setState(SpriteObject.DEAD);

			x -= widthScreen / 13;// 20
		}

		for (int i = 0; i < liczbaBomb2; i++) {

			bombs2[i].setState(SpriteObject.ALIVE);
			bombs2[i].setMoveX(bomb_moveSpeed3);
			bombs2[i].setMoveY(0);
		}

		// create AccelBallLogic instance and post actual surface and view
		// (SurfaceHolder, AccelBallView)
		accelBallLogic = new AccelBallLogic(getHolder(), Level5.this);
		getHolder().addCallback(Level5.this);
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
			lines1[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii2; i++) {
			lines2[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii3; i++) {
			lines3[i].drawVLD(canvas);
		}

		for (int i = 0; i < liczbaLinii4; i++) {
			lines4[i].drawHLD(canvas);
		}

		for (int i = 0; i < liczbaLinii5; i++) {
			lines5[i].drawVLD(canvas);
		}

		for (int i = 0; i < liczbaLinii6; i++) {
			lines6[i].drawHLD(canvas);
		}

		for (int i = 0; i < liczbaLinii8; i++) {
			lines8[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii9; i++) {
			lines9[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii10; i++) {
			lines10[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii11; i++) {
			lines11[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii14; i++) {
			lines14[i].drawHLs(canvas);
		}

		for (int i = 0; i < liczbaLinii15; i++) {
			lines15[i].drawHLs(canvas);
		}

		for (int i = 0; i < liczbaLinii16; i++) {
			lines16[i].drawHL(canvas);
		}

		for (int i = 0; i < liczbaLinii12; i++) {
			lines12[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii13; i++) {
			lines13[i].drawVL(canvas);
		}

		for (int i = 0; i < liczbaLinii17; i++) {
			lines17[i].drawHLDL(canvas);
		}

		for (int i = 0; i < liczbaLinii18; i++) {
			lines18[i].drawVLD(canvas);
		}

		for (int i = 0; i < liczbaLinii19; i++) {
			lines19[i].drawHLDL(canvas);
		}

		for (int i = 0; i < liczbaLinii20; i++) {
			lines20[i].drawVLD(canvas);
		}

		for (int i = 0; i < liczbaBomb2; i++) {
			bombs2[i].draw(canvas);
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

			// LINES
			// l h 1 gora
			for (int i = 0; i < liczbaLinii1; i++) {
				if (lines1[i].getX() >= granica_maxX1) {
					lines1[i].setX(granica_maxX1);
				}
				lines1[i].update();
			}

			// l h 1 d
			for (int i = 0; i < liczbaLinii2; i++) {
				if (lines2[i].getX() >= granica_maxX2) {
					lines2[i].setX(granica_maxX2);
				}
				lines2[i].update();
			}

			// m v 1lg
			for (int i = 0; i < liczbaLinii3; i++) {
				if (lines3[i].getY() >= granica_minY1 - heightScreen / 2.8) {
					lines3[i].setMoveY(-bomb_moveSpeed4);
				}

				if (lines3[i].getY() <= -heightScreen / 3.3) {
					lines3[i].setMoveY(bomb_moveSpeed4);
				}
				// synchronizacja mlotkow
				if (lines3[i].getY() <= -heightScreen / 3.3) {
					lines5[i].setY(granica_minY1 - heightScreen / 2.8);
				}
				lines3[i].update();
			}

			// m h 1lg
			for (int i = 0; i < liczbaLinii4; i++) {
				lines4[i].setY(lines3[i].getY() + heightScreen / 3.4);
				lines4[i].update();
			}

			// m v 2lg
			for (int i = 0; i < liczbaLinii5; i++) {

				if (lines5[i].getY() <= -heightScreen / 3.3) {
					lines5[i].setMoveY(bomb_moveSpeed4);
				}

				if (lines5[i].getY() >= granica_minY1 - heightScreen / 2.8) {
					lines5[i].setMoveY(-bomb_moveSpeed4);
				}
				lines5[i].update();
			}

			// m h 2lg
			for (int i = 0; i < liczbaLinii6; i++) {
				lines6[i].setY(lines5[i].getY() + heightScreen / 3.4);
				lines6[i].update();
			}

			// m h l
			for (int i = 0; i < liczbaLinii17; i++) {
				if (lines17[i].getX() >= widthScreen / 6.4) {
					lines17[i].setMoveX(-bomb_moveSpeed5);
				}
				if (lines17[i].getX() <= granica_minX17) {
					lines17[i].setMoveX(bomb_moveSpeed5);
				}

				// synchronizacja mlotkow
				if (lines17[i].getX() <= granica_minX17) {
					lines19[i].setX(granica_minX19);
				}
				// synchronizacja mlotkow
				if (lines17[i].getX() >= widthScreen / 6.4) {
					lines19[i].setX(granica_minX19 - widthScreen / 3.9);
				}
				lines17[i].update();
			}

			// m v l
			for (int i = 0; i < liczbaLinii18; i++) {
				lines18[i].setX(lines17[i].getX() + widthScreen / 3.2);
				lines18[i].update();
			}

			// m h p
			for (int i = 0; i < liczbaLinii19; i++) {
				if (lines19[i].getX() <= granica_minX19 - widthScreen / 3.9) {
					lines19[i].setMoveX(bomb_moveSpeed5);
				}
				if (lines19[i].getX() >= granica_minX19) {
					lines19[i].setMoveX(-bomb_moveSpeed5);
				}

				lines19[i].update();
			}

			// m v p
			for (int i = 0; i < liczbaLinii20; i++) {
				lines20[i].setX(lines19[i].getX());
				lines20[i].update();
			}

			// BOMBS
			for (int i = 0; i < liczbaBomb2; i++) {

				if (bombs2[i].getX() <= granica_minX7
						&& bombs2[i].getY() >= granica_maxY7) {
					// bomb_moveSpeed = 25;
					bombs2[i].setX(granica_minX7);
					bombs2[i].setMoveX(0);
					bombs2[i].setMoveY(-bomb_moveSpeed3);
				}

				else if (bombs2[i].getY() <= granica_minY7
						&& bombs2[i].getX() <= granica_minX7) {
					// bomb_moveSpeed = 25;
					bombs2[i].setY(granica_minY7);
					bombs2[i].setMoveY(0);
					bombs2[i].setMoveX(bomb_moveSpeed3);
				}

				else if (bombs2[i].getX() >= granica_maxX7
						&& bombs2[i].getY() <= granica_minY7) {
					// bomb_moveSpeed = 25;
					bombs2[i].setY(granica_minY7);
					bombs2[i].setX(granica_maxX7);
					bombs2[i].setMoveY(bomb_moveSpeed3);
					bombs2[i].setMoveX(0);
				}

				else if (bombs2[i].getY() >= granica_maxY7
						&& bombs2[i].getX() >= granica_maxX7) {

					bombs2[i].setMoveX(-bomb_moveSpeed3);
					bombs2[i].setMoveY(0);
				}
				bombs2[i].update();
			}

			// checking the collisions between sprites and called
			// collideWithBomb() method when collision is detected
			for (int i = 0; i < liczbaLinii1; i++) {
				if (character
						.collide(lines1[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();
				}

			}

			for (int i = 0; i < liczbaLinii2; i++) {
				if (character
						.collide(lines2[i], width, height, HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			// mlotek vlg
			for (int i = 0; i < liczbaLinii3; i++) {
				if (character.collide(lines3[i], width, height,
						VERTICAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			// mlotek hlg
			for (int i = 0; i < liczbaLinii4; i++) {
				if (character.collide(lines4[i], widthPol, height,
						HORIZONTAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			// mlotek vpg
			for (int i = 0; i < liczbaLinii5; i++) {
				if (character.collide(lines5[i], width, height,
						VERTICAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			// mlotek hpg
			for (int i = 0; i < liczbaLinii6; i++) {
				if (character.collide(lines6[i], widthPol, height,
						HORIZONTAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			// tunel vgl
			for (int i = 0; i < liczbaLinii8; i++) {
				if (character.collide(lines8[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// tunel vgp
			for (int i = 0; i < liczbaLinii9; i++) {
				if (character.collide(lines9[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// tunel vdl
			for (int i = 0; i < liczbaLinii10; i++) {
				if (character.collide(lines10[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// tunel vdp
			for (int i = 0; i < liczbaLinii11; i++) {
				if (character.collide(lines11[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// linia dvl
			for (int i = 0; i < liczbaLinii12; i++) {
				if (character.collide(lines12[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// linia dvp
			for (int i = 0; i < liczbaLinii13; i++) {
				if (character.collide(lines13[i], width, height, VERTICAL_LINE)) {

					collideWithBomb();
				}
			}

			// linia dhl
			for (int i = 0; i < liczbaLinii14; i++) {
				if (character.collide(lines14[i], widthPol, heightPol,
						HORIZONTAL_LINE_SHORT)) {

					collideWithBomb();
				}
			}

			// linia dhp
			for (int i = 0; i < liczbaLinii15; i++) {
				if (character.collide(lines15[i], widthPol, heightPol,
						HORIZONTAL_LINE_SHORT)) {

					collideWithBomb();
				}
			}

			// linia h 2g przerywana
			for (int i = 0; i < liczbaLinii16; i++) {
				if (character.collide(lines16[i], width, height,
						HORIZONTAL_LINE)) {

					collideWithBomb();
				}
			}

			// mlotek hl h
			for (int i = 0; i < liczbaLinii17; i++) {
				if (character.collide(lines17[i], width, height,
						HORIZONTAL_LINE_DOUBLE_LONG)) {

					collideWithBomb();
				}
			}

			// mlotek hl v
			for (int i = 0; i < liczbaLinii18; i++) {
				if (character.collide(lines18[i], width, heightPol,
						VERTICAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			// mlotek hp h
			for (int i = 0; i < liczbaLinii19; i++) {
				if (character.collide(lines19[i], width, height,
						HORIZONTAL_LINE_DOUBLE_LONG)) {

					collideWithBomb();
				}
			}

			// mlotek hp v
			for (int i = 0; i < liczbaLinii20; i++) {
				if (character.collide(lines20[i], width, heightPol,
						VERTICAL_LINE_DOUBLE)) {

					collideWithBomb();
				}
			}

			for (int i = 0; i < liczbaBomb2; i++) {
				if (character.collide(bombs2[i], width, height, BALL)) {

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

				playSound(3);

				for (int i = 0; i < liczbaBonusow; i++) {
					bonus[i].setCollide(false);
				}

				state = new State();
				state.setLevel(5);
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
