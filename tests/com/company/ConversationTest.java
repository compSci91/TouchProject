package com.company;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ConversationTest {
    @Test
    public void test_printNumberOfIntentions() throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/A6/Data/Consensus.txt");
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
        int[] intention_touches = conversation.printNumberOfIntentions("Discussion 5", IntentionSubcategory.DISAGREEMENT);

        assertTrue(Arrays.equals(new int[]{5, 4, 1}, intention_touches));

    }

    @Test
    public void test_calculateNumberOfReferencetypes() throws FileNotFoundException {
        File file =  new File("/Volumes/GoogleDrive/My Drive/study/A6/Data/Consensus.txt");
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
        int[] referenceTypeTouches = conversation.calculateNumberOfReferenceTypes("Discussion 5", IntentionSubcategory.DISAGREEMENT);

        assertTrue(Arrays.equals(new int[]{0,0,0,5,4,1, 0,0,0}, referenceTypeTouches));


    }
}