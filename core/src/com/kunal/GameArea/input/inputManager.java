package com.kunal.GameArea.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.kunal.MainGame;


public class inputManager {

    FileHandle file;

    //String to carry the data
    String DataToFile = "";

    //the number of box it is presently in
    int BoxNumber =0;


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

        DataToFile = "";
        BoxNumber =0;

        //Each box sixe is W:340 H:170
        //Boxes are named as
        /*
        1   2   3
        4   5   6
        7   8   9
        ----------------------------------------------------------------------------
        box 1:
                        x       y
            starting :  0       0
            ending   :  340     170

        box 2:
                        x       y
            starting :  426     0
            ending   :  766     170

        box 3:
                        x       y
            starting :  852     0
            ending   :  1192    170
        ----------------------------------------------------------------------------
        box 4:
                        x       y
            starting :  0       240
            ending   :  340     410

        box 5:
                        x       y
            starting :  426     240
            ending   :  766     410

        box 6:
                        x       y
            starting :  852     240
            ending   :  1192    410
        ----------------------------------------------------------------------------
        box 7:
                        x       y
            starting :  0       480
            ending   :  340     650

        box 8:
                        x       y
            starting :  426     480
            ending   :  766     650

        box 9:
                        x       y
            starting :  852     480
            ending   :  1192    650
         */

        for (int i=0; i<MainGame.dataGivenX.size(); i++){

            //for box 1
            if(MainGame.dataGivenX.get(i) > 0 && MainGame.dataGivenX.get(i) <=340 &&
                    MainGame.dataGivenY.get(i) > 0 && MainGame.dataGivenY.get(i) <170 && BoxNumber !=1){
                DataToFile+=Integer.toString(1);
                DataToFile+="\n";

                BoxNumber =1;
                System.out.println("1");
            }
            //for box 2
            else if(MainGame.dataGivenX.get(i) > 426 && MainGame.dataGivenX.get(i) <=766 &&
                    MainGame.dataGivenY.get(i) > 0 && MainGame.dataGivenY.get(i) <170 && BoxNumber !=2){
                DataToFile+=Integer.toString(2);
                DataToFile+="\n";

                BoxNumber =2;
                System.out.println("2");
            }
            //for box 3
            else if(MainGame.dataGivenX.get(i) > 852 && MainGame.dataGivenX.get(i) <=1192 &&
                    MainGame.dataGivenY.get(i) > 0 && MainGame.dataGivenY.get(i) <170 && BoxNumber !=3){
                DataToFile+=Integer.toString(3);
                DataToFile+="\n";

                BoxNumber =3;
                System.out.println("3");
            }

            //--------------------------------------------------------
            //for box 4
            if(MainGame.dataGivenX.get(i) > 0 && MainGame.dataGivenX.get(i) <=340 &&
                    MainGame.dataGivenY.get(i) > 240 && MainGame.dataGivenY.get(i) <410 && BoxNumber !=4){
                DataToFile+=Integer.toString(4);
                DataToFile+="\n";

                BoxNumber =4;
                System.out.println("4");
            }
            //for box 5
            else if(MainGame.dataGivenX.get(i) > 426 && MainGame.dataGivenX.get(i) <=766 &&
                    MainGame.dataGivenY.get(i) > 240 && MainGame.dataGivenY.get(i) <410 && BoxNumber !=5){
                DataToFile+=Integer.toString(5);
                DataToFile+="\n";

                BoxNumber =5;
                System.out.println("5");
            }
            //for box 6
            else if(MainGame.dataGivenX.get(i) > 852 && MainGame.dataGivenX.get(i) <=1192 &&
                    MainGame.dataGivenY.get(i) > 240 && MainGame.dataGivenY.get(i) <410 && BoxNumber !=6){
                DataToFile+=Integer.toString(6);
                DataToFile+="\n";

                BoxNumber =6;
                System.out.println("6");
            }

            //--------------------------------------------------------
            //for box 7
            if(MainGame.dataGivenX.get(i) > 0 && MainGame.dataGivenX.get(i) <=340 &&
                    MainGame.dataGivenY.get(i) > 480 && MainGame.dataGivenY.get(i) <650 && BoxNumber !=7){
                DataToFile+=Integer.toString(7);
                DataToFile+="\n";

                BoxNumber =7;
                System.out.println("7");
            }
            //for box 8
            else if(MainGame.dataGivenX.get(i) > 426 && MainGame.dataGivenX.get(i) <=766 &&
                    MainGame.dataGivenY.get(i) > 480 && MainGame.dataGivenY.get(i) <650 && BoxNumber !=8){
                DataToFile+=Integer.toString(8);
                DataToFile+="\n";

                BoxNumber =8;
                System.out.println("8");
            }
            //for box 9
            else if(MainGame.dataGivenX.get(i) > 852 && MainGame.dataGivenX.get(i) <=1192 &&
                    MainGame.dataGivenY.get(i) > 480 && MainGame.dataGivenY.get(i) <650 && BoxNumber !=9){
                DataToFile+=Integer.toString(9);
                DataToFile+="\n";

                BoxNumber =9;
                System.out.println("9");
            }





        }

        filewriting("testing/sorted",false);


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