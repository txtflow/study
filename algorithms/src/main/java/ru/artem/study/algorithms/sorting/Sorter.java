
package ru.artem.study.algorithms.sorting;

import java.util.Formatter;

/**
 *
 * @author artem
 */
public abstract class Sorter {

    private static Formatter formatter = new Formatter();

//    static{
//        formatter
//    }

    public abstract void sort(int a[]);

    public abstract String getName();

    public int[] test(int a[]){
        long start = System.nanoTime();
        sort(a);
        long time = System.nanoTime() - start;
        System.out.println(String.format("%1$-20s %2$10d", getName(),time));

        return a;
    }

}
