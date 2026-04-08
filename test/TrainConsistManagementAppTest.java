import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    String[] sortBogieNames(String[] arr) {
        String[] copy = arr.clone();
        Arrays.sort(copy);
        return copy;
    }

    @Test
    void testSort_BasicAlphabeticalSorting() {
        String[] arr = {"Sleeper","AC Chair","First Class","General","Luxury"};
        String[] sorted = sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General","Luxury","Sleeper"}, sorted);
    }

    @Test
    void testSort_UnsortedInput() {
        String[] arr = {"Luxury","General","Sleeper","AC Chair"};
        String[] sorted = sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Luxury","Sleeper"}, sorted);
    }

    @Test
    void testSort_AlreadySortedArray() {
        String[] arr = {"AC Chair","First Class","General"};
        String[] sorted = sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","First Class","General"}, sorted);
    }

    @Test
    void testSort_DuplicateBogieNames() {
        String[] arr = {"Sleeper","AC Chair","Sleeper","General"};
        String[] sorted = sortBogieNames(arr);
        assertArrayEquals(new String[]{"AC Chair","General","Sleeper","Sleeper"}, sorted);
    }

    @Test
    void testSort_SingleElementArray() {
        String[] arr = {"Sleeper"};
        String[] sorted = sortBogieNames(arr);
        assertArrayEquals(new String[]{"Sleeper"}, sorted);
    }
}