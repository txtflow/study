package ru.artem.study.algorithms.sorting;

import ru.artem.study.algorithms.utils.SimpleGenerator;

import static ru.artem.study.algorithms.utils.Utils.printArray;

/**
 *
 * @author artem
 */
public class SortingTest {

    public static void main(String[] args) {
        final int a[] = SimpleGenerator.getRandomArray(20, 100);
        final int sortedArray[];

        sortedArray = (new JDKSort()).test(a.clone());
        printArray(sortedArray);
        int sa[] = a.clone();
        (new CountingSort()).sort(sa);
        printArray(sa);


//        Utils.equals(sortedArray, (new QuickSort()).test(a.clone()));
//        Utils.equals(sortedArray,(new HeapSort()).test(a.clone()));
//        Utils.equals(sortedArray,(new CountingSort()).test(a.clone()));
//        Utils.equals(sortedArray,(new InsertionSort()).test(a.clone()));

        /*
        int a2[] = a1.clone();
        int a3[] = a1.clone();

        System.out.println("Input Array");
        Utils.printArray(a1);
        
        System.out.println("Insertion Sort");
        InsertionSort.sort(a1);
        Utils.printArray(a1);

        System.out.println("Heap Sort");
        HeapSort.sort(a2);
        Utils.printArray(a2);
        
        System.out.println("Quick Sort");
        QuickSort.sort(a3);
        Utils.printArray(a3);
         *
         */
    }

}
