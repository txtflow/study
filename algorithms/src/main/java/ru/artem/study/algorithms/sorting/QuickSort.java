package ru.artem.study.algorithms.sorting;

import static ru.artem.study.algorithms.utils.Utils.*;

/**
 *
 * @author artem
 */
public class QuickSort extends Sorter {

    private static String name = "QuickSort";

    public void sort(int a[]){
        quickSort(a, 0, a.length);
    }
    /*
    private static int partition(int a[], int low, int high){
                        //pivot is last item - a[high-1]
        int l=low;      //less pivot; range - from 0 to low
                        //more pivot; range - from low to high
        int p = high-1; //pivot index (always last)

        for(int i=low;i<p;i++){
            if(a[i]<a[p]){  //less pivot
                Utils.swap(a, i, l);
                ++l;
            }
            //else more or equals
        }
        Utils.swap(a, l, p);
        return l;
    }

    private static void quickSort(int a[], int low, int high){
        if(low<high){
            int pivot = partition(a, low, high);
            quickSort(a, low, pivot);
            quickSort(a, pivot+1, high);
        }
    }*/

    private static void quickSort(int a[], int low, int high){
        if(low<high){
            int p = partition(a, low, high);
            quickSort(a, low, p-1);
            quickSort(a, p, high);
        }
    }

    private static int partition(int a[], int low, int high){
        int l = low;
        high = high-1;
        for(int i=l;i<high;i++){
            if(a[i]<a[high]){
                l++;
                swap(a, l, i);
            }
        }
        swap(a, l, high);
        return l;
    }

    public String getName() {
        return name;
    }
}
