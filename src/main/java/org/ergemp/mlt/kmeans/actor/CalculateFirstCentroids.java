package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.Kmeans;

import java.util.Iterator;

public class CalculateFirstCentroids {

    public static void calculate(Kmeans gKmeans, Integer gK) {
        Double[][] localSum = new Double[2][4];
        Double[] localDistance = new Double[4];

        Integer cnt = 0;
        Integer obsIndex = 0;

        try {
            //initialize localSum matrix
            for (Integer a=0; a<localSum.length; a++) {
                for (Integer aa=0; aa<localSum[a].length; aa++) {
                    localSum[a][aa] = null;
                }
            }

            //initialize localDistance array
            for (Integer a=0; a<localDistance.length; a++) {
                localDistance[a] = null;
            }

            //for all the observationList loop
            Iterator itObs = gKmeans.observationSet.iterator();
            while (itObs.hasNext()) {
                Double[] oDouble = (Double[]) itObs.next();

                //calculate the distance with the observationList dimension
                for (Integer j=0; j<oDouble.length; j++) {
                    if (oDouble[j] != null) {
                        //clear the cnt
                        cnt=0;

                        //for all the centroids calculate the distance and take the lowest as cluster
                        Iterator itCentroid = gKmeans.centroids.iterator();
                        while (itCentroid.hasNext()) {
                            Double[] cDouble = (Double[]) itCentroid.next();
                            if (cDouble[j] != null) {
                                //fill the localSum matrix
                                //j is the dimension, support max 2 dimension
                                //cnt is the cluster, support max 4 clusters
                                if (localSum[j][cnt] != null) {
                                    localSum[j][cnt] = localSum[j][cnt] + java.lang.Math.pow(java.lang.Math.abs(oDouble[j]-cDouble[j]),2);
                                }
                                else {
                                    localSum[j][cnt] =  java.lang.Math.pow(java.lang.Math.abs(oDouble[j]-cDouble[j]),2);
                                }
                                //System.out.println(j + " " + cnt + " observation: " + lDouble[j] + " - " + "centroid: " + cDouble[j] + " dist: " + java.lang.Math.pow(java.lang.Math.abs(lDouble[j]-cDouble[j]),2));
                                cnt ++;
                            }
                            else {

                            }
                        }
                    }
                }


                //print localSum matrix
                /*
                System.out.println("calculated localSum");
                for (Integer a=0; a<localSum.length; a++)
                {
                    for (Integer aa=0; aa<localSum[a].length; aa++)
                    {
                        if (localSum[a][aa] != null) {
                            System.out.println(a + " " + aa + " - " + localSum[a][aa].toString());
                        }
                    }
                }
                */

                //calculate localDistance
                for (Integer a=0; a<localSum.length; a++) {
                    for (Integer aa=0; aa<localSum[a].length; aa++) {
                        if (localDistance[aa] != null)
                            localDistance[aa] = localDistance[aa] + localSum[a][aa];
                        else
                            localDistance[aa] = localSum[a][aa];
                    }
                }

                for (Integer aa=0; aa<localDistance.length; aa++) {
                    if (localDistance[aa] != null) {
                        localDistance[aa] = java.lang.Math.sqrt(localDistance[aa]);
                    }
                }

                //print localDistance array
                /*
                System.out.println("calculated localDistance");
                for (Integer a=0; a<localDistance.length; a++)
                {
                    if (localDistance[a] != null) {
                        System.out.println(a + " - " + localDistance[a].toString());
                    }
                }
                */

                //calculate the closest centroid to the observation
                Double tmpDistance = null;
                Integer tmpIndex = 0;
                for (Integer a=0; a<localDistance.length; a++) {
                    if (localDistance[a] != null) {
                        if (tmpDistance == null) {
                            tmpDistance = localDistance[a];
                            tmpIndex = a;
                        }
                        else {
                            if (tmpDistance >= localDistance[a]) {
                                tmpDistance = localDistance[a];
                                tmpIndex = a;
                            }
                        }
                    }
                }

                //set clusterLabel
                gKmeans.labelSet.add(obsIndex, gKmeans.clusterLabels[tmpIndex]);

                //clean localSum matrix
                for (Integer a=0; a<localSum.length; a++) {
                    for (Integer aa=0; aa<localSum[a].length; aa++) {
                        localSum[a][aa] = null;
                    }
                }

                //clean localDistance array
                for (Integer a=0; a<localSum.length; a++) {
                    localDistance[a] = null;
                }

                //increase the obsIndex
                //to find, which observation point calculated
                obsIndex ++;
            }

            for (Integer a=0; a < gKmeans.labelSet.size(); a++) {
                System.out.println(gKmeans.observationSet.get(a)[0] + " , "  + gKmeans.observationSet.get(a)[1] + " -> " + gKmeans.labelSet.get(a));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

}
