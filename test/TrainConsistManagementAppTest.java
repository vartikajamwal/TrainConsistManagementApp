import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    boolean searchBogie(String[] bogieIDs, String key) {
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("No bogies exist in the train consist to search.");
        }
        for (String id : bogieIDs) {
            if (id.equals(key)) return true;
        }
        return false;
    }

    @Test
    void testSearch_ThrowsExceptionWhenEmpty() {
        String[] empty = {};
        assertThrows(IllegalStateException.class, () -> searchBogie(empty, "BG101"));
    }

    @Test
    void testSearch_AllowsSearchWhenDataExists() {
        String[] arr = {"BG101","BG205"};
        assertDoesNotThrow(() -> searchBogie(arr, "BG101"));
    }

    @Test
    void testSearch_BogieFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertTrue(searchBogie(arr, "BG205"));
    }

    @Test
    void testSearch_BogieNotFoundAfterValidation() {
        String[] arr = {"BG101","BG205","BG309"};
        assertFalse(searchBogie(arr, "BG999"));
    }

    @Test
    void testSearch_SingleElementValidCase() {
        String[] arr = {"BG101"};
        assertTrue(searchBogie(arr, "BG101"));
    }
}