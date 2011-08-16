package ru.artem.study.algorithms.search;

public class BinarySearchImpl implements SearcherInterface {

    public int find(int array[], int n){
        int low = 0;
        int high = array.length-1;

        while(low<=high){
            int mid = (high+low)>>>1;
            
            if(n == array[mid]){
                return mid;
            } else if(n < array[mid]) {
                high = mid-1;
            } else{ //n>array[mid]
                low = mid+1;
            }
        }

        return -1;
    }

}
