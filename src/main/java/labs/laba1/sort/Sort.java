package labs.laba1.sort;

import java.util.Comparator;

public interface Sort {

    public <T> T[] sort(T[] array, Comparator<T> cmp);
    public <T extends Comparable<T>> T[] sort(T[] array);

}