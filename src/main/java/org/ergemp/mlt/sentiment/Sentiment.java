package org.ergemp.mlt.sentiment;

import org.ergemp.mlt.sentiment.actor.prepare.PrepareTri;
import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;

import java.util.Iterator;

public class Sentiment {

    public static void main(String[] args) {
        NamedFreqMatrix matrix = new NamedFreqMatrix();

        matrix = PrepareTri.prepare(matrix, "what the fuck");
        matrix = PrepareTri.prepare(matrix, "fuck you");

        Iterator it = matrix.listTriFreqMatrix.iterator() ;
        while(it.hasNext()){
            System.out.println(it.next().toString());

        }
    }
}
