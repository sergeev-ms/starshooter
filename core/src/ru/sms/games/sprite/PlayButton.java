package ru.sms.games.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class PlayButton extends Button {

    public PlayButton(TextureAtlas atlas) {
        super(atlas.findRegion("btPlay"), 0f, 0.2f, 0.4f);
    }

    @Override
    protected void actionPerformed() {

    }
}
