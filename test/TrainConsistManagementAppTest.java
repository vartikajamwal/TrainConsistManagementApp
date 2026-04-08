// Test Class
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    @Test
    void testRegex_ValidTrainID() {
        String input = "TRN-1234";
        Pattern p = Pattern.compile("TRN-\\d{4}");
        Matcher m = p.matcher(input);
        assertTrue(m.matches());
    }

    @Test
    void testRegex_InvalidTrainIDFormat() {
        String[] inputs = {"TRAIN12", "TRN12A", "1234-TRN"};
        Pattern p = Pattern.compile("TRN-\\d{4}");
        for (String input : inputs) {
            Matcher m = p.matcher(input);
            assertFalse(m.matches());
        }
    }

    @Test
    void testRegex_ValidCargoCode() {
        String input = "PET-AB";
        Pattern p = Pattern.compile("PET-[A-Z]{2}");
        Matcher m = p.matcher(input);
        assertTrue(m.matches());
    }

    @Test
    void testRegex_InvalidCargoCodeFormat() {
        String[] inputs = {"PET-ab", "PET123", "AB-PET"};
        Pattern p = Pattern.compile("PET-[A-Z]{2}");
        for (String input : inputs) {
            Matcher m = p.matcher(input);
            assertFalse(m.matches());
        }
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation() {
        String[] inputs = {"TRN-123", "TRN-12345"};
        Pattern p = Pattern.compile("TRN-\\d{4}");
        for (String input : inputs) {
            Matcher m = p.matcher(input);
            assertFalse(m.matches());
        }
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation() {
        String[] inputs = {"PET-ab", "PET-Aa", "PET-aa"};
        Pattern p = Pattern.compile("PET-[A-Z]{2}");
        for (String input : inputs) {
            Matcher m = p.matcher(input);
            assertFalse(m.matches());
        }
    }

    @Test
    void testRegex_EmptyInputHandling() {
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");
        assertFalse(trainPattern.matcher("").matches());
        assertFalse(cargoPattern.matcher("").matches());
    }

    @Test
    void testRegex_ExactPatternMatch() {
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");
        assertFalse(trainPattern.matcher("TRN-1234X").matches());
        assertFalse(cargoPattern.matcher("PET-ABX").matches());
    }
}