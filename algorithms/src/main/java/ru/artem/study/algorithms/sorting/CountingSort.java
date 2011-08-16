package ru.artem.study.algorithms.sorting;

import ru.artem.study.algorithms.sorting.Sorter;

/**
 *
 * @author artem
 */
public class CountingSort extends Sorter {
    private static String name = "CountingSort";

    @Override
    public void sort(int[] a) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        return name;
    }

    private static int a[]={9,
                            99,
                            999,
                            9999,
                            99999,
                            999999,
                            9999999,
                            99999999,
                            999999999};

    public static int getRank(int num){
        int i =  0;
        while(i<a.length && (num > a[i])){ i++;}
        return i+1;
    }

}
