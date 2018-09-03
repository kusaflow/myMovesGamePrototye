package com.kunal.GameArea.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.kunal.MainGame;

import java.io.BufferedReader;
import java.io.File;
import java.util.LinkedList;

public class inputScreen implements Screen{

    MainGame game;
    inputManager im;
    InputTaker inputTaker;
    Texture points;

    ///tmep
    FileHandle file;
    String data ,dataRecorder;

    public inputScreen(MainGame game) {
        this.game = game;
        im = new inputManager();
        inputTaker = new InputTaker();
        points = new Texture(Gdx.files.internal("testing/point.jpg"));

        data = new String();

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        input();

        game.batch.begin();

        if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            file = Gdx.files.local("testing/raw");
            data = file.readString();

            for (int i = 0; i < data.length(); i++) {
                dataRecorder = "";
                for (; data.charAt(i) != '\n'; i++) {
                    dataRecorder += data.charAt(i);
                }
                String[] tempData = dataRecorder.split("\t");
                game.batch.draw(points, Integer.parseInt(tempData[0]), Integer.parseInt(tempData[1]));
            }

        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            file = Gdx.files.local("testing/sorted");
            data = file.readString();

            for (int i = 0; i < data.length(); i++) {
                dataRecorder = "";
                for (; data.charAt(i) != '\n'; i++) {
                    dataRecorder += data.charAt(i);
                }
                String[] tempData = dataRecorder.split("\t");
                game.batch.draw(points, Integer.parseInt(tempData[0]), Integer.parseInt(tempData[1]));
            }
        }



        game.batch.end();

    }

    private void input(){
        Gdx.input.setInputProcessor(inputTaker);

    }

    @Override
    public void show() {

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
