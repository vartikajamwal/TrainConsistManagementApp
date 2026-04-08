import java.util.Scanner;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("UC18 - Linear Search for Bogie ID\n");

        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        boolean found = false;
        for (String id : bogieIDs) {
            if (id.equals(searchKey)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Bogie ID " + searchKey + " exists in the consist.");
        } else {
            System.out.println("Bogie ID " + searchKey + " not found.");
        }

        System.out.println("\nUC18 search completed ...");
    }
}