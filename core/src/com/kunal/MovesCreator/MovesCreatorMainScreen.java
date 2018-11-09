package com.kunal.MovesCreator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.kunal.AllVariables;
import com.kunal.GameArea.playGround.Player_moves;
import com.kunal.GameArea.playGround.objectCreation;
import com.kunal.MainGame;

public class MovesCreatorMainScreen implements Screen {
    private MainGame game;
    private World world;
    private Box2DDebugRenderer b2dr;
    private OrthographicCamera cam;
    private Viewport port;

    //body creation module
    objectCreation objcre;
    //player moves
    Player_moves player_moves;

    //variable for checking of swipes
    int xTouch =0;

    //textures
    private Texture addmoveBtn;

    //movesChossing
    StageForMultiMoveSelecting stageForMultiMoveSelecting;

    public MovesCreatorMainScreen(MainGame game) {
        this.game = game;
        cam = new OrthographicCamera();
        cam.setToOrtho(false, game.WIDTH/2, game.HEIGHT/2);

        port = new FitViewport(game.WIDTH/2, game.HEIGHT/2, cam);

        world = new World(new Vector2(0,-10f), false);

        b2dr = new Box2DDebugRenderer();

        objcre = new objectCreation(world);
        objcre.bodycreatation();
        objcre.joints();

        player_moves = new Player_moves();

        stageForMultiMoveSelecting= new StageForMultiMoveSelecting(game.batch);

        //textureinti
        textureInit();

    }

    private void textureInit(){
        addmoveBtn = new Texture("testing/customMoveScreen/addmoveBtn.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(.1f, .1f, .1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        b2dr.render(world, cam.combined.scl(game.PPM));
        //game.batch.setProjectionMatrix(sfmms.stage.getViewport().getCamera().combined);

        game.batch.begin();
        game.batch.draw(addmoveBtn,MainGame.WIDTH/2 - 62f,MainGame.HEIGHT/1.5f - 18f);
        game.batch.end();

        stageForMultiMoveSelecting.stage.act();
        stageForMultiMoveSelecting.stage.draw();


    }

    private void update (float dt){
        input(dt);
        player_moves.balancer();

        world.step(1 / MainGame.refreshRate, 6, 2);;
        //game.batch.setProjectionMatrix(cam.combined);

        stageForMultiMoveSelecting.stage.getViewport().getCamera().update();




        //camera Update
        Vector3 campos = cam.position;
        campos.x = AllVariables.head.getPosition().x*game.PPM;
        campos.y = AllVariables.head.getPosition().y*game.PPM;
        cam.position.set(campos);
        cam.update();


    }

    private void input(float dt){
        //add new move button
        if(Gdx.input.justTouched()){
            //System.out.println(Gdx.input.getY());
            if(Gdx.input.getX() > MainGame.WIDTH/2 - 62 && Gdx.input.getX() < MainGame.WIDTH/2 + 120
                    && MainGame.HEIGHT - Gdx.input.getY() > MainGame.HEIGHT/1.5f - 18f && MainGame.HEIGHT - Gdx.input.getY() < MainGame.HEIGHT/1.5f +117){
                System.out.println("working");
            }
        }
        System.out.println(stageForMultiMoveSelecting.stage.getViewport().getCamera().position);
        //System.out.println(stageForMultiMoveSelecting.stage.getViewport().getCamera().);


        if(Gdx.input.justTouched()){
            xTouch = Gdx.input.getX();
        }

        if(Gdx.input.isTouched()){
            //xTouch = Gdx.input.getX();
            //swipe to left
            if(Gdx.input.getX() < xTouch){
                stageForMultiMoveSelecting.stage.getViewport().getCamera().position.set(
                        stageForMultiMoveSelecting.stage.getViewport().getCamera().position.x + (xTouch - Gdx.input.getX())/10
                        ,stageForMultiMoveSelecting.stage.getViewport().getCamera().position.y,0);
            }

            if(Gdx.input.getX() > xTouch) {
                stageForMultiMoveSelecting.stage.getViewport().getCamera().position.set(
                        stageForMultiMoveSelecting.stage.getViewport().getCamera().position.x - (Gdx.input.getX() - xTouch)/10
                        , stageForMultiMoveSelecting.stage.getViewport().getCamera().position.y, 0);
            }

            if(stageForMultiMoveSelecting.stage.getViewport().getCamera().position.x <= MainGame.WIDTH/2){
                stageForMultiMoveSelecting.stage.getViewport().getCamera().position.set(MainGame.WIDTH/2,stageForMultiMoveSelecting.stage.getViewport().getCamera().position.y,0);
            }
            if(stageForMultiMoveSelecting.stage.getViewport().getCamera().position.x >= MainGame.WIDTH*2){
                //stageForMultiMoveSelecting.stage.getViewport().getCamera().position.set(MainGame.WIDTH*2,stageForMultiMoveSelecting.stage.getViewport().getCamera().position.y,0);
            }


        }


    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
        stageForMultiMoveSelecting.stage.getViewport().update(width, height);
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
        game.dispose();
        world.dispose();
        b2dr.dispose();
        stageForMultiMoveSelecting.stage.dispose();
    }
}
