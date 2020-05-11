package multithreads.folderViewer;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File folder = new File(".");
        Thread thread = new Thread(new WatcherThread(folder));
        thread.start();
    }
}
