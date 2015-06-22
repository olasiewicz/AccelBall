package com.wojtek.accelball;

import java.io.Serializable;

public class State implements Serializable {

	private int level;
	private int lives;
	private boolean booleanNewGame;

	public int getLevel() {
		return level;
	}

	public int getLives() {
		return lives;
	}

	public boolean getNewGame() {
		return booleanNewGame;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public void setNewGame(boolean newGame) {
		this.booleanNewGame = newGame;
	}

}
