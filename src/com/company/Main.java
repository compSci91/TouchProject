package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Touch> touches = new ArrayList<Touch>();


//        for (int i = 1; i <= 22; i++){
//            if(i == 2 || i == 11){
//                continue;
//            }
//
//            File file =
//                    new File("/Volumes/GoogleDrive/My Drive/study/A" + i + "/Data/Consensus.txt");
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                String rawTouchString = sc.nextLine();
//
//                if(rawTouchString.contains("End")) {
//
//                } else {
//                    String[] touchArray = rawTouchString.split(",");
//
//                    Touch touch = new Touch(touchArray, file);
//                    //System.out.println(touch);
//                    touches.add(touch);
//                }
//
//            }
//        }

//        for(int i = 1; i <= 22; i++) {
//            if(i == 2 || i == 11){
//                continue;
//            }
//
//            File file = new File("/Volumes/GoogleDrive/My Drive/study/B" + i + "/Data/Consensus.txt");
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                String rawTouchString = sc.nextLine();
//
//                if(rawTouchString.contains("End")){
//
//                } else {
//                    String[] touchArray = rawTouchString.split(",");
//
//                    Touch touch = new Touch(touchArray, file);
//                    //System.out.println(touch);
//                    touches.add(touch);
//                }
//
//            }
//        }





            File file =  new File("/Volumes/GoogleDrive/My Drive/study/A8/Data/Consensus.txt");
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String rawTouchString = sc.nextLine();

                if(rawTouchString.contains("End")) {
                    // Do nothing
                } else {
                    String[] touchArray = rawTouchString.split(",");

                    Touch touch = new Touch(touchArray, file);
                 //   System.out.println(touch);
                    touches.add(touch);
                }

            }



        Conversation conversation = new Conversation(touches);
            conversation.printReferenceTypeList("Discussion 1");
//
//        conversation.calculateReferenceTypeProportionsWithIntentions("anger");
       // conversation.calculateIntentionProportions("Discussion 1");
        //conversation.calculateReferenceTypeProportions("Discussion 3");



    }
}
