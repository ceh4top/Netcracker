package labs.laba1.sort;

import java.util.Comparator;

class BubbleSort implements Sort {
    private <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public <T> T[] sort(T[] array, Comparator<T> cmp) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = array.length - 1; j > i; --j) {
                if (cmp.compare(array[j-1], array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }

    public <T extends Comparable<T>> T[] sort(T[] array) {
        for (int i = 0; i < array.length; ++i) {
            for (int j = 1; j < array.length-i-1; ++j) {
                if (array[j-1].compareTo(array[j]) > 0) {
                    swap(array, i, j);
                }
            }
        }
        return array;
    }
}
