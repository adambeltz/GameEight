package com.mygdx.gameeight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.mygdx.gameeight.util.Constants;

public class WorldController extends InputAdapter {
    Cats cats;
    Items items;
    float deltaTime;


    public WorldController(){
        init();
        deltaTime = 0;
    }

    public void init(){
        cats = new Cats();
        items = new Items();
        Gdx.input.setInputProcessor(this);


    }

    public void update(float deltaTime){
        this.deltaTime = deltaTime;
        handleInput(deltaTime);

    }

    private void handleInput(float deltaTime) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) moveSprite(cats.grayCat, -4, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moveSprite(cats.grayCat, 4, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) moveSprite(cats.grayCat, 0, 4);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) moveSprite(cats.grayCat, 0, -4);

        if (Gdx.input.isKeyPressed(Input.Keys.Z)) changeScale(items.lips, 1.1f);
        if (Gdx.input.isKeyPressed(Input.Keys.X)) changeScale(items.lips, 0.9f);


    }

    public void applyTo(OrthographicCamera camera){
        if (cats.grayCat.getX() > 25 && cats.grayCat.getX() < 73) camera.position.x = cats.grayCat.getX();
        if (cats.grayCat.getY() > 10 && cats.grayCat.getY() < 48) camera.position.y = cats.grayCat.getY();


    }


    public void moveSprite(Sprite sprite, float x, float y){
        sprite.translate(x * deltaTime,y * deltaTime);
    }

    public void changeScale(Sprite sprite, float x){
        sprite.setSize(sprite.getWidth() * x, sprite.getHeight() * x);
    }

    @Override
    public boolean keyUp(int keycode) {
        // Reset Game
        if (keycode == Input.Keys.DEL){
            Constants.RUNNING = false;
        }
        return true;
    }
}
