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
        int i=0;
        compareVal =0;
        direction = 0;
        //now the sorted data is in downloading process
        DataToFile = "";

        int temp1 =0, temp2=0;


        for (i = 1; i < MainGame.dataGivenX.size(); i++) {

            //checking for the regular movement of a line
            if(direction == 1){//+ve x axis
                temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                if(temp2 == 0){
                    continue;
                }else if(temp2 < 0){
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i));
                }

                slope = (float)temp2 / (float)temp1;
                if(slope >= 0 && slope < 0.1428571)
                    continue;

            }

            else if ( direction ==5){ // +ve yaxis
                temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                if(temp1 == 0) {
                    continue;
                }else if (temp1 < 0){
                    temp1 = MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i);
                }

                slope = (float)temp2 / (float)temp1;

                if(slope >= 7.0)
                    continue;

            }

            else if ( direction ==9){ // -ve x axis
                temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                if(temp2 == 0) {
                    continue;
                }else if (temp1 < 0){
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i));
                }

                slope = (float)temp2 / (float)temp1;

                if(slope >= 0 && slope < 0.1428571)
                    continue;

            }

            else if ( direction ==13){ // -ve y axis
                temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                if(temp1 == 0) {
                    continue;
                }else if (temp1 < 0){
                    temp1 = MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i);
                }

                slope = (float)temp2 / (float)temp1;

                if(slope >= 7.0)
                    continue;

            }

            else if( direction >=2 && direction <=4){ // 1st quadrant

                temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                slope = (float)temp2 / (float)temp1;

                if(direction == 2){
                    if(slope >= 0.1428571 && slope < 0.7142857)
                        continue;
                }else if (direction == 3){
                    if(slope >= 0.7142857 && slope < 1.4)
                        continue;
                }else if (direction == 4){
                    if(slope >= 1.4 && slope < 7.0)
                        continue;
                }
            }

            else if( direction >=6 && direction <=8){ // 2nd quadrant

                temp1 = MainGame.dataGivenX.get(0) - MainGame.dataGivenX.get(2);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(2)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(0));

                slope = (float)temp2 / (float)temp1;


                if(direction == 6)
                    if(slope >= 1.4 && slope < 7.0)
                        continue;
                else if(direction == 7)
                    if(slope >= 0.7142857 && slope < 1.4)
                        continue;
                else if(direction == 8)
                    if(slope >= 0.1428571 && slope < 0.7142857)
                        continue;
            }

            else if( direction >=10 && direction <=12){ // 3rd quadrant
                temp1 = MainGame.dataGivenX.get(0) - MainGame.dataGivenX.get(2);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(0)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(2));

                slope = (float)temp2 / (float)temp1;

                if(direction == 9)
                    if(slope >= 0 && slope < 0.1428571)
                        continue;
                else if(direction == 10)
                    if(slope >= 0.1428571 && slope < 0.7142857)
                        continue;
                else if (direction == 11)
                    if(slope >= 0.7142857 && slope < 1.4)
                        continue;
                else if(direction == 12)
                    if(slope >= 1.4 && slope < 7.0)
                        continue;

            }

            else if( direction >=14 && direction <=16){ // 4th quadrant
                temp1 = MainGame.dataGivenX.get(2) - MainGame.dataGivenX.get(0);
                temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(0)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(2));

                slope = (float)temp2 / (float)temp1;

                if(direction == 16)
                    if(slope >= 0.1428571 && slope < 0.7142857)
                        continue;

                if(direction == 15)
                    if(slope >= 0.7142857 && slope < 1.4)
                        continue;

                if(direction == 14)
                    if(slope >= 1.4 && slope < 7.0)
                        continue;
            }

            /*if(compareVal ==0){
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1) < 5 ||
                        MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i) < 5 &&
                                (MainGame.HEIGHT - MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT - MainGame.dataGivenY.get(i-1)) < 5 ||
                        (MainGame.HEIGHT - MainGame.dataGivenY.get(i-1)) - (MainGame.HEIGHT - MainGame.dataGivenY.get(i)) < 5 ){
                    compareVal = i-1;
                }
            }else{
                if(MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(compareVal) < 5 ||
                        MainGame.dataGivenX.get(compareVal) - MainGame.dataGivenX.get(i) < 5 &&
                                (MainGame.HEIGHT - MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT - MainGame.dataGivenY.get(compareVal)) < 5 ||
                        (MainGame.HEIGHT - MainGame.dataGivenY.get(compareVal)) - (MainGame.HEIGHT - MainGame.dataGivenY.get(i)) < 5 ){
                    continue;
                }
                compareVal = 0;
            }
*/

            //when the condition turns to be wrong
            //or in other words the direction changes
            DataToFile+=Integer.toString(MainGame.dataGivenX.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(compareVal));
            DataToFile+="\t";
            DataToFile+=Integer.toString(direction);
            DataToFile+="\n";

            temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
            temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));


            //positive side of y axis
            if (temp2 > 0) {
                //positive side of x axis // 1st quadrant //
                if (temp1 > 0) {
                    temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                    slope = (float)temp2 / (float)temp1;

                    // for Staight line .....in x positive direction......10 degrees wrt x axis
                    if(slope >= 0 && slope < 0.1428571){
                        direction = 1;
                    }

                    // for slanted line .... greater than 10 degrees and smaller than 40 wrt x axis
                    else if(slope >= 0.1428571 && slope < 0.7142857){
                        direction = 2;
                    }

                    // for slanted line .... greater than 40 degrees and smaller than 50 wrt x axis
                    else if(slope >= 0.7142857 && slope < 1.4){
                        direction = 3;
                    }

                    // for slanted line .... greater than 50 degrees and smaller than 80 wrt x axis
                    else if(slope >= 1.4 && slope < 7.0){
                        direction = 4;
                    }

                    // for slanted line .... greater than 80 degrees and smaller than 90 wrt x axis
                    else if(slope >= 7.0){
                        direction = 5;
                    }

                }
                //negative side of x axis // 2nd quadrant //
                else {
                    temp1 = MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i);
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1));

                    slope = (float)temp2 / (float)temp1;

                    // for Staight line .....in x negative direction......greater than 170 degrees wrt x axis
                    if(slope >= 0 && slope < 0.1428571){
                        direction = 9;
                    }

                    // for slanted line .... greater than 140 degrees and smaller than 170 wrt -ve x axis
                    else if(slope >= 0.1428571 && slope < 0.7142857){
                        direction = 8;
                    }

                    // for slanted line .... greater than 130 degrees and smaller than 140 wrt x axis
                    else if(slope >= 0.7142857 && slope < 1.4){
                        direction = 7;
                    }

                    // for slanted line .... greater than 100 degrees and smaller than 130 wrt x axis
                    else if(slope >= 1.4 && slope < 7.0){
                        direction = 6;
                    }

                    // for slanted line .... greater than 90 degrees and smaller than 100 wrt x axis
                    else if(slope >= 7.0){
                        direction = 5;
                    }
                }
            }
            //negative side of y axis
            else {
                //positive side of x axis // 4th quadrant //
                if (temp1 > 0) {
                    temp1 = MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1);
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i));

                    slope = (float)temp2 / (float)temp1;

                    // for Staight line .....in x positive direction......10 degrees wrt x axis
                    if(slope >= 0 && slope < 0.1428571){
                        direction = 1;
                    }

                    // for slanted line .... greater than -10 degrees and smaller than -40 wrt x axis
                    else if(slope >= 0.1428571 && slope < 0.7142857){
                        direction = 16;
                    }

                    // for slanted line .... greater than -40 degrees and smaller than -50 wrt x axis
                    else if(slope >= 0.7142857 && slope < 1.4){
                        direction = 15;
                    }

                    // for slanted line .... greater than -50 degrees and smaller than -80 wrt x axis
                    else if(slope >= 1.4 && slope < 7.0){
                        direction = 14;
                    }

                    // for slanted line .... greater than 80 degrees and smaller than -90 wrt x axis
                    else if(slope >= 7.0){
                        direction = 13;
                    }

                }
                //negative side of x axis // 3rd quadrant //
                else {
                    temp1 = MainGame.dataGivenX.get(i-1) - MainGame.dataGivenX.get(i);
                    temp2 = (MainGame.HEIGHT -MainGame.dataGivenY.get(i-1)) - (MainGame.HEIGHT -MainGame.dataGivenY.get(i));

                    slope = (float)temp2 / (float)temp1;

                    // for Staight line .....in x negative direction......greater than -170 degrees wrt x axis
                    if(slope >= 0 && slope < 0.1428571){
                        direction = 9;
                    }

                    // for slanted line .... greater than -140 degrees and smaller than -170 wrt -ve x axis
                    else if(slope >= 0.1428571 && slope < 0.7142857){
                        direction = 10;
                    }

                    // for slanted line .... greater than -130 degrees and smaller than -140 wrt x axis
                    else if(slope >= 0.7142857 && slope < 1.4){
                        direction = 11;
                    }

                    // for slanted line .... greater than -100 degrees and smaller than -130 wrt x axis
                    else if(slope >= 1.4 && slope < 7.0){
                        direction = 12;
                    }

                    // .... greater than -90 degrees and smaller than -100 wrt x axis
                    else if(slope >= 7.0){
                        direction = 13;
                    }
                }

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
