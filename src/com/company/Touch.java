package com.company;

import java.util.ArrayList;
import java.util.List;

public class Touch {
    private String timestamp, touchStrength, duration, discussion, referenceType, speakingOrListening;
    private List<String> intentions;

    public Touch(String[] touchArray){
        this.timestamp = touchArray[0];
        this.touchStrength = touchArray[1];
        this.duration = touchArray[2];

        this.intentions = new ArrayList<String>();
        intentions.add(touchArray[3]);

        if(!touchArray[3].contains("testing")) {
            int i = 4;

            while (i < touchArray.length) {
                if (!touchArray[i].contains("Discussion")) {
                    intentions.add(touchArray[i]);
                    i++;
                } else {
                    break;
                }

            }

            this.discussion = touchArray[i];
            this.referenceType = touchArray[i + 1];
            this.speakingOrListening = touchArray[i + 2];
        }
    }

    @Override
    public String toString() {
        return "Touch{" +
                "timestamp='" + timestamp + '\'' +
                ", touchStrength='" + touchStrength + '\'' +
                ", duration='" + duration + '\'' +
                ", discussion='" + discussion + '\'' +
                ", referenceType='" + referenceType + '\'' +
                ", speakingOrListening='" + speakingOrListening + '\'' +
                ", intentions=" + intentions +
                '}';
    }
}
