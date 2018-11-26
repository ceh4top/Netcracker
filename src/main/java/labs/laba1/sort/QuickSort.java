package labs.laba1.sort;

import java.util.Comparator;
import java.util.Random;

class QuickSort implements Sort {
    private static final Random RND = new Random();

    private <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    private <T> int partition(T[] array, int begin, int end, Comparator<T> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        T pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }
    private <T> void qsort(T[] array, int begin, int end, Comparator<T> cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            qsort(array, begin, index - 1, cmp);
            qsort(array, index + 1,  end,  cmp);
        }
    }
    public <T> T[] sort(T[] array, Comparator<T> cmp) {
        qsort(array, 0, array.length - 1, cmp);
        return array;
    }

    private <T extends Comparable<T>> int partition(T[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        T pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++ i) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }
    private <T extends Comparable<T>> void qsort(T[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qsort(array, begin, index - 1);
            qsort(array, index + 1,  end);
        }
    }
    public <T extends Comparable<T>> T[] sort(T[] array) {
        qsort(array, 0, array.length - 1);
        return array;
    }
}
