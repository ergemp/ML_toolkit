package org.ergemp.mlt.kmeans.source;

import org.ergemp.mlt.kmeans.actor.AddObservation;
import org.ergemp.mlt.kmeans.model.Kmeans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LoadFromFile {
    public boolean load(Kmeans gKmeans, String gPath) {
        Boolean retVal=true;
        String line="";
        String[] lineArr;
        Double[] tmpDouble = new Double[2];

        try {
            File tmpFile = new java.io.File(gPath);
            FileReader fRdr = new FileReader(tmpFile);
            BufferedReader br = new BufferedReader(fRdr);

            while((line = br.readLine()) != null) {
                lineArr = line.split(",");
                for(Integer i=0; i<lineArr.length; i++) {
                    tmpDouble[i] = Double.parseDouble(lineArr[i]);
                }
                AddObservation.addArray(gKmeans, tmpDouble);
            }

            retVal = true;
        }
        catch (Exception Ex) {
            retVal = false;
        }
        finally {
            return retVal;
        }
    }
}
