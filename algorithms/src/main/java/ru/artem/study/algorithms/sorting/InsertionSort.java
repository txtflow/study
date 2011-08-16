package ru.artem.study.algorithms.sorting;

/**
 *
 * @author artem
 */
public class InsertionSort extends Sorter{

    private static String name = "InsertionSort";

    /**
     * insertion sort O(n^2)
     * @param array input array
     */
    public void sort(int array[]){
        int t;
        for(int j,i=1;i<array.length;i++){
            t = array[i];
            for(j=i-1;j>=0 && t<array[j];j--){
                array[j+1] = array[j];
            }
            array[j+1] = t;
        }
    }

    public String getName() {
        return name;
    }

}
