package ru.sms.games.sprite;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.sms.games.base.Sprite;
import ru.sms.games.math.Rect;

public abstract class Button extends Sprite {

    private Rect worldBounds;

    private float positionX;
    private float positionY;
    private float proportion;

    public Button(TextureRegion region, float posX, float posY, float proportion) {
        super(region);
        setHeightProportion(proportion);
        positionX = posX;
        positionY = posY;
        this.proportion = proportion;
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.worldBounds = worldBounds;
        pos.set(positionX, positionY);
    }

    public void setPushed(boolean pushed){
        if (pushed)
            setHeightProportion(proportion * 0.9f);
        else {
            setHeightProportion(proportion);
            actionPerformed();
        }
    }

    protected abstract void actionPerformed();
}
