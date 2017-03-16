package com.mygdx.gameeight.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

public class GUIAssets implements Disposable{

    public AssetFonts fonts;

    public GUIAssets(){
        init();
    }

    public void init(){
            fonts = new AssetFonts();
        }

    @Override
    public void dispose() {
        fonts.bmpFont.dispose();
    }

    public class AssetFonts {

        public final BitmapFont bmpFont;


        public AssetFonts(){

            bmpFont = new BitmapFont(Gdx.files.internal("arial-15.fnt"));
            bmpFont.getData().setScale(1.5f);

            // Enable linear texture filtering for smooth fonts
            bmpFont.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        }


    }
}
