import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()\n");

        String[] bogieNames = {"Sleeper","AC Chair","First Class","General","Luxury"};

        Arrays.sort(bogieNames);

        System.out.println("Sorted Bogie Names: " + Arrays.toString(bogieNames));
        System.out.println("\nUC17 sorting completed ...");
    }
}