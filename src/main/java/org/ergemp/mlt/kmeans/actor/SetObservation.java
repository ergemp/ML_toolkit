package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

import java.util.List;

public class SetObservation {
    public static void set(Kmeans gKMeans, List<Double[]> gDoubleList){
        try {
            gKMeans.observationSet = gDoubleList;
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }
}
