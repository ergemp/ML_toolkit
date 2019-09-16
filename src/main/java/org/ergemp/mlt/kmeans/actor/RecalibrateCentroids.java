package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

public class RecalibrateCentroids {
    public static void recalibrate(Kmeans gKmeans, Integer gK, Integer gPassCount) {
        Integer ctlPassCount = 0;

        Double[] localSum = new Double[4];

        for (Integer a=0; a<localSum.length; a++) {
            localSum[a] = null;
        }

        try {
            while(ctlPassCount < gPassCount) {
                for (Integer j=0; j < gKmeans.labelSet.size(); j++) {

                    if (gKmeans.labelSet.get(j).equalsIgnoreCase("cluster1")) {
                        if (localSum[0] == null) {
                            localSum[0] = gKmeans.observationSet.get(j)[0];
                        }
                        else {
                            localSum[0] = localSum[0] + gKmeans.observationSet.get(j)[0];
                        }
                    }

                    if (gKmeans.labelSet.get(j).equalsIgnoreCase("cluster2")) {
                        if (localSum[1] == null) {
                            localSum[1] = gKmeans.observationSet.get(j)[0];
                        }
                        else {
                            localSum[1] = localSum[1] + gKmeans.observationSet.get(j)[0];
                        }
                    }
                }
                ctlPassCount ++;
            }
            System.out.println(localSum[0]);
            System.out.println(localSum[1]);
            System.out.println(localSum[2]);
            System.out.println(localSum[3]);
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }
}
