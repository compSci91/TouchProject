package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        List<Touch> touches = new ArrayList<Touch>();
        File file =
                new File("/Volumes/GoogleDrive/My Drive/study/A1/Data/aConsensus.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String rawTouchString = sc.nextLine();
            String[] touchArray = rawTouchString.split(",");

            Touch touch = new Touch(touchArray);
            //System.out.println(touch);
            touches.add(touch);




//            System.out.print("[");
//
//            for(String touchData : touchArray){
//                System.out.print(touchData + ",");
//            }
//            System.out.print("]");
//
//            System.out.println();
        }

        Conversation conversation = new Conversation(touches);

//        conversation.calculateIntentionProportions("Discussion 3");
        conversation.calculateReferenceTypeProportions("Discussion 3");



    }
}
