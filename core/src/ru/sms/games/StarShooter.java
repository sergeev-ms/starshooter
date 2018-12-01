package ru.sms.games;

import com.badlogic.gdx.Game;

import ru.sms.games.screen.MenuScreen;

public class StarShooter extends Game {
	@Override
	public void create() {
		setScreen(new MenuScreen(this));
	}
}
