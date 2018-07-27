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
        compareVal = 20;
        direction = 0;
        //now the sorted data is in downloading process
        DataToFile = "";
        float slope =0;

        direction =1;
        for (i = 1; i < MainGame.dataGivenX.size(); i++) {
            if(direction == 1 ){
                if (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1) >= 0){
                    if (MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1) >= 0){
                        slope = (float) ((MainGame.dataGivenY.get(i) - MainGame.dataGivenY.get(i-1))/
                                (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1)));
                    }else{
                        slope = (float) ((MainGame.dataGivenY.get(i-1) - MainGame.dataGivenY.get(i))/
                                (MainGame.dataGivenX.get(i) - MainGame.dataGivenX.get(i-1)));
                    }
                    if(slope <= 0) {
                        continue;
                    }
                }
            }else if(direction == 2){

            }else if(direction == 3){

            }else if(direction == 4){

            }



            direction = 2;


            DataToFile+=Integer.toString(MainGame.dataGivenX.get(i));
            DataToFile+="\t";
            DataToFile+=Integer.toString(MainGame.HEIGHT - MainGame.dataGivenY.get(i));
            DataToFile+="\t";
            DataToFile+=Integer.toString(direction);
            DataToFile+="\n";


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