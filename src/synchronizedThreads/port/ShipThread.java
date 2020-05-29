package synchronizedThreads.port;

public class ShipThread implements Runnable {
    private String name;
    private int boxes;

    public ShipThread(String name, int boxes) {
        this.name = name;
        this.boxes = boxes;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        while (boxes > 0) {
            System.out.println(name + ": unload have been started.");
            for (int i = 0; i < boxes; i++) {
                System.out.println(name + ": " + (boxes-i) + " boxes left...");
                try {
                    thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name + ": finished unloading.");
            this.boxes = 0;
        }
    }
}
