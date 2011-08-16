package ru.artem.study.algorithms.sorting;

import ru.artem.study.algorithms.utils.Utils;


/**
 *
 * @author artem
 */
public class HeapSort extends Sorter{

    private static String name = "HeapSort";

    /**
     * HeapSort - O(nln(n))
     * leftChild(n) = 2n
     * rightChild(n) = 2n+1
     * parent(n) = n/2
     * heap high = ln(n)
     * @param a input array
     */
    public void sort(int a[]){
        buildMaxHeap(a);
        for(int i=a.length-1;i>=1;i--){
            Utils.swap(a, 0, i);
            maxHeap(a, 0, i-1);
        }
    }

    private static void maxHeap(int a[], int i, int heapSize){
        int t;

        t=2*i+1;
        if(t<=heapSize){                           // left child in heap
            if((t+1)<=heapSize && a[t+1]>a[t]){    // 2*i+1 right child
                t++;                               // right > left
            }

            if(a[t]>a[i]){
                Utils.swap(a,t,i);
                maxHeap(a, t, heapSize);
            }
        }else return;
    }

    private static void buildMaxHeap(int a[]){
        for(int i=a.length/2-1;i>=0;i--){
            maxHeap(a,i,a.length-1);
        }
    }

    public String getName() {
        return HeapSort.name;
    }

}
