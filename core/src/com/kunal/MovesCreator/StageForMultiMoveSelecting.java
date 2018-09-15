package com.kunal.MovesCreator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kunal.Account.tempAcc;
import com.kunal.MainGame;

public class StageForMultiMoveSelecting {
    public Stage stage;
    private Viewport port;
    tempAcc acc;
    Image img;

    public StageForMultiMoveSelecting(SpriteBatch sb) {
        port = new FitViewport(MainGame.WIDTH, MainGame.HEIGHT, new OrthographicCamera());



        stage = new Stage(port, sb);

        stage.getViewport().getCamera().position.set(MainGame.WIDTH/2, MainGame.HEIGHT/2, 0);


        for (int i = 0; i < 14; i++) {
            img = new Image(new Texture("badlogic.jpg"));
            img.scaleBy(-0.2f);
            img.setPosition(280*i, MainGame.HEIGHT/2 + 50);
            stage.addActor(img);
        }




    }
}
