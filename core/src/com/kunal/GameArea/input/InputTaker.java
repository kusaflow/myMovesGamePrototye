package com.kunal.GameArea.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.kunal.MainGame;

public class InputTaker implements InputProcessor{

    inputManager im;

    public InputTaker() {
        im = new inputManager();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        MainGame.dataGivenX.clear();
        MainGame.dataGivenY.clear();
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        try {
            im.DataSorting();
        } catch (Exception e) {
            System.out.println(e);
        }


        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        //System.out.println(screenY);
        MainGame.dataGivenX.add(screenX);
        MainGame.dataGivenY.add(screenY);

        return false;
    }


    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
