package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Touch {
    public String timestamp, touchStrength, duration, discussion, referenceType, speakingOrListening;
    public List<String> intentions;
    public Intention intention;

    public Touch(String[] touchArray, File file){

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
                if (!touchArray[i].contains("Discussion") && !touchArray[i].contains("Other")) {
                    intentions.add(touchArray[i]);
                    i++;
                } else {
                    break;
                }

            }

            this.intention = new Intention(this.intentions);

            try {
                this.discussion = touchArray[i];
                this.referenceType = touchArray[i + 1];
                this.speakingOrListening = touchArray[i + 2];
            } catch(ArrayIndexOutOfBoundsException ex){
                System.out.println("Found ArrayIndexOutOfBoundsException with the following string!");
                List brokenTouch = Arrays.asList(touchArray);
                System.out.println(brokenTouch);

                System.out.println("File: " + file.getAbsolutePath());


            }
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
