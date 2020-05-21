package synchronizedThreads.port;

import java.util.concurrent.atomic.AtomicInteger;

public class Port {
    public AtomicInteger portFullness = new AtomicInteger(0);

    public Port() {
        super();
    }

    public synchronized boolean isFull() {
        while (portFullness.get() >= 2) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return false;
    }
}
