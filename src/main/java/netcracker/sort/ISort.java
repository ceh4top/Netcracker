package netcracker.sort;

import java.util.Comparator;

public interface ISort {

    public <T> T[] sort(T[] array, Comparator<T> cmp);
    public <T extends Comparable<T>> T[] sort(T[] array);

}