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

    //slope
    float slope =0;


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

    private void SortedDataToFile(){
        int i = 0;
        compareVal = 0;
        direction = 0;
        //now the sorted data is in downloading process
        DataToFile = "";
        slope =0;


        for (i = 1; i < MainGame.dataGivenX.size(); i++) {
            //slope formula user
            // m(slope) = y2 - y1/x2-x1

            //phase one 1
            //+ve x axis and alter y axis
            if(direction == 1){
                //upwards on x axis
                if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1) >= 0){
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1));
                }
                //downwards on x axis
                else{
                    slope = (MainGame.dataGivenY.get(i-1) - MainGame.dataGivenY.get(i))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1));
                }
                if (slope <= 1.0)
                    continue;
            }

            //phase two 2
            //+ve y axis and alter x axis
            else if(direction == 2){
                //right side on x axis
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1) >= 0){
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1));
                }
                //left side on x axis
                else{
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1
                    )) / (MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i));
                }
                if (slope > 1.0)
                    continue;
            }

            //phase three 3
            //-ve x axis and alter y axis
            else if(direction == 3){
                //upwards on x axis
                if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1) >= 0){
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1))/
                            (MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i));
                }
                //downwards on x axis
                else{
                    slope = (MainGame.dataGivenY.get(i-1) - MainGame.dataGivenY.get(i
                    )) / (MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i));
                }
                if (slope <= 1.0)
                    continue;
            }

            //phase four 4
            //-ve y axis and alter x axis
            else if(direction == 4){
                //right side on x axis
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1) >= 0){
                    slope = (MainGame.dataGivenY.get(i-1) - MainGame.dataGivenY.get(i))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1));
                }
                //left side on x axis
                else{
                    slope = (MainGame.dataGivenY.get(i-1) - MainGame.dataGivenY.get(i
                    )) / (MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i));
                }
                if (slope > 1.0)
                    continue;
            }


            System.out.println(i);

            //when the condition turns to be wrong
            //or in other words the direction changes
            DataToFile+=Integer.toString(MainGame.dataGivenX.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(direction);
            DataToFile+="\n";

            //incrementing by 1
            i++;

        //assigning the new direction
        //positive x axis
            if((MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-2)) >=0){
                //positive y axis
                if((MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2)) >=0)
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-2));
                //negative y axis
                else
                    slope = (MainGame.dataGivenY.get(i-2) - MainGame.dataGivenY.get(i))/
                            (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-2));
                if(slope <= 1.0)
                    direction = 1;
                else
                    if((MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2)) >= 0)
                        direction = 2;
                    else
                        direction = 4;
            }
            //negative x axis
            else{
                //positive y axis
                if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2) >= 0)
                    slope = (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2))/
                            (MainGame.dataGivenX.get(i-2) - MainGame.dataGivenX.get(i));
                //negative y axis
                else
                    slope = (MainGame.dataGivenY.get(i-2) - MainGame.dataGivenY.get(i))/
                            (MainGame.dataGivenX.get(i-2) - MainGame.dataGivenX.get(i));

                if(slope <= 1.0)
                    direction = 3;
                else
                if(MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-2) >= 0)
                    direction = 2;
                else
                    direction = 4;
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