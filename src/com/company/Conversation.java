package com.company;

import java.util.*;

public class Conversation {
    public Collection<Touch> touches;
    private Collection<Intention> agreementCategory;
    private Collection<Intention> disagreementCategory;
    private Collection<Intention> emphasisSubcategory;
    private Collection<Intention> discernmentSubcategory;
    private Collection<Intention> attentionSeekingSubcategory;
    private Collection<Intention> reciprocationSubcategory;
    private Collection<Intention> assuranceSubcategory;
    private Collection<Intention> affectionSubcategory;

    private Map<IntentionSubcategory, Collection<Intention>> intentionsubcatgories;




    public Conversation(Collection<Touch> touches){
        this.touches = touches;

        Intention[] agreementIntentions = {new Intention("agreement"), new Intention("agreement", "assurance"), new Intention("agreement", "attentive"),
                new Intention("agreement", "understanding"), new Intention("emphasis", "agreement"), new Intention("loving", "agreement"),
                new Intention("playful", "agreement"), new Intention("reciprocation", "agreement")};


        Intention[] disagreementIntentions = {new Intention("anger"), new Intention("annoyance"), new Intention("disagreement"),
                new Intention("disagreement, understanding"), new Intention("frustration", "disagreement"), new Intention("playful", "prove a point"),
                new Intention("prove a point")};


        Intention[] emphasisIntentions = {new Intention("emphasis"), new Intention("emphasis", "agreement"), new Intention("excitement")};

        Intention[] discernmentIntentions = {new Intention("confusion"), new Intention("contemplation"), new Intention("inquiry"),
                new Intention("interest")};

        Intention[] attentionSeekingIntentions = {new Intention("attention seeking"), new Intention("attention seeking", "nudge"),
                new Intention("attention seeking", "playful"),  new Intention("attention seeking", "be serious"),  new Intention("attention seeking", "clarification"),
                new Intention("distraction"), new Intention("nudge"), new Intention("nudge", "assurance"), new Intention("transitioning"),
                new Intention("tug")};

        Intention[] reciprocationIntentions = {new Intention("acknowledgement"), new Intention("affection", "reciprocation"),  new Intention("playful", "reciprocation"),
                new Intention( "reciprocation"),  new Intention("listening")};

        Intention[] assuranceIntentions = {new Intention("affection", "assurance"),new Intention("appreciation"),
                new Intention("assurance"), new Intention("attentive", "assurance"), new Intention("affection", "comfort"), new Intention("comforting"),
                new Intention("comforting", "assurance"), new Intention("comforting", "beaten down"), new Intention("contemplation", "assurance"),
                new Intention("playful", "agreement", "assurance")};

        Intention[] affectionIntentions = {new Intention("affection"), new Intention("attentive"), new Intention("attentive","loving"),
                new Intention("comfort", "affection"), new Intention("distraction"), new Intention("flirting"),  new Intention("flirting", "loving"),
                new Intention("goodbye", "affection"),  new Intention("loving"),  new Intention("playful"),  new Intention("playful", "affection"),
               new Intention("playful", "anger"),
                new Intention("playful", "flirty"),new Intention("playful", "inquiry"),  new Intention("playful", "threatening"),
                new Intention("understanding")};

        this.agreementCategory = new HashSet<Intention>(Arrays.asList(agreementIntentions));
        this.disagreementCategory = new HashSet<Intention>(Arrays.asList(disagreementIntentions));
        this.emphasisSubcategory = new HashSet<>(Arrays.asList(emphasisIntentions));
        this.discernmentSubcategory = new HashSet<>(Arrays.asList(discernmentIntentions));
        this.attentionSeekingSubcategory = new HashSet<>(Arrays.asList(attentionSeekingIntentions));
        this.reciprocationSubcategory = new HashSet<>(Arrays.asList(reciprocationIntentions));
        this.assuranceSubcategory = new HashSet<>(Arrays.asList(assuranceIntentions));
        this.affectionSubcategory = new HashSet<>(Arrays.asList(affectionIntentions));

        this.intentionsubcatgories = new HashMap<>() {
            {
                put(IntentionSubcategory.AGREEMENT, agreementCategory);
                put(IntentionSubcategory.DISAGREEMENT, disagreementCategory);
                put(IntentionSubcategory.EMPHASIS, emphasisSubcategory);
                put(IntentionSubcategory.DISCERNMENT, discernmentSubcategory);
                put(IntentionSubcategory.ATTENTION_SEEKING, attentionSeekingSubcategory);
                put(IntentionSubcategory.RECIPROCATION, reciprocationSubcategory);
                put(IntentionSubcategory.ASSURANCE, assuranceSubcategory);
                put(IntentionSubcategory.AFFECTION, affectionSubcategory);

            }
        };



    }

    public int[] printNumberOfIntentions(String topic, IntentionSubcategory intentionSubcategory) {
        int number_of_intentions = 0;
        int number_speaking = 0;
        int number_listening = 0;

        Collection<Intention> subcategory = intentionsubcatgories.get(intentionSubcategory);

        for(Touch touch : touches){
            if(touch.topic != null && touch.topic.equals(topic)){
                if(subcategory.contains(touch.intention)){
                    number_of_intentions++;
                    if(touch.speakingOrListening.equals("speaking")){
                        number_speaking++;
                    } else {
                        number_listening++;
                    }
                }
            }
        }

        return new int[]{number_of_intentions, number_speaking, number_listening};
    }

    public int[] calculateNumberOfReferenceTypes(String topic, IntentionSubcategory intentionSubcategory) {
        int number_of_metas = 0;
        int number_of_speaking_meta = 0;
        int number_of_listening_meta = 0;
        int number_of_paras = 0;
        int number_of_speaking_paras = 0;
        int number_of_listening_paras = 0;
        int number_of_objects = 0;
        int number_of_speaking_objects = 0;
        int number_of_listening_objects = 0;

        for(Touch touch : touches) {
            if (touch.topic != null && touch.topic.equals(topic)) {
                Collection<Intention> subcategory = intentionsubcatgories.get(intentionSubcategory);

                if (subcategory.contains(touch.intention)) {
                    if (touch.referenceType.equals("meta")) {
                        number_of_metas++;

                        if (touch.speakingOrListening.equals("speaking")) {
                            number_of_speaking_meta++;
                        } else {
                            number_of_listening_meta++;
                        }
                    } else if (touch.referenceType.equals("para")) {
                        number_of_paras++;

                        if (touch.speakingOrListening.equals("speaking")) {
                            number_of_speaking_paras++;
                        } else {
                            number_of_listening_paras++;
                        }
                    } else if (touch.referenceType.equals("object")) {
                        number_of_objects++;

                        if (touch.speakingOrListening.equals("speaking")) {
                            number_of_speaking_objects++;
                        } else {
                            number_of_listening_objects++;
                        }
                    }
                }
            }
        }

        return new int[]{number_of_metas, number_of_speaking_meta, number_of_listening_meta,
                number_of_paras, number_of_speaking_paras, number_of_listening_paras,
                number_of_objects, number_of_speaking_objects, number_of_listening_objects, };
    }

    public int[] findNumberOfDisagreements(String discussion){
        int number_of_disagreements = 0;
        int number_speaking = 0;
        int number_listening = 0;

        for(Touch touch : touches){
            if(touch.topic != null && touch.topic.equals(discussion)){
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
            if(touch.topic != null && touch.topic.equals(discussion)){
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
            if(touch.topic != null && touch.topic.equals(discussion)){
                intentions.addAll(touch.intentions);
            }
        }

        calculatePercentages(intentions);

    }

    public void printReferenceTypeList(String discussion){
        List<String> referenceTypes = new ArrayList<String>();

        for(Touch touch : touches){
            if(touch.topic != null && touch.topic.equals(discussion)){
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
            if(touch.topic != null && touch.topic.equals(dicussion)){
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
