package ru.sms.games.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import ru.sms.games.base.BaseScreen;

import static com.badlogic.gdx.Input.Keys;

public class MenuScreen extends BaseScreen {
    private SpriteBatch batch;
    private Texture img;
    private Vector2 pos = new Vector2(0, 0);
    private Vector2 v;
    private Vector2 directionNor;
    private Vector2 direction;
    private boolean isClicked;
    private boolean isStopped;
    private int deltaToMove = 10;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show() {
        super.show();
        batch = new SpriteBatch();
        img = new Texture("geekbrains.png");
        pos = new Vector2(0f, 0f);
        v = new Vector2(5f, 5f);
        direction = new Vector2();
        isStopped = false;
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(1, 0.4f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y, 200, 100);
        batch.end();
        if (isClicked && !isStopped) {
            pos.add(v);
        }
        if (pos.len() > direction.len())
            isStopped = true;

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown screenX = " + screenX + " screenY = " + (Gdx.graphics.getHeight() - screenY));
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.show();
        isClicked = true;
        direction.x = screenX;
        direction.y = Gdx.graphics.getHeight() - screenY;
        directionNor = direction.cpy().nor();
        v.scl(directionNor);
        return super.touchUp(screenX, screenY, pointer, button);
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Keys.LEFT:
                pos.x -= deltaToMove;
                break;
            case Keys.RIGHT:
                pos.x += deltaToMove;
                break;
            case Keys.UP:
                pos.y += deltaToMove;
                break;
            case Keys.DOWN:
                pos.y -= deltaToMove;
                break;
        }
        return super.keyUp(keycode);
    }
}
