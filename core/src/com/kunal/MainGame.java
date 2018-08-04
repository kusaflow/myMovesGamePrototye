package com.kunal;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.kunal.EveryMenu.TempMenu;

import java.util.LinkedList;

public class MainGame extends Game {
    public SpriteBatch batch;

	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;

	public static final float PPM = 50;

	public static float refreshRate = 60;

	public static Body tester , tester2;
	//whole character
    //left part is part 1 and right is part 2
	//1 is for lower , 2 is upper than 1 and so on
	public static Body Front_foot1, Front_foot2, Front_leg, Front_Thai, Back_foot1, Back_foot2, Back_leg, Back_Thai, Stomach1, Stomach2, Stomach3, neck, head;

    //Masks
    public static final short Bit_Player_Front= 1;
	public static final short Bit_Player_Back= 2;
	public static final short Bit_land = 4;
    public static final short Bit_enimes = 8;
	public static final short Bit_Tool= 16;


	//input Strings

    public static LinkedList<Integer> dataGivenX = new LinkedList<Integer>();
    public static LinkedList<Integer> dataGivenY  = new LinkedList<Integer>();


	@Override
	public void create () {
		batch = new SpriteBatch();
        this.setScreen(new TempMenu(this));
		dataGivenX.add(10);
        dataGivenY.add(10);
    }

	@Override
	public void render () {
		super.render();
	    /*
	        Gdx.gl.glClearColor(1, 0, 0, 1);
		    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    */
	}
}

