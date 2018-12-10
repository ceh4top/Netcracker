package netcracker.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {

    @Test
    void sort() {
        Integer[] arraySort = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        Integer[] arrayNotSort = new Integer[] {10,7,9,5,6,1,2,4,3,8};
        ISort sort = new QuickSort();
        assertArrayEquals(sort.sort(arrayNotSort), arraySort);
    }

    @Test
    void sortCompare() {
        Integer[] arraySort = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        Integer[] arrayNotSort = new Integer[] {10,7,9,5,6,1,2,4,3,8};
        ISort sort = new QuickSort();
        assertArrayEquals(sort.sort(arrayNotSort, (x1, x2) -> x1 - x2), arraySort);
    }
}