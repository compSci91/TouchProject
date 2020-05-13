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


//
//        Intention first_intention = new Intention(new HashSet<>(Arrays.asList("agreement", "assurance")));
//
//
//        Intention second_intention =  new Intention(new HashSet<>(Arrays.asList("assurance", "agreement")));
//
//
//
//        System.out.println(first_intention.hashCode() == second_intention.hashCode());
//
//
//
//
//            File file =  new File("/Volumes/GoogleDrive/My Drive/study/A3/Data/Consensus.txt");
//            Scanner sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                String rawTouchString = sc.nextLine();
//
//                if(rawTouchString.contains("End")) {
//                    // Do nothing
//                } else {
//                    String[] touchArray = rawTouchString.split(",");
//
//                    Touch touch = new Touch(touchArray, file);
//                 //   System.out.println(touch);
//                    touches.add(touch);
//                }
//
//            }
//
//
//
//        Conversation conversation = new Conversation(touches);
//            conversation.findNumberOfDisagreements("Discussion 7");
//            conversation.findNumberofAgreements("Discussion 2");
//            conversation.printReferenceTypeList("Discussion 7");
//
//        conversation.calculateReferenceTypeProportionsWithIntentions("anger");
       // conversation.calculateIntentionProportions("Discussion 1");
        //conversation.calculateReferenceTypeProportions("Discussion 3");

        printNumberOfAgreementsAndDisagreements(6, "Discussion 7");
    }

    public static void printNumberOfAgreementsAndDisagreements(int coupleNumber, String topic) throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/A" + coupleNumber + "/Data/Consensus.txt");
        Scanner sc = new Scanner(file);

        List<Touch> aTouches = new ArrayList<>();

        while (sc.hasNextLine()) {
            String rawTouchString = sc.nextLine();

            if(rawTouchString.contains("End")) {
                // Do nothing
            } else {
                String[] touchArray = rawTouchString.split(",");

                Touch touch = new Touch(touchArray, file);
                //   System.out.println(touch);
                aTouches.add(touch);
            }

        }

        Conversation aConversation = new Conversation(aTouches);

        file =  new File("/Volumes/GoogleDrive/My Drive/study/B" + coupleNumber + "/Data/Consensus.txt");
        sc = new Scanner(file);

        List<Touch> bTouches = new ArrayList<>();

        while (sc.hasNextLine()) {
            String rawTouchString = sc.nextLine();

            if(rawTouchString.contains("End")) {
                // Do nothing
            } else {
                String[] touchArray = rawTouchString.split(",");

                Touch touch = new Touch(touchArray, file);
                //   System.out.println(touch);
                bTouches.add(touch);
            }

        }

        Conversation bConversation = new Conversation(bTouches);

        int[] a_agreements = aConversation.findNumberofAgreements(topic);
        int[] b_agreements = bConversation.findNumberofAgreements(topic);


        System.out.println("Number of Agreements sent by A: " + a_agreements[0]);
        System.out.println("\tSpeaking: " + a_agreements[1]);
        System.out.println("\tListening: " + a_agreements[2]);
        System.out.println("Number of Agreements sent by B: " + b_agreements[0]);
        System.out.println("\tSpeaking: " + b_agreements[1]);
        System.out.println("\tListening: " + b_agreements[2]);

        System.out.println();
        System.out.println();

        int[] a_disagreements = aConversation.findNumberOfDisagreements(topic);
        int[] b_disagreements = bConversation.findNumberOfDisagreements(topic);

        System.out.println("Number of disagreements sent by A: " + a_disagreements[0]);
        System.out.println("\tSpeaking: " + a_disagreements[1]);
        System.out.println("\tListening: " + a_disagreements[2]);
        System.out.println("Number of disagreements sent by B: " + b_disagreements[0]);
        System.out.println("\tSpeaking: " + b_disagreements[1]);
        System.out.println("\tListening: " + b_disagreements[2]);

    }
}
