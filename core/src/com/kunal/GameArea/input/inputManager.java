package com.kunal.GameArea.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.kunal.MainGame;


public class inputManager {

    FileHandle file;

    //String to carry the data
    String DataToFile = "";

    //the direction of the projection
    byte direction = 0;

    //comparable value
    int compareVal =0;

    public inputManager() {
    }

    public void DataSorting() {

        try {
            RawDataToFile();
            SortedDataToFile();

        }catch (Exception e){}
        //SORTED DATA TI FILE

        filewriting("testing/sorted",false);


    }

    private void RawDataToFile(){

        DataToFile = "";
        DataToFile+=Integer.toString(MainGame.dataGivenX.get(0));
        DataToFile+="\t";
        DataToFile+=Integer.toString(MainGame.HEIGHT -MainGame.dataGivenY.get(0));
        DataToFile+="\n";
        for (int i=0; i<MainGame.dataGivenX.size(); i++){
            DataToFile+=Integer.toString(MainGame.dataGivenX.get(i));
            DataToFile+="\t";
            DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(i));
            DataToFile+="\n";
        }

        //raw data is downloaded to the file
        filewriting("testing/raw",false);
    }

    private void SortedDataToFile() {
        int i = 0;
        boolean straight;
        compareVal = 0;
        direction = 0;
        //now the sorted data is in downloading process
        DataToFile = "";

        /*
        Directions are :
            ----------------------------
            1st quadrant is 1
            2nd quadrant is 2
            3rd quadrant is 3
            4tg quadrant is 4
            ----------------------------
            x axis positive Straight line is 5
            y axis positive straight line is 6
            x axis negative straight line is 7
            y axis negative straight line is 8
            ----------------------------

        */
        for (i = 1; i < MainGame.dataGivenX.size(); i++) {
            straight = false;
            /*
            for checking linearity(Straighline)
            if found so then no more condition is eecuter and
            data is saved to the file and process restarts
            */
            //for positive x axis
            if(direction == 1 || direction == 4 || direction == 5){
                //if already a stright line with code 5
                if(direction == 5)
                    if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1) > 0)//goiing positive x axis
                        if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i - 1) <= compareVal)//in range of y axis
                            continue;

                //if not belongs to direction code 5 then chnecking for it



            }



            /*
            when the condition turns to be wrong
            or in other words the direction changes
            */
            DataToFile+=Integer.toString(MainGame.dataGivenX.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(direction);
            DataToFile+="\n";

            /*
            New direction provider
            also if the line is straight then the direction providing is done above not here
            if not straight then here new direction is provided
            */
            if(!straight){

            }

        }



        //for the last value
        DataToFile+=Integer.toString(MainGame.dataGivenX.get(MainGame.dataGivenX.size() -1));
        DataToFile+="\t";
        DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(MainGame.dataGivenY.size() -1));
        DataToFile+="\t";
        DataToFile+=Integer.toString(direction);
        DataToFile+="\n";




    }

    private void printing(){
        System.out.println("now");
        for (int i=0; i<MainGame.dataGivenX.size(); i++){
            System.out.println(MainGame.dataGivenX.get(i) +"\t\t" + MainGame.dataGivenY.get(i));
        }
    }

    public void filewriting(String Location, Boolean append){
        file = Gdx.files.local(Location);
        file.writeString(DataToFile, append);
    }


}