package com.mygdx.gameeight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.mygdx.gameeight.util.Constants;

public class WorldRenderer implements Disposable{
    WorldController worldController;
    OrthographicCamera camera;
    SpriteBatch batch;
    GUIAssets guiAssets;

    private OrthographicCamera cameraGUI;


    public WorldRenderer(WorldController worldController){
        this.worldController = worldController;
        init();
    }

    public void init(){

        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);

        batch = new SpriteBatch();
        camera.update();

        cameraGUI = new OrthographicCamera(Constants.VIEWPORT_GUI_WIDTH, Constants.VIEWPORT_GUI_HEIGHT);
        cameraGUI.position.set(0,0,0);

        cameraGUI.update();

        guiAssets = new GUIAssets();

    }

    public void render(){
        renderWorld(batch);
        renderGUI(batch);


    }

    @Override
    public void dispose() {
        batch.dispose();
        guiAssets.dispose();

    }

    private void renderWorld(SpriteBatch batch){
        //handle input
        worldController.applyTo(camera);
        camera.update();

        batch.setProjectionMatrix(camera.combined);



        batch.begin();
        worldController.items.render(batch);
        worldController.cats.render(batch);


        batch.end();

    }

    private void renderGUI (SpriteBatch batch){
        batch.setProjectionMatrix(cameraGUI.combined);
        batch.begin();
        renderFPSCounter(batch);
        renderGUIText(batch);
        batch.end();
    }


    private void renderGUIText (SpriteBatch batch){
        float x = 0;
        float y = cameraGUI.viewportHeight / 2  -30;

        guiAssets.fonts.bmpFont.draw(batch, Constants.text,x, y);


    }

    private void renderFPSCounter (SpriteBatch batch){
        float x = cameraGUI.viewportWidth / 2 - 100;
        float y = -(cameraGUI.viewportHeight / 2) + 40;
        int fps = Gdx.graphics.getFramesPerSecond();
        BitmapFont fpsFont = guiAssets.fonts.bmpFont;
        if (fps >= 30) {
            // 45 or more FPS show up in Green
            fpsFont.setColor(0,1,0,1);
        } else if (fps >= 30){
            // 30 to 45 FPS show up in yellow
            fpsFont.setColor(1,1,0,1);
        } else {
            // Below 30 FPS show up in red
            fpsFont.setColor(1,0,0,1);
        }
        fpsFont.draw(batch, "FPS: " + fps, x, y);
        fpsFont.setColor(1,1,1,1); // set to white
    }



}
