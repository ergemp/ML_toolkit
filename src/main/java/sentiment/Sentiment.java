package sentiment;

import sentiment.actor.prepare.PrepareBi;
import sentiment.actor.prepare.PrepareTri;
import sentiment.actor.prepare.PrepareUni;
import sentiment.model.NamedFreqMatrix;

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
