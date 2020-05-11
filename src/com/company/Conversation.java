package com.company;

import java.util.*;

public class Conversation {
    public Collection<Touch> touches;

    public Conversation(Collection<Touch> touches){
        this.touches = touches;
    }

    public void calculateIntentionProportions(String dicussion){
        List<String> discussionSixIntentions = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(dicussion)){
                discussionSixIntentions.addAll(touch.intentions);
            }
        }

        calculatePercentages(discussionSixIntentions);

    }

    public void calculateReferenceTypeProportions(String dicussion){
        List<String> discussionSixIntentions = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(dicussion)){
                discussionSixIntentions.add(touch.referenceType);
            }
        }

        calculatePercentages(discussionSixIntentions);

    }

    public void calculatePercentages(List<String> intentions){
        Map<String, Integer> intentionMap = new HashMap<String, Integer>();

        for(String intention : intentions){
            if(intentionMap.containsKey(intention)){
                Integer number = intentionMap.get(intention);
                intentionMap.put(intention, number + 1);
            } else {
                intentionMap.put(intention, 1);
            }

        } //end for loop


        System.out.println(intentionMap);

        for(String intention : intentionMap.keySet()){


            double percentage = intentionMap.get(intention) / (double)intentions.size() * 100;
            System.out.println("Intention: " + intention + ": " + percentage + "%");
        }
    }
}
