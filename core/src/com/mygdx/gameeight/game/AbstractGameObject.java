package com.mygdx.gameeight.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class AbstractGameObject {
    public Vector2 positionV2;
    public float AR;





    public AbstractGameObject(){

        positionV2 = new Vector2(0, 0);
        AR = 1.0f;



    }

    public float getAspectRatio(Sprite sprite){
        return sprite.getHeight()/ sprite.getWidth();
    }

    public void render(SpriteBatch batch){


    }


}
