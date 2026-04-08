public class TrainConsistManagementApp {

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
                System.out.println("Cargo assigned: " + cargo + " to " + shape + " bogie");
            } catch (CargoSafetyException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Cargo assignment validation completed for " + shape + " bogie\n");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("UC15 - Safe Cargo Assignment Using try-catch-finally \n");

        GoodsBogie b1 = new GoodsBogie("Cylindrical");
        GoodsBogie b2 = new GoodsBogie("Rectangular");

        b1.assignCargo("Petroleum");
        b2.assignCargo("Petroleum");

        System.out.println("UC15 cargo assignment completed ...");
    }
}