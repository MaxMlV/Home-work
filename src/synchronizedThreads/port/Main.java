package synchronizedThreads.port;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        int shipsCount = 7;

        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= shipsCount; i++) {
            executor.execute(new ShipThread("Ship #" + i, 10));
        }

        executor.shutdown();
    }
}
