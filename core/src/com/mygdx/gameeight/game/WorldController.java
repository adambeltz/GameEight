package com.mygdx.gameeight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gameeight.util.Constants;

public class WorldController extends InputAdapter implements Disposable {
    Cats cats;
    Items items;
    float deltaTime;

    // *Box 2D*
    World world;


    public WorldController(){
        init();
        deltaTime = 1;
    }

    public void init(){
        cats = new Cats();
        items = new Items();
        Gdx.input.setInputProcessor(this);

        // *Box 2D*
        world = new World(new Vector2(0, -10), true);


    }

    public void update(float deltaTime){
        this.deltaTime = deltaTime;
        handleInput(deltaTime);

        // *Box 2D*
        world.step(deltaTime, 8, 3);

    }

    private void handleInput(float deltaTime) {

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) moveSprite(cats.grayCat, -6, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) moveSprite(cats.grayCat, 6, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) moveSprite(cats.grayCat, 0, 6);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) moveSprite(cats.grayCat, 0, -6);

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

    @Override
    public void dispose() {

        // *Box 2D*
        world.dispose();
    }
}
