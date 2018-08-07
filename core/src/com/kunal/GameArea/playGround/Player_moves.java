package com.kunal.GameArea.playGround;

import com.badlogic.gdx.math.Vector2;
import com.kunal.MainGame;

public class Player_moves {

    private float len = 2;
    private boolean front = true;


    public Player_moves() {
    }

    // to convert radian to degree the formula is
    //radian * (180/PI)
    public void balancer(){
        display();

        //for making the character in straight position
        //front--------------------------------
        if ((MainGame.Front_leg.getAngle() * (180/Math.PI))< -5) {
            MainGame.Front_leg.applyForce(new Vector2(MainGame.Front_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Front_leg.getWorldCenter().x,MainGame.Front_leg.getWorldCenter().y + len*4), true);
        }
        if ((MainGame.Front_leg.getAngle() * (180/Math.PI))> -5) {
            if (MainGame.Front_leg.getAngle() * (180/Math.PI) > 0)
                MainGame.Front_leg.applyForce(new Vector2(MainGame.Front_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Front_leg.getWorldCenter().x,MainGame.Front_leg.getWorldCenter().y + len*4), true);
            else
                MainGame.Front_leg.applyForce(new Vector2(-MainGame.Front_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Front_leg.getWorldCenter().x,MainGame.Front_leg.getWorldCenter().y + len*4), true);
        }

        if ((MainGame.Front_Thai.getAngle() * (180/Math.PI))< -5f) {
            MainGame.Front_Thai.applyForce(new Vector2(MainGame.Front_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Front_Thai.getWorldCenter().x,MainGame.Front_Thai.getWorldCenter().y + len*5), true);
        }


        if((MainGame.Front_Thai.getAngle() * (180/Math.PI)) > -5){
            if((MainGame.Front_Thai.getAngle() * (180/Math.PI)) >=0)
                MainGame.Front_Thai.applyForce(new Vector2(MainGame.Front_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Front_Thai.getWorldCenter().x,MainGame.Front_Thai.getWorldCenter().y + len*5), true);
            else
                MainGame.Front_Thai.applyForce(new Vector2(MainGame.Front_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Front_Thai.getWorldCenter().x,MainGame.Front_Thai.getWorldCenter().y + len*5), true);
        }


        //back---------------------------------
        if ((MainGame.Back_leg.getAngle() * (180/Math.PI))< -5f) {
            MainGame.Back_leg.applyForce(new Vector2(MainGame.Back_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Back_leg.getWorldCenter().x,MainGame.Back_leg.getWorldCenter().y + len*4), true);
        }
        if ((MainGame.Back_leg.getAngle() * (180/Math.PI))> -5f) {
            if (MainGame.Back_leg.getAngle() * (180/Math.PI) > 0)
                MainGame.Back_leg.applyForce(new Vector2(MainGame.Back_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Back_leg.getWorldCenter().x,MainGame.Back_leg.getWorldCenter().y + len*4), true);
            else
                MainGame.Back_leg.applyForce(new Vector2(-MainGame.Back_leg.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Back_leg.getWorldCenter().x,MainGame.Back_leg.getWorldCenter().y + len*4), true);

        }
        if ((MainGame.Back_Thai.getAngle() * (180/Math.PI))<= -5) {
            MainGame.Back_Thai.applyForce(new Vector2(MainGame.Back_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Back_Thai.getWorldCenter().x,MainGame.Back_Thai.getWorldCenter().y + len*5), true);
        }

        if((MainGame.Back_Thai.getAngle() * (180/Math.PI)) > -5){
            if((MainGame.Back_Thai.getAngle() * (180/Math.PI)) >=0)
                MainGame.Back_Thai.applyForce(new Vector2(MainGame.Back_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Back_Thai.getWorldCenter().x,MainGame.Back_Thai.getWorldCenter().y + len*5), true);
            else
                MainGame.Back_Thai.applyForce(new Vector2(MainGame.Back_Thai.getAngle()/(MainGame.PPM/5),0), new Vector2(MainGame.Back_Thai.getWorldCenter().x,MainGame.Back_Thai.getWorldCenter().y + len*5), true);

        }

        //commom ---------------------------

        if ((MainGame.Stomach1.getAngle() * (180/Math.PI))> 1f) {
            MainGame.Stomach1.applyForce(new Vector2(MainGame.Stomach1.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Stomach1.getWorldCenter().x,MainGame.Stomach1.getWorldCenter().y + len*5), true);
        }
        if ((MainGame.Stomach1.getAngle() * (180/Math.PI)) < -2f) {
            MainGame.Stomach1.applyForce(new Vector2(MainGame.Stomach1.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Stomach1.getWorldCenter().x,MainGame.Stomach1.getWorldCenter().y + len*5), true);
        }


        if ((MainGame.Stomach2.getAngle() * (180/Math.PI)) < -15f) {
            MainGame.Stomach2.applyForce(new Vector2(MainGame.Stomach2.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach2.getWorldCenter().x,MainGame.Stomach2.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach2.getAngle() * (180/Math.PI)) > -2) {
            MainGame.Stomach2.applyForce(new Vector2(MainGame.Stomach2.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach2.getWorldCenter().x,MainGame.Stomach2.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach3.getAngle() * (180/Math.PI)) < -15f) {
            MainGame.Stomach3.applyForce(new Vector2(MainGame.Stomach3.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach3.getWorldCenter().x,MainGame.Stomach3.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach3.getAngle() * (180/Math.PI)) > -2) {
            MainGame.Stomach3.applyForce(new Vector2(MainGame.Stomach3.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach3.getWorldCenter().x,MainGame.Stomach3.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.neck.getAngle() * (180/Math.PI)) < -3f) {
            MainGame.neck.applyForce(new Vector2(MainGame.neck.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.neck.getWorldCenter().x,MainGame.neck.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.neck.getAngle() * (180/Math.PI)) > 2) {
            MainGame.neck.applyForce(new Vector2(MainGame.neck.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.neck.getWorldCenter().x,MainGame.neck.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.head.getAngle() * (180/Math.PI)) < -3f) {
            MainGame.head.applyForce(new Vector2(MainGame.head.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.head.getWorldCenter().x,MainGame.head.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.head.getAngle() * (180/Math.PI)) > 2) {
            MainGame.head.applyForce(new Vector2(MainGame.head.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.head.getWorldCenter().x,MainGame.head.getWorldCenter().y + len*5), true);
        }



    }

    private void display(){
        System.out.println(MainGame.Front_foot2.getAngle() * (180/Math.PI) );
        //System.out.println(MainGame.Front_foot1.getWorldCenter().y + "\t\t" + MainGame.Back_foot1.getWorldCenter().y);
        //System.out.println(MainGame.Front_foot1.getWorldCenter().x + "\t\t" + MainGame.Stomach1.getWorldCenter().x);

    }

    public void nwalking(){

        MainGame.Stomach1.setAngularVelocity(-40);
        MainGame.Stomach2.setAngularVelocity(-40);
        MainGame.Stomach3.setAngularVelocity(-40);


        //forimage reffer running.jpg in android/assets/testing/
        //pose 1



        //MainGame.Stomach1.setLinearVelocity(0,-10);


    }

    public void walking(){

        //MainGame.Stomach1.setAngularVelocity(-40);
        //MainGame.Stomach2.setAngularVelocity(-40);
        //MainGame.Stomach3.setAngularVelocity(-40);


        if (MainGame.Front_foot2.getWorldCenter().y < 0.12f && MainGame.Back_foot2.getWorldCenter().y < 0.12f) {
            if(MainGame.Front_foot2.getWorldCenter().x > MainGame.Back_foot2.getWorldCenter().x)
                front = false;
            else
                front = true;
        }

        //MainGame.Stomach1.applyForceToCenter(2,-2, true);
        MainGame.Stomach1.setLinearVelocity(0,-2);


        if(front){
            MainGame.Stomach1.setLinearVelocity(4,MainGame.Stomach1.getLinearVelocity().y);
            if(MainGame.Front_Thai.getAngle() * (180 / Math.PI) <80)
                MainGame.Front_Thai.setAngularVelocity(70f);

            if(MainGame.Front_foot2.getPosition().x >= MainGame.Back_foot2.getPosition().x){
                MainGame.Front_foot2.setLinearVelocity(0, -5);
                if ((MainGame.Front_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Front_foot2.setAngularVelocity(70);
                }else {
                    //MainGame.Front_foot2.setAngularVelocity(0);
                }
            }else{
                MainGame.Front_foot2.setLinearVelocity(0, 5);
            }

            //MainGame.Back_leg.setAngularVelocity(-20);



        }else{
            MainGame.Stomach1.setLinearVelocity(4,MainGame.Stomach1.getLinearVelocity().y);
            if(MainGame.Back_Thai.getAngle() * (180 / Math.PI) < 80)
                MainGame.Back_Thai.setAngularVelocity(70f);


            if(MainGame.Back_foot2.getPosition().x >= MainGame.Front_foot2.getPosition().x){
                MainGame.Back_foot2.setLinearVelocity(0, -5);

                if ((MainGame.Back_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Back_foot2.setAngularVelocity(70);
                }else {
                    //MainGame.Back_foot2.setAngularVelocity(0);
                }
            }else{
                MainGame.Back_foot2.setLinearVelocity(0, 5);
            }
            //MainGame.Front_leg.setAngularVelocity(-20);

        }

        //MainGame.Front_leg.setAngularVelocity(10);


        //MainGame.Front_foot2.applyForceToCenter(0,-5,true);
        //MainGame.Back_foot2.applyForceToCenter(0,-5,true);


        //MainGame.Front_Thai.setAngularVelocity(50f);
        //MainGame.Back_Thai.setAngularVelocity(50f);


        //MainGame.Front_leg.setAngularVelocity(-50);
        //MainGame.Back_leg.setAngularVelocity(10);






    }






}
