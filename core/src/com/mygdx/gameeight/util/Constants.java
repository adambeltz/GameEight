package com.mygdx.gameeight.util;

import com.badlogic.gdx.Gdx;

public class Constants {
    public static final float ASPECT_RATIO = (float)Gdx.graphics.getHeight() / (float)Gdx.graphics.getWidth();

    public static final float VIEWPORT_WIDTH = 100;
    public static final float VIEWPORT_HEIGHT = 100 * ASPECT_RATIO;

    public static boolean RUNNING = true;


    public static final float VIEWPORT_GUI_WIDTH = 1366F;
    public static final float VIEWPORT_GUI_HEIGHT = 768F;
    public static final String text = "TEST GuI";


}
