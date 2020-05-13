package com.company;

import java.util.*;

public class Conversation {
    public Collection<Touch> touches;
    private Collection<Intention> agreementCategory;
    private Collection<Intention> disagreementCategory;


    public Conversation(Collection<Touch> touches){
        this.touches = touches;

        Intention[] agreementIntentions = {new Intention("agreement"), new Intention("agreement", "assurance"), new Intention("agreement", "attentive"),
                new Intention("agreement", "understanding"), new Intention("emphasis", "agreement"), new Intention("loving", "agreement"),
                new Intention("playful", "agreement"), new Intention("playful", "agreement", "assurance"),  new Intention("reciprocation", "agreement")};

        this.agreementCategory = new HashSet<Intention>(Arrays.asList(agreementIntentions));

        Intention[] disagreementIntentions = {new Intention("anger"), new Intention("annoyance"), new Intention("disagreement"),
                new Intention("disagreement, understanding"), new Intention("frustration", "disagreement"), new Intention("playful", "prove a point"),
                new Intention("prove a point")};

        this.disagreementCategory = new HashSet<Intention>(Arrays.asList(disagreementIntentions));
    }

    public int[] findNumberOfDisagreements(String discussion){
        int number_of_disagreements = 0;
        int number_speaking = 0;
        int number_listening = 0;

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(discussion)){
                if(disagreementCategory.contains(touch.intention)){
                    number_of_disagreements++;
                        if(touch.speakingOrListening.equals("speaking")){
                            number_speaking++;
                        } else {
                            number_listening++;
                        }
                }
            }
        }

      return new int[]{number_of_disagreements, number_speaking, number_listening};
    }

    public int[] findNumberofAgreements(String discussion){
        int number_of_agreements = 0;
        int number_speaking = 0;
        int number_listening = 0;

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(discussion)){
                if(agreementCategory.contains(touch.intention)){
                    number_of_agreements++;
                    if(touch.speakingOrListening.equals("speaking")){
                        number_speaking++;
                    } else {
                        number_listening++;
                    }
                }
            }
        }

        return new int[]{number_of_agreements, number_speaking, number_listening};    }

    public void calculateIntentionProportions(String discussion){
        List<String> intentions = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.discussion != null && touch.discussion.equals(discussion)){
                intentions.addAll(touch.intentions);
            }
        }

        calculatePercentages(intentions);

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
        List<String> intentions = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.intentions != null && touch.intentions.contains(intention) && touch.speakingOrListening.equals("speaking")){
                intentions.add(touch.referenceType);
            }
        }

        calculatePercentages(intentions);
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
