package org.ergemp.mlt.sentiment.sink;

import org.ergemp.mlt.sentiment.model.NamedFreqMatrix;
import org.ergemp.mlt.sentiment.util.Config;

public class SaveToFile {

    public static void save(NamedFreqMatrix gNamedFreqMatrix){
        //create a new file under the folderName folder
        java.io.File saveFile = new java.io.File(Config.folderName + "/ngrams");
        String newLine = "\r\n";
        String line = "";

        try
        {
            if (!saveFile.exists())
            {
                saveFile.createNewFile();
            }
            else
            {
                deleteFile(saveFile.getAbsolutePath());
                saveFile.createNewFile();
            }

            java.io.FileWriter fw = new java.io.FileWriter(saveFile, false);

            //write the unigrams
            for (Integer c=0; c < this.listUniFreqMatrix.size() ; c++)
            {
                line = "";

                Iterator it = this.listUniFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += this.listUniFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }

                fw.write(line);
                fw.write(newLine);

            }

            //write the bigrams
            for (Integer c=0; c < this.listBiFreqMatrix.size() ; c++)
            {
                line = "";

                Iterator it = this.listBiFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += this.listBiFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }

                fw.write(line);
                fw.write(newLine);

            }

            //write the trigrams
            for (Integer c=0; c < this.listTriFreqMatrix.size() ; c++)
            {
                line = "";

                Iterator it = this.listTriFreqMatrix.get(c).freq.entrySet().iterator() ;

                line += this.listTriFreqMatrix.get(c).word ;

                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    line += "$" + pair.getKey() + "=" + pair.getValue();
                    //it.remove();
                }

                fw.write(line);
                fw.write(newLine);

            }

            fw.flush();
            fw.close();

        }
        catch (Exception Ex)
        {
            System.out.println(Ex);
        }
    }
}
