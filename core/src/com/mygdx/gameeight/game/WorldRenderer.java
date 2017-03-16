package com.mygdx.gameeight.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gameeight.util.Constants;

public class WorldRenderer implements Disposable{
    WorldController worldController;
    OrthographicCamera camera;
    SpriteBatch batch;


    public WorldRenderer(WorldController worldController){
        this.worldController = worldController;
        init();
    }

    public void init(){

        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        batch = new SpriteBatch();
        camera.update();
    }

    public void render(){

        //handle input
        worldController.applyTo(camera);
        camera.update();
        batch.setProjectionMatrix(camera.combined);



        batch.begin();
        worldController.items.render(batch);
        worldController.cats.render(batch);


        batch.end();

    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
