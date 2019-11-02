package org.ergemp.mlt.kmeans.actor;

import org.ergemp.mlt.kmeans.model.KCentroidSet;
import org.ergemp.mlt.kmeans.model.KData;
import org.ergemp.mlt.kmeans.model.KDataSet;

import java.util.Iterator;

public class RecalibrateKCentroidSet {
    public static void recalibrate(KCentroidSet gKCentroidSet, KDataSet gKDataSet, Integer iteration) {

        Iterator it = gKDataSet.getKDataSet().iterator();
        while (it.hasNext()){
            KData data = (KData)it.next();
            //data.euclideanDistance()
        }

    }
}
