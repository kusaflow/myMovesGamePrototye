package com.kunal.EveryMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.kunal.GameArea.PlayGround;
import com.kunal.GameArea.input.inputScreen;
import com.kunal.MainGame;

public class TempMenu implements Screen{
    MainGame game;

    public TempMenu(MainGame game) {
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1f, 1f, 1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if(Gdx.input.justTouched()){
            game.setScreen(new inputScreen(game));
        }/*
        if(Gdx.input.isTouched()){
            System.out.println(Gdx.input.getX());
        }*/
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
