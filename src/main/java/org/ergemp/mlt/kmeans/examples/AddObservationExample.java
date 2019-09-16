package org.ergemp.mlt.kmeans.examples;

import org.ergemp.mlt.kmeans.actor.AddObservation;
import org.ergemp.mlt.kmeans.actor.PrintObservationSet;
import org.ergemp.mlt.kmeans.model.Kmeans;

import java.util.ArrayList;
import java.util.List;

public class AddObservationExample {
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

        PrintObservationSet.print(myMeans);
    }
}
