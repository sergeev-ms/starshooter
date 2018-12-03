package ru.sms.games.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class ExitButton extends Button {

    public ExitButton(TextureAtlas atlas) {
        super(atlas.findRegion("btExit"), 0.01f, -0.2f, 0.3f);
    }

    @Override
    protected void actionPerformed() {
        System.exit(-1);
    }
}
