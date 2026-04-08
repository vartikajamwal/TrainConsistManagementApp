public class TrainConsistManagementApp {

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

    public static void main(String[] args) {
        System.out.println("UC14 - Handle Invalid Bogie Capacity (Custom Exception) \n");

        try {
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            PassengerBogie b2 = new PassengerBogie("AC Chair", 56);
            PassengerBogie b3 = new PassengerBogie("First Class", 0);
        } catch (InvalidCapacityException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed ...");
    }
}