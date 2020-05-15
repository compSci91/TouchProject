package com.company;

public enum IntentionSubcategory {
    AGREEMENT{ @Override public String toString() { return "Agreement"; } },

    DISAGREEMENT { @Override public String toString() { return "Disagreement"; } },
    EMPHASIS { @Override public String toString() { return "Emphasis"; } },
    DISCERNMENT { @Override public String toString() { return "Discernment"; } },
    ATTENTION_SEEKING { @Override public String toString() { return "Attention Seeking"; } },
    RECIPROCATION{ @Override public String toString() { return "Reciprocation"; } },
    ASSURANCE { @Override public String toString() { return "Assurance"; } },
    AFFECTION { @Override public String toString() { return "Affection"; } }
}
