package com.company;

import java.util.ArrayList;
import java.util.List;

public class Touch {
    public String timestamp, touchStrength, duration, discussion, referenceType, speakingOrListening;
    public List<String> intentions;

    public Touch(String[] touchArray){

        if(touchArray.length > 4 && touchArray[4].contains("End")){
            return;
        }

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
