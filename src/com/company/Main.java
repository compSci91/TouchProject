package com.company;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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


//        String[] first_intentions = {"agreement", "assurance"};
//
//        Intention first_intention = new Intention(new HashSet<>(Arrays.asList(first_intentions)));
//
//        String[] second_intentions = {"assurance", "agreement"};
//
//        Intention second_intention =  new Intention(new HashSet<>(Arrays.asList(second_intentions)));



        Intention first_intention = new Intention(new HashSet<>(Arrays.asList("agreement", "assurance")));


        Intention second_intention =  new Intention(new HashSet<>(Arrays.asList("assurance", "agreement")));



        System.out.println(first_intention.hashCode() == second_intention.hashCode());




            File file =  new File("/Volumes/GoogleDrive/My Drive/study/A3/Data/Consensus.txt");
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
            conversation.printNumberOfDisagreements("Discussion 7");
            conversation.printNumberOfAgreements("Discussion 2");
//            conversation.printReferenceTypeList("Discussion 7");
//
//        conversation.calculateReferenceTypeProportionsWithIntentions("anger");
       // conversation.calculateIntentionProportions("Discussion 1");
        //conversation.calculateReferenceTypeProportions("Discussion 3");



    }
}
