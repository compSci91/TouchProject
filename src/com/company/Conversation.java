package com.company;

import java.util.*;

public class Conversation {
    public Collection<Touch> touches;
    private Set<String> agreementCategory;
    private Set<String> disagreementCategory;


    public Conversation(Collection<Touch> touches){
        this.touches = touches;

//        String[] agreements = ["agreement", "agreement assurance", "agreement attentive", "agreement understanding", "emphasis agreement", "loving agreement, playful agreement", "playful agreement "]
//        agreementCategory = new HashSet<>(Arrays.asList(agreements));
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

    public void printReferenceTypeList(String discussion){
        List<String> referenceTypes = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(discussion)){
                referenceTypes.add(touch.referenceType);
            }
        }

        int i = 0;

        while(i < referenceTypes.size()){
            String referenceType = referenceTypes.get(i);
            int numberOfIntentions = 1;

            i++;

            while(i < referenceTypes.size() && referenceTypes.get(i).equals(referenceType)){
                numberOfIntentions++;
                i++;
            }

            System.out.println(referenceType + ": " + numberOfIntentions);
        }


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

    public void calculateReferenceTypeProportionsWithIntentions(String intention){
        List<String> discussionSixIntentions = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.intentions != null && touch.intentions.contains(intention) && touch.speakingOrListening.equals("speaking")){
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
