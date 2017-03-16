package com.mygdx.gameeight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Disposable;


public class Assets implements Disposable, AssetErrorListener{
    public static final String TAG = Assets.class.getName();

    AssetManager assetManager;

    TextureAtlas.AtlasRegion backgroundAR;
    TextureAtlas.AtlasRegion berriesAR;
    TextureAtlas.AtlasRegion grayCatAR;
    TextureAtlas.AtlasRegion brownCatAR;
    TextureAtlas.AtlasRegion lipsAR;
    TextureAtlas.AtlasRegion cactusAR;

    TextureAtlas textureAtlas;

    public Assets(){
        init();
    }

    public void init(){
        assetManager = new AssetManager();

        // Set asset manager error handler
        assetManager.setErrorListener(this);

        assetManager.load("Atlas.atlas", TextureAtlas.class);
        assetManager.finishLoading();

        Gdx.app.log(TAG, "# of assets loaded: " + assetManager.getAssetNames().size);

        for (String a : assetManager.getAssetNames()){
            Gdx.app.log(TAG, "asset: " + a);
        }

        textureAtlas = assetManager.get("Atlas.atlas");

        // Enable texture filtering for pixel smoothing
        for(Texture t : textureAtlas.getTextures()) {
            t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);

        }

        // Create resource objects
        backgroundAR = textureAtlas.findRegion("background_1920x1080");
        berriesAR = textureAtlas.findRegion("berries");
        lipsAR = textureAtlas.findRegion("lips");
        cactusAR = textureAtlas.findRegion("cactus");
        grayCatAR = textureAtlas.findRegion("gray_cat_front001_small");
        brownCatAR = textureAtlas.findRegion("cat");



    }


    @Override
    public void error(AssetDescriptor asset, Throwable throwable) {
        Gdx.app.error(TAG, "Couldn't load asset: " + asset.fileName, (Exception)throwable);

    }

    @Override
    public void dispose() {
        assetManager.dispose();
        textureAtlas.dispose();

    }
}
