package com.mygdx.gameeight;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.gameeight.game.Assets;
import com.mygdx.gameeight.game.WorldController;
import com.mygdx.gameeight.game.WorldRenderer;
import com.mygdx.gameeight.util.Constants;

public class GameEightMain extends ApplicationAdapter {
	WorldRenderer worldRenderer;
	WorldController worldController;

	public static Assets assets;

	@Override
	public void create () {

		assets = new Assets();
		worldController = new WorldController();
		worldRenderer = new WorldRenderer(worldController);
	}

	@Override
	public void render () {
		// Set up hotswap
		if (Constants.RUNNING == false){
			Constants.RUNNING = true;
			dispose();
			create();
		}

		worldController.update(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		worldRenderer.render();
	}
	
	@Override
	public void dispose () {
		assets.dispose();
		worldRenderer.dispose();


	}
}
