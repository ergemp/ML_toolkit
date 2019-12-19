package org.ergemp.mlt.sorting.algorithm;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static List<List<Integer>> singular = new ArrayList<>();
    public static List<List<Integer>> singularTmp = new ArrayList<>();
    public static List<Integer> sorted = new ArrayList<>();

    //divide recursion function
    public static void divide(List<Integer> gList) {
        try {
            if (gList.size() == 1) {
                //System.out.println("return: " + gList.toString());
                singular.add(gList);
            } else {
                //System.out.println("divide: " + gList.subList(0, Math.round(gList.size() / 2)).toString());
                //System.out.println("divide: " + gList.subList(Math.round(gList.size() / 2), gList.size()).toString());
                divide(gList.subList(0, Math.round(gList.size() / 2)));
                divide(gList.subList(Math.round(gList.size() / 2), gList.size()));
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
        }
    }

    //merge function
    public static List<Integer> merge(List<Integer> gList1, List<Integer> gList2){
        List<Integer> retVal = new ArrayList<>();

        Integer pointer1 = 0 ;
        Integer pointer2 = 0 ;

        try {
            while (true) {
                //check if one of the lists consumed completely
                if (gList1.size() - (pointer1) == 0) {
                    if (gList2.size() - (pointer2) != 0) {
                        retVal.add(gList2.get(pointer2));
                        singular.remove(gList2.get(pointer2));
                        pointer2 ++;
                    }
                    else
                    {
                        break;
                    }
                }
                else if (gList2.size() - (pointer2) == 0) {
                    if (gList1.size() - (pointer1) != 0) {
                        retVal.add(gList1.get(pointer1));
                        singular.remove(gList1.get(pointer1));
                        pointer1 ++;
                    }
                    else
                    {
                        break;
                    }
                }

                //generate sorted and merged list
                if (gList1.get(pointer1) <= gList2.get(pointer2)){
                    retVal.add(gList1.get(pointer1));
                    singular.remove(gList1.get(pointer1));
                    pointer1 ++;
                }
                else{
                    retVal.add(gList2.get(pointer2));
                    singular.remove(gList2.get(pointer2));
                    pointer2 ++;
                }
            }
        }
        catch(IndexOutOfBoundsException iobe) {
            //ex.printStackTrace();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        finally {
            singularTmp.add(retVal);
            return retVal;
        }
    }
}

