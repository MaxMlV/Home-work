package synchronizedThreads.port;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Port port = new Port();

        int shipsCount = 3;

        ExecutorService executor = Executors.newFixedThreadPool(shipsCount);

        for (int i = 1; i <= shipsCount; i++) {
            executor.execute(new ShipThread("Ship #" + i, 10, port));
        }

        executor.shutdown();
    }
}
