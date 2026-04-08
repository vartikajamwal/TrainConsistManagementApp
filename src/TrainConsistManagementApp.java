import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static boolean searchBogie(String[] bogieIDs, String key) {
        if (bogieIDs == null || bogieIDs.length == 0) {
            throw new IllegalStateException("No bogies exist in the train consist to search.");
        }
        for (String id : bogieIDs) {
            if (id.equals(key)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search with validation: ");
        String searchKey = scanner.nextLine();

        try {
            boolean found = searchBogie(bogieIDs, searchKey);
            if (found) System.out.println("Bogie ID " + searchKey + " exists in the consist.");
            else System.out.println("Bogie ID " + searchKey + " not found.");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("UC20 search with validation completed ...");
    }
}