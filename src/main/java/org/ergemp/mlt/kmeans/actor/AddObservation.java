package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

import java.util.List;


public class AddObservation {

    public static void addArray(Kmeans gKMeans, Double[] gDouble){
        try {
            gKMeans.observationSet.add(gDouble);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

    public static void addCSV(Kmeans gKMeans, String gCsv){

        Double[] tmpObservationLong = new Double[2];

        try {
            String[] tmpObservation = gCsv.split(",");
            for (Integer i=0; i<tmpObservation.length; i++) {
                tmpObservationLong[i] = Double.parseDouble(tmpObservation[i]);
            }

            gKMeans.observationSet.add(tmpObservationLong);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }
}
