package org.ergemp.mlt.sentiment.model;

import java.util.Map;

public class FreqMatrix {
    public String word;
    public Map<String, Integer> freq ;

    public FreqMatrix(String gword, Map<String, Integer> gfreq)
    {
        this.word=gword;
        this.freq=gfreq;
    }

    @Override
    public String toString() {
        return "[" + word + "]";
    }
}
