package ru.artem.study.algorithms.search;

import ru.artem.study.algorithms.utils.SimpleGenerator;
import ru.artem.study.algorithms.utils.Utils;

import java.util.Arrays;

/**
 *
 * @author artem
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int length = 20;

        int array[] = SimpleGenerator.getRandomArray(length, 50);
        Arrays.sort(array);
        Utils.printArray(array);
        System.out.println("---------------------------------------------------");

        int find = array[SimpleGenerator.getRandomInt(length-1)];
        System.out.println(find);
        System.out.println("---------------------------------------------------");

        System.out.println("standart - " +     Arrays.binarySearch(array, find));
        System.out.println("my iter - " +      (new BinarySearchImpl()).find(array, find));
        System.out.println("my recursive - " + (new BinarySearchRecursiveImpl()).find(array, find));
    }

}
