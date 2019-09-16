package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

import java.util.Iterator;

public class PrintCentroids {
    public static void print(Kmeans gKmeans){
        Iterator it = gKmeans.centroids.iterator();
        while(it.hasNext())
        {
            Double[] tmpDouble = (Double[])it.next();
            for (Integer i=0; i<tmpDouble.length; i++)
            {
                if (tmpDouble[i] != null)
                {
                    System.out.print(tmpDouble[i].toString() + ",");
                }
            }
            System.out.println("");
        }
    }
}
