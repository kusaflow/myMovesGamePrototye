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

    //For tempCal
    int tmpval=0;

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
        compareVal = 10;
        direction = 0;
        //now the sorted data is in downloading process
        DataToFile = "";
        int StraighnessStartFrom =0;

        /*
        Directions are :
            ----------------------------
            1st quadrant is 1
            2nd quadrant is 2
            3rd quadrant is 3
            4th quadrant is 4
            ----------------------------
            x axis positive Straight line is 5
            y axis positive straight line is 6
            x axis negative straight line is 7
            y axis negative straight line is 8
            ----------------------------

        */
        //direction =0;
        for (i = 0; i < MainGame.dataGivenX.size()-1; i++) {

            //for positive x axis Striaght line code : 5
            if (direction == 5) {
                if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(i) >= 0) {//goiing positive x axis
                    if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(StraighnessStartFrom) >= 0) {//in positive direction of y axis
                        if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(StraighnessStartFrom) <= compareVal) //in range
                            continue;
                    } else {//in negative
                        if (MainGame.dataGivenY.get(StraighnessStartFrom) - MainGame.dataGivenY.get(i + 1) <= compareVal) {
                            continue;
                        }
                    }
                }
            }

            //for positive y axis Striaght line code : 6
            if (direction == 6) {
                if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 1) > 0) {//goiing positive y axis
                    if (MainGame.dataGivenX.get(StraighnessStartFrom) - MainGame.dataGivenX.get(i + 1) >= 0) {//in positive direction of x axis
                        if (MainGame.dataGivenX.get(StraighnessStartFrom) - MainGame.dataGivenX.get(i + 1) <= compareVal) //in range
                            continue;
                    } else {//in negative
                        if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(StraighnessStartFrom) <= compareVal) {
                            continue;
                        }
                    }
                }
            }

            //for negative x axis Striaght line code : 7
            if (direction == 7) {
                if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 1) > 0) {//goiing positive x axis
                    if (MainGame.dataGivenY.get(StraighnessStartFrom) - MainGame.dataGivenY.get(i + 1) >= 0) {//in positive direction of y axis
                        if (MainGame.dataGivenY.get(StraighnessStartFrom) - MainGame.dataGivenY.get(i + 1) <= compareVal) //in range
                            continue;
                    } else {//in negative
                        if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(StraighnessStartFrom) <= compareVal) {
                            continue;
                        }
                    }
                }

            }

            //for negative y axis Striaght line code : 8
            if (direction == 8) {
                if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(i) > 0) {//goiing positive y axis
                    if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(StraighnessStartFrom) >= 0) {//in positive direction of x axis
                        if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(StraighnessStartFrom) <= compareVal) //in range
                            continue;
                    } else {//in negative
                        if (MainGame.dataGivenX.get(StraighnessStartFrom) - MainGame.dataGivenX.get(i + 1) <= compareVal) {
                            continue;
                        }
                    }
                }

            }



            //first quadrant code : 1
            if(direction ==1 ){
                if(MainGame.dataGivenX.get(i+1) > MainGame.dataGivenX.get(i)){
                    if(MainGame.dataGivenY.get(i+1) > MainGame.dataGivenY.get(i)){
                        continue;
                    }else{
                        if(MainGame.dataGivenY.get(i+2) > MainGame.dataGivenY.get(i+1)){
                            i++;
                            continue;
                        }else{
                            if(MainGame.dataGivenY.get(i+3) > MainGame.dataGivenY.get(i+2)){
                                i+=2;
                                continue;
                            }
                        }
                    }
                }else{
                    if(MainGame.dataGivenX.get(i+2) > MainGame.dataGivenX.get(i+1)){
                        i++;
                        continue;
                    }else{
                        if(MainGame.dataGivenX.get(i+3) > MainGame.dataGivenX.get(i+2)){
                            i+=2;
                            continue;
                        }
                    }
                }

            }

            /*
            //second quadrant code : 2
            if(direction ==2 ){
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i+1) >= 0)
                    if(MainGame.dataGivenY.get(i+1) - MainGame.dataGivenY.get(i) >= 0)
                        continue;
            }

            //third quadrant code : 3
            if(direction ==3 ){
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i+1) >= 0)
                    if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i+1) >= 0)
                        continue;
            }

            //forth quadrant code : 4
            if(direction ==4 ){
                if(MainGame.dataGivenX.get(i+1) - MainGame.dataGivenX.get(i) >= 0)
                    if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i+1) >= 0)
                        continue;
            }

                */



            /*
            when the condition turns to be wrongq
            or in other words the direction changes
            */

            DataToFile += Integer.toString(MainGame.dataGivenX.get(i));
            DataToFile += "\t";
            DataToFile += Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(i));
            DataToFile += "\t";
            DataToFile += Integer.toString(direction);
            DataToFile += "\n";
            //new Value assigner
            /*
            first checking for straightness
             */

            //---------------------for positive x axis Striaght line code : 5

            // straigtness level 1
            if (direction != 5) {
                if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(i) > 0) {
                    // straigtness level 2
                    if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) > 0) {

                        //checking for positive or negative direction
                        if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(i) >= 0) {
                            if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(i) <= compareVal) {
                                if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) >= 0) {
                                    if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) <= compareVal) {
                                        direction = 5;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) <= compareVal) {
                                        direction = 5;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                            //other direction
                        } else {
                            if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 1) <= compareVal) {
                                if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) >= 0) {
                                    if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) <= compareVal) {
                                        direction = 5;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) <= compareVal) {
                                        direction = 5;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }

            }

            //---------------------for positive y axis Striaght line code : 6
            if (direction != 6) {
                // straigtness level 1
                if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 1) > 0) {
                    // straigtness level 2
                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) > 0) {

                        //checking for positive or negative direction
                        if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 1) >= 0) {
                            if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 1) <= compareVal) {
                                if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) >= 0) {
                                    if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) <= compareVal) {
                                        direction = 6;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) <= compareVal) {
                                        direction = 6;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                            //other direction
                        } else {
                            if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(i) <= compareVal) {
                                if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) >= 0) {
                                    if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) <= compareVal) {
                                        direction = 6;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) <= compareVal) {
                                        direction = 6;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //---------------------for negative x axis Striaght line code : 7
            if (direction != 7) {
                // straigtness level 1
                if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 1) > 0) {
                    // straigtness level 2
                    if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) > 0) {

                        //checking for positive or negative direction
                        if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 1) >= 0) {
                            if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 1) <= compareVal) {
                                if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) >= 0) {
                                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) <= compareVal) {
                                        direction = 7;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) <= compareVal) {
                                        direction = 7;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                            //other direction
                        } else {
                            if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(i) <= compareVal) {
                                if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) >= 0) {
                                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i + 3) <= compareVal) {
                                        direction = 7;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) <= compareVal) {
                                        direction = 7;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }

            }

            //---------------------for negative x axis Striaght line code : 8
            if (direction != 8) {
                // straigtness level 1
                if (MainGame.dataGivenY.get(i + 1) - MainGame.dataGivenY.get(i) > 0) {
                    // straigtness level 2
                    if (MainGame.dataGivenY.get(i + 3) - MainGame.dataGivenY.get(i) > 0) {

                        //checking for positive or negative direction
                        if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(i) >= 0) {
                            if (MainGame.dataGivenX.get(i + 1) - MainGame.dataGivenX.get(i) <= compareVal) {
                                if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) >= 0) {
                                    if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) <= compareVal) {
                                        direction = 8;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) <= compareVal) {
                                        direction = 8;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                            //other direction
                        } else {
                            if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 1) <= compareVal) {
                                if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) >= 0) {
                                    if (MainGame.dataGivenX.get(i + 3) - MainGame.dataGivenX.get(i) <= compareVal) {
                                        direction = 8;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                                //other direction
                                else {
                                    if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i + 3) <= compareVal) {
                                        direction = 8;
                                        StraighnessStartFrom = i;
                                        continue;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            //tmp variable to do temp stuffs

            if (direction != 1) {
                tmpval =0;
                for(int k =0; k<3;k++){
                    if(MainGame.dataGivenX.get(i+k+1) > MainGame.dataGivenX.get(i+k)){
                        tmpval++;
                    }
                }
                if(tmpval == 3){
                    for(int k =0; k<3;k++){
                        if(MainGame.dataGivenY.get(i+k+1) > MainGame.dataGivenY.get(i+k)){
                            tmpval++;
                        }
                    }
                }

                if(tmpval == 6)
                    direction = 1;

            }

            /*//any other direction then
            else {

            }*/


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