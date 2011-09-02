package ru.artem.study.algorithms.sorting;

public class CountingSort extends Sorter{

    @Override
    public void sort(int[] a) {
        sort(a,0,100);
    }

    public void sort(int[] a, int min, int max){
        int[] count = new int[max-min+1];

        for (int i : a) {
            count[i - min] = count[i - min] + 1;
        }

        for(int i=0, cursor = 0; i<count.length; i++){
            for(;count[i]>0;count[i]--,cursor++){
                a[cursor] = min + i;
            }
        }
    }

    @Override
    public String getName() {
        return "Counting Sort";
    }
}
