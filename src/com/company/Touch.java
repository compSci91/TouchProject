package com.company;

import java.util.List;

public class Touch {
    private String timestamp, touchStrength, discussion, referenceType, speakingOrListening;
    private List<String> intentions;

    public Touch(String timestamp, String touchStrength, List<String> intentions, String discussion, String referenceType, String speakingOrListening){
        this.timestamp = timestamp;
        this.touchStrength = touchStrength;
        this.intentions = intentions;
        this.discussion = discussion;
        this.referenceType = referenceType;
        this.speakingOrListening = speakingOrListening;
    }
}
