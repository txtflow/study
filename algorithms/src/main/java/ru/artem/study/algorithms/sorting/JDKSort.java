package ru.artem.study.algorithms.sorting;

import java.util.Arrays;

/**
 *
 * @author artem
 */
public class JDKSort extends Sorter{

    private static String name = "JDKSort";

    @Override
    public void sort(int[] a) {
        Arrays.sort(a);
    }

    @Override
    public String getName() {
        return name;
    }

}
