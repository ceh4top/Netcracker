package labs.laba1.sort;

import java.util.Comparator;

public class Sort {
    private final static BubbleSort bubbleSort = new BubbleSort();
    private final static QuickSort quickSort = new QuickSort();

    public static <T> void bubbleSorting(T[] array, Comparator<T> cmp) {
        bubbleSort.sort(array, cmp);
    }
    public static <T extends Comparable<T>> void bubbleSorting(T[] array) {
        bubbleSort.sort(array);
    }

    public static <T> void quickSorting(T[] array, Comparator<T> cmp) {
        quickSort.sort(array, cmp);
    }

    public static <T extends Comparable<T>> void quickSorting(T[] array) {
        quickSort.sort(array);
    }
}