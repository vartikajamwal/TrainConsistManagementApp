import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    int[] bubbleSort(int[] arr) {
        int[] copy = arr.clone();
        for (int i = 0; i < copy.length - 1; i++) {
            for (int j = 0; j < copy.length - 1 - i; j++) {
                if (copy[j] > copy[j + 1]) {
                    int temp = copy[j];
                    copy[j] = copy[j + 1];
                    copy[j + 1] = temp;
                }
            }
        }
        return copy;
    }

    @Test
    void testSort_BasicSorting() {
        int[] arr = {72, 56, 24, 70, 60};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, sorted);
    }

    @Test
    void testSort_AlreadySortedArray() {
        int[] arr = {24, 56, 60, 70, 72};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 60, 70, 72}, sorted);
    }

    @Test
    void testSort_DuplicateValues() {
        int[] arr = {72, 56, 56, 24};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{24, 56, 56, 72}, sorted);
    }

    @Test
    void testSort_SingleElementArray() {
        int[] arr = {50};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{50}, sorted);
    }

    @Test
    void testSort_AllEqualValues() {
        int[] arr = {40, 40, 40};
        int[] sorted = bubbleSort(arr);
        assertArrayEquals(new int[]{40, 40, 40}, sorted);
    }
}