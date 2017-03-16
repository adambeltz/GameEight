package com.mygdx.gameeight.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gameeight.GameEightMain;
import com.mygdx.gameeight.util.Constants;


public class Cats extends AbstractGameObject {
    Sprite grayCat;
    Sprite brownCat;

    public Cats(){
        init();
    }



    public void init(){
        grayCat = new Sprite(GameEightMain.assets.grayCatAR);
        grayCat.setSize(10, 10 *getAspectRatio(grayCat));
        positionV2.set(Constants.VIEWPORT_WIDTH / 2f, Constants.VIEWPORT_HEIGHT / 2f);
        grayCat.setPosition(positionV2.x, positionV2.y);

    }


    public void render(SpriteBatch batch) {
        grayCat.draw(batch);
    }


}
