package ru.sms.games.base;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;

public class BaseScreen implements Screen, InputProcessor {
    Game game;

    public BaseScreen(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void show() {
        System.out.println("show()");
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {
        System.out.println("resize: width =" + width + " height=" + height);
    }

    @Override
    public void pause() {
        System.out.println("pause()");
    }

    @Override
    public void resume() {
        System.out.println("resume()");
    }

    @Override
    public void hide() {
        System.out.println("hide()");
    }

    @Override
    public void dispose() {
        System.out.println("dispose()");
    }

    @Override
    public boolean keyDown(int keycode) {
        System.out.println("kewDown: keycode=" + keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        System.out.println("keyUp: keycode=" + keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        System.out.println("keyTyped: character=" + character);
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown: screenX=" + screenX + " screenY=" + screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchUp: screenX=" + screenX + " screenY=" + screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        System.out.println("touchDragged: screenX=" + screenX + " screenY=" + screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        System.out.println("mouseMoved: screenX=" + screenX + " screenY=" + screenY);
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        System.out.println("scrolled(): amount" + amount);
        return false;
    }
}
