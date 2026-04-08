import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class TrainConsistManagementAppInternal {

        static class CargoSafetyException extends RuntimeException {
            CargoSafetyException(String message) {
                super(message);
            }
        }

        static class GoodsBogie {
            String shape;
            String cargo;

            GoodsBogie(String shape) {
                this.shape = shape;
            }

            void assignCargo(String cargo) {
                try {
                    if ("Rectangular".equals(shape) && "Petroleum".equals(cargo)) {
                        throw new CargoSafetyException("Cannot assign Petroleum to Rectangular bogie");
                    }
                    this.cargo = cargo;
                } catch (CargoSafetyException e) {
                    throw e;
                } finally {
                    // finally block executes always
                }
            }
        }
    }

    @Test
    void testCargo_SafeAssignment() {
        TrainConsistManagementAppInternal.GoodsBogie b = new TrainConsistManagementAppInternal.GoodsBogie("Cylindrical");
        assertDoesNotThrow(() -> b.assignCargo("Petroleum"));
        assertEquals("Petroleum", b.cargo);
    }

    @Test
    void testCargo_UnsafeAssignmentHandled() {
        TrainConsistManagementAppInternal.GoodsBogie b = new TrainConsistManagementAppInternal.GoodsBogie("Rectangular");
        TrainConsistManagementAppInternal.CargoSafetyException exception =
                assertThrows(TrainConsistManagementAppInternal.CargoSafetyException.class, () -> b.assignCargo("Petroleum"));
        assertEquals("Cannot assign Petroleum to Rectangular bogie", exception.getMessage());
    }

    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        TrainConsistManagementAppInternal.GoodsBogie b = new TrainConsistManagementAppInternal.GoodsBogie("Rectangular");
        assertThrows(TrainConsistManagementAppInternal.CargoSafetyException.class, () -> b.assignCargo("Petroleum"));
        assertNull(b.cargo);
    }

    @Test
    void testCargo_ProgramContinuesAfterException() {
        TrainConsistManagementAppInternal.GoodsBogie b1 = new TrainConsistManagementAppInternal.GoodsBogie("Rectangular");
        TrainConsistManagementAppInternal.GoodsBogie b2 = new TrainConsistManagementAppInternal.GoodsBogie("Cylindrical");

        assertThrows(TrainConsistManagementAppInternal.CargoSafetyException.class, () -> b1.assignCargo("Petroleum"));
        assertDoesNotThrow(() -> b2.assignCargo("Petroleum"));
        assertEquals("Petroleum", b2.cargo);
    }

    @Test
    void testCargo_FinallyBlockExecution() {
        TrainConsistManagementAppInternal.GoodsBogie b = new TrainConsistManagementAppInternal.GoodsBogie("Rectangular");
        try {
            b.assignCargo("Petroleum");
        } catch (TrainConsistManagementAppInternal.CargoSafetyException e) {
            // expected
        } finally {
            // code that runs regardless
        }
    }
}