package ru.artem.study.algorithms.utils;

import java.util.Random;

/**
 *
 * @author artem
 */
public class SimpleGenerator{

    private static Random random = new Random();

    public static int[] getRandomArray(int arraylength, int max) {
        int array[] = new int[arraylength];

        arraylength--;
        for(;arraylength>=0;arraylength--)
            array[arraylength] = random.nextInt(max);

        return array;
    }

    public static int getRandomInt(int max){
        return random.nextInt(max);
    }
}
