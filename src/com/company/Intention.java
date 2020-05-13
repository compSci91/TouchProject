package com.company;

import java.util.*;

public class Intention {
    private Set<String> intentions;

    public Intention(Set<String> intentions){
        this.intentions = intentions;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Intention otherIntention = (Intention) o;

        if(intentions.size() != otherIntention.intentions.size()){ // if the set is not the same size they are not equal
             return false;
        } else {
            for(String intention : intentions){ //every intention in our intentions set must be in the other intention set. The order doesn't matter
                if(!otherIntention.intentions.contains(intention)){
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public int hashCode() {
        int hashCode = 0;

        for(String intention : intentions){
            hashCode += intention.hashCode();
        }

        return hashCode;
    }
}
