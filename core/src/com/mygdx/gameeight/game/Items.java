package com.mygdx.gameeight.game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.gameeight.GameEightMain;
import com.mygdx.gameeight.util.Constants;

public class Items extends AbstractGameObject{

    Sprite lips;
    Sprite cactus;
    Sprite background;
    Sprite berries;

    public Items(){
        init();
    }

    public void init(){
        lips = new Sprite(GameEightMain.assets.lipsAR);
        lips.setSize(5, 5 * getAspectRatio(lips));
        lips.setPosition(75, 50);

        cactus = new Sprite(GameEightMain.assets.cactusAR);
        cactus.setSize(20, 20 * getAspectRatio(cactus));
        cactus.setPosition(80, 0);

        background = new Sprite(GameEightMain.assets.backgroundAR);
        background.setSize(125, 125 * getAspectRatio(background));
        background.setCenter(Constants.VIEWPORT_WIDTH / 2f, Constants.VIEWPORT_HEIGHT / 2f);

        berries = new Sprite(GameEightMain.assets.berriesAR);
        berries.setSize(2, 2 * getAspectRatio(berries));
        berries.setPosition(0, 0);

    }

    public void render(SpriteBatch batch){
        background.draw(batch);
        lips.draw(batch);
        cactus.draw(batch);
        berries.draw(batch);
    }
}
