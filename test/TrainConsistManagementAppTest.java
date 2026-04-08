import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> generateBogies() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = generateBogies();
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }
        assertEquals(2, filtered.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = generateBogies();
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(2, filtered.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = generateBogies();
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) loopFiltered.add(b);
        }
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = generateBogies();
        long start = System.nanoTime();
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) filtered.add(b);
        }
        long end = System.nanoTime();
        long elapsed = end - start;
        assertTrue(elapsed > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("Sleeper", 70));
        }
        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) loopFiltered.add(b);
        }
        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertEquals(loopFiltered.size(), streamFiltered.size());
    }
}