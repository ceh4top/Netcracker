package netcracker.sort;

import java.util.Comparator;

public class BubbleSort implements ISort {
    private <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public <T> T[] sort(T[] array, Comparator<T> cmp) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = array.length - 1; j > i; --j) {
                if (cmp.compare(array[j-1], array[j]) > 0) {
                    swap(array, j-1, j);
                }
            }
        }
        return array;
    }
    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length - 1; ++i) {
            for (int j = array.length - 1; j > i; --j) {
                if (array[j-1].compareTo(array[j]) > 0) {
                    swap(array, j-1, j);
                }
            }
        }
        return array;
    }
}
