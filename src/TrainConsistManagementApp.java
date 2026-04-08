import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {

    public static boolean binarySearch(String[] arr, String key) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = arr[mid].compareTo(key);
            if (cmp == 0) return true;
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] bogieIDs = {"BG101","BG205","BG309","BG412","BG550"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Bogie ID to search (Binary Search): ");
        String searchKey = scanner.nextLine();

        boolean found = binarySearch(bogieIDs, searchKey);
        if (found) System.out.println("Bogie ID " + searchKey + " exists in the consist.");
        else System.out.println("Bogie ID " + searchKey + " not found.");

        System.out.println("UC19 search completed ...");
    }
}