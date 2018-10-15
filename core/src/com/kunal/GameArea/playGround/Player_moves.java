package com.kunal.GameArea.playGround;

import com.badlogic.gdx.math.Vector2;
import com.kunal.MainGame;

public class Player_moves {

    private float len = 2;
    private static boolean front = true;
    public static float FootLevel = 0.12f;

    private boolean HandsMovingPermission = true;


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

        if(MainGame.Front_foot1.getAngle() * (180/Math.PI) < 0){
            MainGame.Front_foot1.setAngularVelocity(200);
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

        if(MainGame.Back_foot1.getAngle() * (180/Math.PI) < 0){
            MainGame.Back_foot1.setAngularVelocity(200);
        }

        //commom ---------------------------

        if ((MainGame.Stomach1.getAngle() * (180/Math.PI))> 1f) {
            MainGame.Stomach1.applyForce(new Vector2(MainGame.Stomach1.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Stomach1.getWorldCenter().x,MainGame.Stomach1.getWorldCenter().y + len*5), true);
        }
        if ((MainGame.Stomach1.getAngle() * (180/Math.PI)) <=1f) {
            MainGame.Stomach1.applyForce(new Vector2(MainGame.Stomach1.getAngle()/(MainGame.PPM/3),0), new Vector2(MainGame.Stomach1.getWorldCenter().x,MainGame.Stomach1.getWorldCenter().y + len*5), true);
        }


        if ((MainGame.Stomach2.getAngle() * (180/Math.PI)) <= -2f) {
            MainGame.Stomach2.applyForce(new Vector2(MainGame.Stomach2.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach2.getWorldCenter().x,MainGame.Stomach2.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach2.getAngle() * (180/Math.PI)) > -2) {
            MainGame.Stomach2.applyForce(new Vector2(MainGame.Stomach2.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach2.getWorldCenter().x,MainGame.Stomach2.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach3.getAngle() * (180/Math.PI)) <= -2f) {
            MainGame.Stomach3.applyForce(new Vector2(MainGame.Stomach3.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach3.getWorldCenter().x,MainGame.Stomach3.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.Stomach3.getAngle() * (180/Math.PI)) > -2) {
            MainGame.Stomach3.applyForce(new Vector2(MainGame.Stomach3.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.Stomach3.getWorldCenter().x,MainGame.Stomach3.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.neck.getAngle() * (180/Math.PI)) < -1f) {
            MainGame.neck.applyForce(new Vector2(MainGame.neck.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.neck.getWorldCenter().x,MainGame.neck.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.neck.getAngle() * (180/Math.PI)) > -1) {
            MainGame.neck.applyForce(new Vector2(MainGame.neck.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.neck.getWorldCenter().x,MainGame.neck.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.head.getAngle() * (180/Math.PI)) < -1f) {
            MainGame.head.applyForce(new Vector2(MainGame.head.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.head.getWorldCenter().x,MainGame.head.getWorldCenter().y + len*5), true);
        }

        if ((MainGame.head.getAngle() * (180/Math.PI)) > -1) {
            MainGame.head.applyForce(new Vector2(MainGame.head.getAngle()/(MainGame.PPM/2),0), new Vector2(MainGame.head.getWorldCenter().x,MainGame.head.getWorldCenter().y + len*5), true);
        }

    }

    private void display(){
        //System.out.println(MainGame.Back_arm.getAngle() * (180/ Math.PI));
        //System.out.println(MainGame.Front_foot1.getWorldCenter().x + "\t\t" + MainGame.Back_foot1.getWorldCenter().x + "\t" + MainGame.Stomach1.getWorldCenter().x );
        //System.out.println(MainGame.Front_foot1.getWorldCenter().y + "\t\t" + MainGame.Back_foot1.getWorldCenter().y);
        //System.out.println(MainGame.Front_foot1.getWorldCenter().x + "\t\t" + MainGame.Stomach1.getWorldCenter().x);
        //if(MainGame.Front_foot1.getLinearVelocity().y >= 0)
            //System.out.println(MainGame.Front_foot1.getLinearVelocity().y);

        //System.out.println(MainGame.Front_foot2.getWorldCenter().y);
        //System.out.println(MainGame.Front_foot2.getLinearVelocity().y);
        //System.out.println(MainGame.Front_Thai.getAngle() * (180/Math.PI));
        System.out.println(MainGame.Stomach1.getAngle() * (180/Math.PI));




    }

    public void walkingWithBigSteps(){
        //MainGame.Stomach3.setAngularVelocity(40);

        if (MainGame.Front_foot2.getWorldCenter().y < 0.12f && MainGame.Back_foot2.getWorldCenter().y < 0.12f) {
            if(MainGame.Front_foot2.getWorldCenter().x > MainGame.Back_foot2.getWorldCenter().x)
                front = false;
            else
                front = true;
        }

        //MainGame.Stomach1.applyForceToCenter(2,-2, true);
        //MainGame.Stomach1.setLinearVelocity(0,-2);


        //-------------------------front leg --------------------------
        if(front){

            if(HandsMovingPermission){
                if(MainGame.Back_arm.getAngle() * (180/Math.PI) > 30)
                    MainGame.Back_arm.setAngularVelocity(-20);
                else
                    MainGame.Back_arm.setAngularVelocity(20);

                if(MainGame.Front_arm.getAngle() * (180/Math.PI) < -30)
                    MainGame.Front_arm.setAngularVelocity(20);
                else
                    MainGame.Front_arm.setAngularVelocity(-20);

            }


            MainGame.Back_foot1.applyForceToCenter(0, -20, true);

            MainGame.Stomach1.setLinearVelocity(6,MainGame.Stomach1.getLinearVelocity().y);
            if(MainGame.Front_Thai.getAngle() * (180 / Math.PI) <80)
                MainGame.Front_Thai.setAngularVelocity(70f);

            if(MainGame.Front_foot2.getPosition().x >= MainGame.Back_foot2.getPosition().x){
                MainGame.Front_foot2.setLinearVelocity(0, -5);
                if ((MainGame.Front_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Front_foot2.setAngularVelocity(7);
                }else {
                    //MainGame.Front_foot2.setAngularVelocity(0);
                }
            }else{
                MainGame.Front_foot2.setLinearVelocity(0, 5);
            }

            //MainGame.Back_leg.setAngularVelocity(-20);
        }
        //---------------Back Leg----------------
        else{

            if(HandsMovingPermission){
                if(MainGame.Front_arm.getAngle() * (180/Math.PI) > 30)
                    MainGame.Front_arm.setAngularVelocity(-20);
                else
                    MainGame.Front_arm.setAngularVelocity(20);

                if(MainGame.Back_arm.getAngle() * (180/Math.PI) < -30)
                    MainGame.Back_arm.setAngularVelocity(20);
                else
                    MainGame.Back_arm.setAngularVelocity(-20);


            }

            MainGame.Front_foot1.applyForceToCenter(0, -20, true);

            MainGame.Stomach1.setLinearVelocity(6,MainGame.Stomach1.getLinearVelocity().y);

            if(MainGame.Back_Thai.getAngle() * (180 / Math.PI) < 80)
                MainGame.Back_Thai.setAngularVelocity(70f);


            if(MainGame.Back_foot2.getPosition().x >= MainGame.Front_foot2.getPosition().x){
                MainGame.Back_foot2.setLinearVelocity(0, -5);

                if ((MainGame.Back_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Back_foot2.setAngularVelocity(7);
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

    public void walkingimproper(){

        //MainGame.Stomach1.setAngularVelocity(-30);

        //MainGame.Stomach2.setAngularVelocity(20);


        if (MainGame.Front_foot2.getWorldCenter().y < FootLevel+0.02 && MainGame.Back_foot2.getWorldCenter().y < FootLevel+0.02) {
            if(MainGame.Front_foot2.getWorldCenter().x > MainGame.Back_foot2.getWorldCenter().x)
                front = false;
            else
                front = true;
        }

        MainGame.Stomach1.setLinearVelocity(2f,MainGame.Stomach1.getLinearVelocity().y);



        //-------------------------front leg --------------------------
        if(front){

            MainGame.Back_foot1.applyForceToCenter(0, -5, true);

            if(MainGame.Front_Thai.getAngle() * (180 / Math.PI) <30)
                MainGame.Front_Thai.setAngularVelocity(50f);

            if(MainGame.Front_foot2.getPosition().x >= MainGame.Back_foot2.getPosition().x){
                MainGame.Front_foot2.setLinearVelocity(0, -2);
                if ((MainGame.Front_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Front_foot2.setAngularVelocity(7);
                }else {
                    //MainGame.Front_foot2.setAngularVelocity(0);
                }
            }else{
                MainGame.Front_foot2.setLinearVelocity(0, 10);
                MainGame.Back_foot2.applyForceToCenter(0, -30, true);
            }

            //MainGame.Back_leg.setAngularVelocity(-20);
        }


        //---------------Back Leg----------------
        else{

            MainGame.Front_foot1.applyForceToCenter(0, -5, true);

            if(MainGame.Back_Thai.getAngle() * (180 / Math.PI) < 30)
                MainGame.Back_Thai.setAngularVelocity(50f);


            if(MainGame.Back_foot2.getPosition().x >= MainGame.Front_foot2.getPosition().x){
                MainGame.Back_foot2.setLinearVelocity(0, -2);

                if ((MainGame.Back_foot2.getAngle() * (180/ Math.PI)) < 0){
                    MainGame.Back_foot2.setAngularVelocity(7);
                }else {
                    //MainGame.Back_foot2.setAngularVelocity(0);
                }
            }else{
                MainGame.Back_foot2.setLinearVelocity(0, 10);
                MainGame.Front_foot2.applyForceToCenter(0, -30, true);
            }
            //MainGame.Front_leg.setAngularVelocity(-20);
        }
    }

    public void walking(){
        if (MainGame.Front_foot2.getWorldCenter().y < FootLevel && MainGame.Back_foot2.getWorldCenter().y < FootLevel) {
            if(MainGame.Front_foot2.getWorldCenter().x > MainGame.Back_foot2.getWorldCenter().x) {
                front = false;
                MainGame.Back_foot2.applyForceToCenter(0,2,true);

            }
            else {
                front = true;
                MainGame.Front_foot2.applyForceToCenter(0,2,true);

            }
        }

        System.out.println(MainGame.Front_foot2.getWorldCenter().y + "\t" + MainGame.Back_foot2.getWorldCenter().y);




        //-------------------------front leg --------------------------
        if(front){
            if(MainGame.Front_Thai.getAngle() * (180/ Math.PI) >30)
                MainGame.Front_Thai.setAngularVelocity(50);
            else
                MainGame.Front_Thai.setAngularVelocity(-20);

            if(MainGame.Back_Thai.getAngle() * (180/ Math.PI) < 30)
                MainGame.Back_Thai.setAngularVelocity(50);
            else
                MainGame.Back_Thai.setAngularVelocity(-20);



        }


        //---------------Back Leg----------------
        else{

            if(MainGame.Back_Thai.getAngle() * (180/ Math.PI) >30)
                MainGame.Back_Thai.setAngularVelocity(50);
            else
                MainGame.Back_Thai.setAngularVelocity(-20);

            if(MainGame.Front_Thai.getAngle() * (180/ Math.PI) < -30)
                MainGame.Front_Thai.setAngularVelocity(50);
            else
                MainGame.Front_Thai.setAngularVelocity(-20);



        }
    }

    public void tester(){
        //else if(MainGame.Front_Thai.getAngle() * (180/Math.PI) > 60)
            MainGame.Stomach1.setAngularVelocity(-30);


        //System.out.println(MainGame.Front_Thai.getAngle() * (180/Math.PI));
    }

    public void running () {

        MainGame.Stomach1.setAngularVelocity(-13);
        MainGame.Stomach2.setAngularVelocity(-13);
        MainGame.Stomach3.setAngularVelocity(-13);




        if(MainGame.Front_Thai.getAngle() * (180 / Math.PI) > 68 + MainGame.Stomach1.getAngle() * (180/Math.PI)
                && MainGame.Back_Thai.getAngle() * (180 / Math.PI) < -20 - MainGame.Stomach1.getAngle() * (180/Math.PI)/2
                && MainGame.Front_foot2.getWorldCenter().y < FootLevel+0.2f && front == true
                && (int)(MainGame.Back_foot1.getLinearVelocity().y) ==0) {
            front = false;
            //MainGame.Stomach1.applyForceToCenter(15,0,true);
            MainGame.Stomach1.setLinearVelocity(7*MainGame.FrameAffector,0);
        }
        if (MainGame.Front_Thai.getAngle() * (180 / Math.PI) < -20 - MainGame.Stomach1.getAngle() * (180/Math.PI)/2
                && MainGame.Back_Thai.getAngle() * (180 / Math.PI) > 68 + MainGame.Stomach1.getAngle() * (180/Math.PI)
                && MainGame.Back_foot2.getWorldCenter().y < FootLevel+0.2f && front == false
                && (int)(MainGame.Front_foot1.getLinearVelocity().y) ==0) {
                front = true;
            //MainGame.Stomach1.applyForceToCenter(15,0,true);
            MainGame.Stomach1.setLinearVelocity(7*MainGame.FrameAffector,0);

        }

        //System.out.println(MainGame.Front_Thai.getAngle()*(180/Math.PI) + "\t\t" + MainGame.Back_Thai.getAngle()*(180/Math.PI));
        //System.out.println(MainGame.Front_Thai.getAngle() * (180/Math.PI) + "\t" + MainGame.Back_Thai.getAngle() * (180 / Math.PI));



        if(front){
            //movement of thais
            if(MainGame.Front_Thai.getAngle() * (180/Math.PI) < 65) {
                MainGame.Front_Thai.setAngularVelocity(43 * MainGame.FrameAffector);
                //MainGame.Stomach1.setLinearVelocity(0,-5);
            }else{
                //MainGame.Stomach1.applyForceToCenter(0,-5, true);
            }
            if(MainGame.Back_Thai.getAngle() * (180/Math.PI) > -25)
                MainGame.Back_Thai.setAngularVelocity(-30*MainGame.FrameAffector);

            //movement of leg
            MainGame.Front_leg.setAngularVelocity(-50*MainGame.FrameAffector);
            //MainGame.Back_leg.setAngularVelocity(100);



            //downward force by foots
            if(MainGame.Front_foot2.getWorldCenter().x > MainGame.Back_foot2.getWorldCenter().x){
                MainGame.Back_foot2.applyForceToCenter(0,-10, true);
                MainGame.Front_foot1.applyForceToCenter(0,-2, true);
            }else{
                MainGame.Back_foot1.applyForceToCenter(0,-5, true);
            }

        }



        else{
            if(MainGame.Front_Thai.getAngle() * (180/Math.PI) > -25)
                MainGame.Front_Thai.setAngularVelocity(-30*MainGame.FrameAffector);
            if(MainGame.Back_Thai.getAngle() * (180/Math.PI) < 65) {
                MainGame.Back_Thai.setAngularVelocity(43 * MainGame.FrameAffector);
                //MainGame.Stomach1.setLinearVelocity(0,-5);
            }else{
                //MainGame.Stomach1.applyForceToCenter(0,-5, true);
            }

            MainGame.Back_leg.setAngularVelocity(-50*MainGame.FrameAffector);
            //MainGame.Front_leg.setAngularVelocity(100);



            //downward force by foots
            if(MainGame.Front_foot2.getWorldCenter().x < MainGame.Back_foot2.getWorldCenter().x){
                MainGame.Front_foot2.applyForceToCenter(0,-10, true);
                MainGame.Front_foot1.applyForceToCenter(0,-2, true);
            }else{
                MainGame.Front_foot1.applyForceToCenter(0,-5, true);
            }

        }

        //System.out.println(MainGame.Front_Thai.getAngle() * (180/Math.PI) + "\t" + MainGame.Back_Thai.getAngle() * (180/Math.PI));





    }


    public void backflip(){

        MainGame.Stomach1.applyForceToCenter(0,50,true);
    }

}
