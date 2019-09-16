package org.ergemp.mlt.kmeans.examples;

import org.ergemp.mlt.kmeans.actor.AddObservation;
import org.ergemp.mlt.kmeans.actor.InitializeCentroids;
import org.ergemp.mlt.kmeans.actor.PrintCentroids;
import org.ergemp.mlt.kmeans.actor.PrintObservationSet;
import org.ergemp.mlt.kmeans.model.Kmeans;

public class InitializeCentroidsExample {
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

        System.out.println("printing observation set");
        System.out.println("------------------------");
        PrintObservationSet.print(myMeans);

        InitializeCentroids.initialize(myMeans,2);

        System.out.println("printing centroids");
        System.out.println("------------------");
        PrintCentroids.print(myMeans);
    }
}
