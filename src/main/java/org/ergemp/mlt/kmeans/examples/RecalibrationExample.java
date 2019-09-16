package org.ergemp.mlt.kmeans.examples;

import org.ergemp.mlt.kmeans.actor.*;
import org.ergemp.mlt.kmeans.model.Kmeans;

public class RecalibrationExample {
    public static void main(String[] args){
        Kmeans myMeans = new Kmeans();

        Double[] myDouble = new Double[]{10.5,2.5};

        AddObservation.addArray(myMeans, myDouble);

        AddObservation.addCSV(myMeans,"10.2,2.1");
        AddObservation.addCSV(myMeans,"12,2");
        AddObservation.addCSV(myMeans,"18,3");
        AddObservation.addCSV(myMeans,"25,4");
        AddObservation.addCSV(myMeans,"15,4");

        AddObservation.addCSV(myMeans,"22,1");
        AddObservation.addCSV(myMeans,"27,2");
        AddObservation.addCSV(myMeans,"26,3");
        AddObservation.addCSV(myMeans,"11,5");
        AddObservation.addCSV(myMeans,"23,5");

        AddObservation.addCSV(myMeans,"50,10");
        AddObservation.addCSV(myMeans,"54,12");
        AddObservation.addCSV(myMeans,"60,8");
        AddObservation.addCSV(myMeans,"66,9");
        AddObservation.addCSV(myMeans,"64,7");

        System.out.println("printing observation set");
        System.out.println("------------------------");
        PrintObservationSet.print(myMeans);

        InitializeCentroids.initialize(myMeans,2);
        System.out.println("printing centroids");
        System.out.println("------------------");
        PrintCentroids.print(myMeans);

        RecalibrateCentroids.recalibrate(myMeans,2,4);
        System.out.println("printing recalibrated centroids");
        System.out.println("------------------");
        PrintCentroids.print(myMeans);

        /*
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.CEILING);
        for (Number n : Arrays.asList(12, 123.12345, 0.23, 0.1, 2341234.212431324)) {
            Double d = n.doubleValue();
            System.out.println(df.format(d));
        }
        */
    }
}
