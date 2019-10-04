package org.ergemp.mlt.similarity.examples;

import org.ergemp.mlt.similarity.model.EditBasedSimilarity;
import org.ergemp.mlt.similarity.model.TokenBasedSimilarity;

public class CommonExample {
    public static void main(String[] args) {
        TokenBasedSimilarity tSim = new TokenBasedSimilarity(" ");
        Double tt = tSim.diceCoefficient("hellori", "ergem hellori");
        System.out.println("Dice Coeff: " + tt.toString());

        EditBasedSimilarity eSim = new EditBasedSimilarity();
        Double tt2 = eSim.levenstheinSimilarity("hellori", "ergem hellori");
        System.out.println("Levensthein Coeff: " + tt2.toString());

        /*
        0.7272727272727273
        0.5384615384615384
        */
    }
}
