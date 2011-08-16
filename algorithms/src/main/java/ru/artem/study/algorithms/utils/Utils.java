package ru.artem.study.algorithms.utils;


/**
 *
 * @author artem
 */
public class Utils {

    public static void printArray(int a[]){
//        for(int i: a)
//            System.out.print(i+" ");
//
//        System.out.println();
        printArray(a, 0, a.length);
    }

    public static void printArray(int a[], int start, int stop){
        for(int i=start;i<stop;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static void swap(int a[], int i, int j){
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /*public static boolean equals(int a1[], int a2[]){
        if(a1.length != a2.length) return false;
        for(int i=0; i<a1.length;i++){
            if(a1[i] != a2[i]) return false;
        }

        return true;
    }*/

    public static boolean equals(int a1[], int a2[]){
        if(a1.length != a2.length) return false;
        for(int i=0; i<a1.length;i++){
            if(a1[i] != a2[i]) return false;
        }

        return true;
    }

}
