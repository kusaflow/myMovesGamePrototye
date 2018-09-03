package com.kunal.MovesCreator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
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

    }

    private void update (float dt){
        world.step(1 / MainGame.refreshRate, 6, 2);;
        game.batch.setProjectionMatrix(cam.combined);


        //camera Update
        Vector3 campos = cam.position;
        campos.x = game.head.getPosition().x*game.PPM;
        campos.y = game.head.getPosition().y*game.PPM;
        cam.position.set(campos);
        cam.update();

    }

    @Override
    public void resize(int width, int height) {
        port.update(width, height);
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
    }
}
