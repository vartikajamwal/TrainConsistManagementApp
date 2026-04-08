import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class TrainConsistManagementAppInternal {

        static class InvalidCapacityException extends Exception {
            InvalidCapacityException(String message) {
                super(message);
            }
        }

        static class PassengerBogie {
            String type;
            int capacity;

            PassengerBogie(String type, int capacity) throws InvalidCapacityException {
                if (capacity <= 0) {
                    throw new InvalidCapacityException("Capacity must be greater than zero");
                }
                this.type = type;
                this.capacity = capacity;
            }
        }
    }

    @Test
    void testException_ValidCapacityCreation() throws TrainConsistManagementAppInternal.InvalidCapacityException {
        TrainConsistManagementAppInternal.PassengerBogie b =
                new TrainConsistManagementAppInternal.PassengerBogie("Sleeper", 72);
        assertEquals(72, b.capacity);
        assertEquals("Sleeper", b.type);
    }

    @Test
    void testException_NegativeCapacityThrowsException() {
        assertThrows(TrainConsistManagementAppInternal.InvalidCapacityException.class, () -> {
            new TrainConsistManagementAppInternal.PassengerBogie("AC Chair", -10);
        });
    }

    @Test
    void testException_ZeroCapacityThrowsException() {
        assertThrows(TrainConsistManagementAppInternal.InvalidCapacityException.class, () -> {
            new TrainConsistManagementAppInternal.PassengerBogie("First Class", 0);
        });
    }

    @Test
    void testException_ExceptionMessageValidation() {
        TrainConsistManagementAppInternal.InvalidCapacityException exception =
                assertThrows(TrainConsistManagementAppInternal.InvalidCapacityException.class, () -> {
                    new TrainConsistManagementAppInternal.PassengerBogie("Sleeper", -5);
                });
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    @Test
    void testException_ObjectIntegrityAfterCreation() throws TrainConsistManagementAppInternal.InvalidCapacityException {
        TrainConsistManagementAppInternal.PassengerBogie b =
                new TrainConsistManagementAppInternal.PassengerBogie("AC Chair", 56);
        assertEquals(56, b.capacity);
        assertEquals("AC Chair", b.type);
    }

    @Test
    void testException_MultipleValidBogiesCreation() throws TrainConsistManagementAppInternal.InvalidCapacityException {
        TrainConsistManagementAppInternal.PassengerBogie b1 =
                new TrainConsistManagementAppInternal.PassengerBogie("Sleeper", 72);
        TrainConsistManagementAppInternal.PassengerBogie b2 =
                new TrainConsistManagementAppInternal.PassengerBogie("AC Chair", 56);
        TrainConsistManagementAppInternal.PassengerBogie b3 =
                new TrainConsistManagementAppInternal.PassengerBogie("First Class", 24);

        assertEquals(72, b1.capacity);
        assertEquals(56, b2.capacity);
        assertEquals(24, b3.capacity);
    }
}