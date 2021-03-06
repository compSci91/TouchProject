package com.company;
import javax.naming.InterruptedNamingException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
    //    printNumberOfAgreementsAndDisagreements(6, "Discussion 7");
//    printCoupleIntentions(6, "Discussion 7",IntentionSubcategory.AGREEMENT );
//        System.out.println();
//        printCoupleIntentions(6, "Discussion 7",IntentionSubcategory.DISAGREEMENT );

//      printNumberOfIntentions("A6", "Discussion 5", IntentionSubcategory.DISAGREEMENT);
//        printNumberOfReferenceTypes("A6", "Discussion 5", IntentionSubcategory.DISAGREEMENT);

       printTotalIntentions("A1");

    }

    public static void printTotalIntentions(String participant) throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/" + participant + "/Data/Consensus.txt");
        Scanner sc = new Scanner(file);

        List<Touch> touches = new ArrayList<>();

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
        System.out.println(conversation.getIntentionCounts());
    }

    private static void printCoupleIntentions(int coupleNumber, String topic, IntentionSubcategory intentionSubcategory) throws FileNotFoundException {
        printNumberOfIntentions("A"+coupleNumber,  topic, intentionSubcategory);
        printNumberOfIntentions("B"+coupleNumber, topic, intentionSubcategory);

        System.out.println();


    }

    private static void printNumberOfReferenceTypes(String participant, String topic, IntentionSubcategory intentionSubcategory) throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/" + participant + "/Data/Consensus.txt");
        Scanner sc = new Scanner(file);

        List<Touch> touches = new ArrayList<>();

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
        int[] referenceTypeTouches = conversation.calculateNumberOfReferenceTypes(topic, intentionSubcategory);

        System.out.println("For intention: " + intentionSubcategory);
        System.out.println("Number of metas sent by " + participant + " : "  + referenceTypeTouches[0]);
        System.out.println("\tSpeaking: " + referenceTypeTouches[1]);
        System.out.println("\tListening: " + referenceTypeTouches[2]);

        System.out.println("Number of paras sent by " + participant + " : "  + referenceTypeTouches[3]);
        System.out.println("\tSpeaking: " + referenceTypeTouches[4]);
        System.out.println("\tListening: " + referenceTypeTouches[5]);

        System.out.println("Number of objects sent by " + participant + " : "  + referenceTypeTouches[6]);
        System.out.println("\tSpeaking: " + referenceTypeTouches[7]);
        System.out.println("\tListening: " + referenceTypeTouches[8]);

    }

    /*

        1. For each person, be able to pass in a topic and a subcategory of intention. —> # of touches with that intention subcategory and #of those intentions that are speaking and listening,
        topic, intention subCategory --> (# of touches with that intention, # speaking, # listening)
     */

    public static void printNumberOfIntentions(String participant,  String topic, IntentionSubcategory intentionSubcategory) throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/" + participant + "/Data/Consensus.txt");
        Scanner sc = new Scanner(file);

        List<Touch> touches = new ArrayList<>();

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
        int[] intention_touches = conversation.printNumberOfIntentions(topic, intentionSubcategory);


        System.out.println("Number of " + intentionSubcategory + " intentions sent by " + participant + " : "  + intention_touches[0]);
        System.out.println("\tSpeaking: " + intention_touches[1]);
        System.out.println("\tListening: " + intention_touches[2]);

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
