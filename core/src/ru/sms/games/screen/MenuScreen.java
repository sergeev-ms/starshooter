package ru.sms.games.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.sms.games.base.BaseScreen;
import ru.sms.games.math.Rect;
import ru.sms.games.sprite.Background;
import ru.sms.games.sprite.ExitButton;
import ru.sms.games.sprite.PlayButton;
import ru.sms.games.sprite.Star;

public class MenuScreen extends BaseScreen {
    private static final int STAR_COUNT = 128;

    private Texture bg;
    private TextureAtlas textureAtlas;

    private Background background;
    private Star[] star;
    private PlayButton playButton;
    private ExitButton exitButton;


    @Override
    public void show() {
        super.show();
        textureAtlas = new TextureAtlas("textures/menuAtlas.tpack");
        bg = new Texture("textures/bg.png");
        background = new Background(new TextureRegion(bg));
        star = new Star[STAR_COUNT];
        playButton = new PlayButton(textureAtlas);
        exitButton = new ExitButton(textureAtlas);
        for (int i = 0; i < star.length; i++) {
            star[i] = new Star(textureAtlas);
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
    }

    public void update(float delta) {
        for (int i = 0; i < star.length; i++) {
            star[i].update(delta);
        }
    }

    public void draw() {
        Gdx.gl.glClearColor(1, 0.3f, 0.6f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        background.draw(batch);
        for (int i = 0; i < star.length; i++) {
            star[i].draw(batch);
        }
        playButton.draw(batch);
        exitButton.draw(batch);
        batch.end();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        for (int i = 0; i < star.length; i++) {
            star[i].resize(worldBounds);
        }
        playButton.resize(worldBounds);
        exitButton.resize(worldBounds);
    }

    @Override
    public void dispose() {
        textureAtlas.dispose();
        bg.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        if (exitButton.isMe(touch))
            exitButton.setPushed(true);
        if (playButton.isMe(touch))
            playButton.setPushed(true);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        if (exitButton.isMe(touch))
            exitButton.setPushed(false);
        if (playButton.isMe(touch))
            playButton.setPushed(false);
        return super.touchUp(touch, pointer);
    }
}
