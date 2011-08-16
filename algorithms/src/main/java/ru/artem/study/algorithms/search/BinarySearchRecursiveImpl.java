package ru.artem.study.algorithms.search;

public class BinarySearchRecursiveImpl implements SearcherInterface {
    public int find(int[] array, int n){
        return recursiveSearch(array, n, 0, array.length-1);
    }

    private static int recursiveSearch(int array[], int n, int low, int high){
        int mid = (high+low) >>> 1;

        if(n == array[mid]){
            return mid;
        }else if(n < array[mid]) {
            high = mid-1;
        } else{ //n>array[mid]
            low = mid+1;
        }

        return recursiveSearch(array, n, low, high);
    }
}
