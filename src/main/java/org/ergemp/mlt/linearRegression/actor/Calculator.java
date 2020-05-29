package org.ergemp.mlt.linearRegression.actor;

import java.util.List;

public class Calculator {
    public static void calculate(List<Double> gArr1, List<Double> gArr2, Boolean debug){

        Double meanArr1 = org.ergemp.mlt.pearsonsCorrelation.actor.getMean.get(gArr1, false);
        Double meanArr2 = org.ergemp.mlt.pearsonsCorrelation.actor.getMean.get(gArr2, false);

        Double S1 = 0.0;
        Double S2 = 0.0;

        Double pearsonsCoeff =  org.ergemp.mlt.pearsonsCorrelation.actor.Calculator.calculate(gArr1, gArr2, false);

        for (Double l1 : gArr1) {
            S1 += Math.pow(l1-meanArr1,2) ;
        }

        if (debug){
            System.out.println("S1: " + S1);
        }

        S1 = Math.sqrt(S1/(gArr1.size()-1));

        if (debug){
            System.out.println("S1: " + S1);
        }

        for (Double l2 : gArr2) {
            S2 += Math.pow(l2-meanArr2,2) ;
        }

        if (debug){
            System.out.println("S2: " + S2);
        }

        S2 = Math.sqrt(S2/(gArr2.size()-1));

        if (debug){
            System.out.println("S2: " + S2);
        }



    }
}
