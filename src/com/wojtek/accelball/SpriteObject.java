package com.wojtek.accelball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class SpriteObject {
	private double x;
	private double y;
	private Bitmap bitmap;
	private double x_move = 0;
	private double y_move = 0;
	private int state;
	public double a;
	public double b;
	private boolean booleanCollide = false;

	double left, entity_left;
	double right, entity_right;
	double top, entity_top;
	double bottom, entity_bottom;

	public static final int DEAD = 0; // niezywy
	public static final int ALIVE = 1;
	public static final int JUMPING = 2;
	public static final int CROUCHING = 3;
	public static final int INVISIBLE = 4;
	public static final int START = 5;
	public static final int WIN = 6;
	private Bitmap mBitmap;

	private Context context;

	public SpriteObject(Context con) {
		this.context = con;
	}

	//constructor which pulling and sets bitmap, position and size of each sprite
	public SpriteObject(Bitmap bitmap, double x, double y, double width,
			double height) {

		this.state = ALIVE;
		this.a = width;
		this.b = height;
		this.bitmap = bitmap;
		this.x = x;
		this.y = y;

	}

	public void setCollide(boolean c) {
		booleanCollide = c;
	}

	public boolean getCollide() {
		return booleanCollide;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;

	}

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setMoveX(double moveX) {
		this.x_move = moveX;
	}

	public void setMoveY(double moveY) {
		this.y_move = moveY;
	}

	public void setState(int s) {
		state = s;
	}

	public int getState() {
		return state;
	}

	public void update() {

		if (state != DEAD) {
			x += (x_move * 10);
			y += (y_move * 10);
		}
	}

	//this few methods draw each sprite with proper image, size and position
	public void draw(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a, (int) a, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	public void drawVL(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a / 2,
					(int) b * 10, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}
	
	public void drawVL6(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a / 2,
					(int) b * 6, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	public void drawHL(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a * 10,
					(int) a / 2, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	public void drawHLs(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a * 5,
					(int) a / 2, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	public void drawVLD(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a, (int) b * 10,
					true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	public void drawHLD(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a * 10,
					(int) b * 2, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	// 7
	public void drawHLDL(Canvas canvas) {
		if (state != DEAD) {
			mBitmap = Bitmap.createScaledBitmap(bitmap, (int) a * 10,
					(int) b * 2, true);
			canvas.drawBitmap(mBitmap, (int) x, (int) y, null);
		}
	}

	//this method is called to check if the collision between sprites take place;
	public boolean collide(SpriteObject entity, int w, int h, int number) {

		if (state != DEAD) {

			if (number == 0) {
				left = x;
				entity_left = entity.getX();

				right = x + w;
				entity_right = entity.getX() + w;

				top = y;
				entity_top = entity.getY();

				bottom = y + w;
				entity_bottom = entity.getY() + w;
			}
			if (number == 1) {
				left = x;
				entity_left = entity.getX();

				right = x + w;
				entity_right = entity.getX() + w / 2;

				top = y;
				entity_top = entity.getY();

				bottom = y + w;
				entity_bottom = entity.getY() + h * 10;
			}
			if (number == 2) {
				left = x;
				entity_left = entity.getX();

				right = x + w;
				entity_right = entity.getX() + 10 * w;

				top = y;
				entity_top = entity.getY();

				bottom = y + w;
				entity_bottom = entity.getY() + w / 2;
			}
			if (number == 3) {
				left = x;
				entity_left = entity.getX();

				right = x + w;
				entity_right = entity.getX() + w;

				top = y;
				entity_top = entity.getY();

				bottom = y + w;
				entity_bottom = entity.getY() + h * 10;
			}
			if (number == 4) {
				left = x;
				entity_left = entity.getX();

				right = x + w * 2;
				entity_right = entity.getX() + 10 * w;

				top = y;
				entity_top = entity.getY() - h / 2;

				bottom = y + h;
				entity_bottom = entity.getY() + h * 2;
			}
			if (number == 6) {
				left = x;
				entity_left = entity.getX() - w;

				right = x + w;
				entity_right = entity.getX() + 10 * w;

				top = y;
				entity_top = entity.getY() - w;

				bottom = y + w;
				entity_bottom = entity.getY() + w;
			}
			if (number == 7) {
				left = x;
				entity_left = entity.getX() + w;

				right = x + w * 2;
				entity_right = entity.getX() + 10 * w;

				top = y;
				entity_top = entity.getY() - h / 2;

				bottom = y + h;
				entity_bottom = entity.getY() + h * 2;
			}
			if (number == 8) {
				left = x;
				entity_left = entity.getX();

				right = x + w;
				entity_right = entity.getX() + w / 2;

				top = y;
				entity_top = entity.getY();

				bottom = y + w;
				entity_bottom = entity.getY() + h * 6;
			}

			if (bottom < entity_top)
				return false;
			if (top > entity_bottom)
				return false;
			if (right < entity_left)
				return false;
			if (left > entity_right)
				return false;

			return true;
		} else
			return false;
	}
}
