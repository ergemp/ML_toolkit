package sentiment.actor.prepare;

import sentiment.model.FreqMatrix;
import sentiment.model.NamedFreqMatrix;
import sentiment.util.Concat;
import sentiment.util.Contain;

import java.util.HashMap;
import java.util.Map;

public class PrepareUni {

    String fileName = "";
    String filePath = "";

    public NamedFreqMatrix prepare(NamedFreqMatrix gNamedFreqMatrix) {
        try {
            java.io.File folder = new java.io.File(gNamedFreqMatrix.folderName);
            //System.out.println(System.getProperty("user.dir"));

            if (folder.isDirectory()) {
                java.io.File[] files = folder.listFiles();
                for (Integer i = 0; i < files.length; i++) {
                    filePath = files[i].getPath();
                    fileName = files[i].getName();

                    if (fileName.equalsIgnoreCase("ngrams")) {
                        continue;
                    }

                    java.io.File tmpFile = new java.io.File(filePath);
                    if (tmpFile.exists() && tmpFile.canRead()) {

                        java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(tmpFile));
                        String line = "";
                        while ((line = br.readLine()) != null) {

                            String[] words = line.split(" ");
                            String word;

                            for (int w = 0; w < words.length - (1) + 1; w++) {

                                word = Concat.concat(words, w, w + (1));
                                int index = Contain.contain(gNamedFreqMatrix.listUniFreqMatrix, word);
                                if (index != -1) {

                                    if (gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.containsKey(fileName)) {
                                        gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.replace(fileName, gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.get(fileName) + 1);
                                    } else {
                                        gNamedFreqMatrix.listUniFreqMatrix.get(index).freq.put(fileName, 1);
                                    }

                                } else {
                                    Map<String, Integer> tmpFreq = new HashMap();
                                    tmpFreq.put(fileName, 1);


                                    gNamedFreqMatrix.listUniFreqMatrix.add(new FreqMatrix(word, tmpFreq));
                                }
                            }
                            //System.out.println(line);
                        }
                    }
                }
            }

        } catch (Exception Ex) {
            System.out.println(Ex);
        }
        finally{
            return gNamedFreqMatrix;
        }
    }
}
