package multithreads.folderViewer;

import java.io.File;
import java.text.SimpleDateFormat;

public class WatcherThread implements Runnable {
    private File folder;

    public WatcherThread(File folder) {
        this.folder = folder;

    }

    public File getFolder() {
        return folder;
    }

    private String outView() {
        if (folder == null) {
            System.out.println("Nothing in there.");
        }
        StringBuilder stringBuilder = new StringBuilder();
        File[] folderFiles = folder.listFiles();
        for (File file :
                folderFiles) {
            stringBuilder.append(file.getName() + " - " + file.length()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private int folderCount() {
        File[] folderFiles = folder.listFiles();
        if (folderFiles != null) {
            return folderFiles.length;
        }
        return 0;
    }

    @Override
    public void run() {
        int startCount = folderCount();
        Thread thread = Thread.currentThread();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d MMMM yyyy\tHH:mm:ss");
        while (!(thread.isInterrupted())) {
            System.out.println();
            System.out.println(simpleDateFormat.format(System.currentTimeMillis()));
            System.out.println();
            System.out.println(outView());
            int currentCount = folderCount();
            if (currentCount > startCount) {
                System.out.println("File or folder has been added!");
                startCount += currentCount - startCount;
            } else if (currentCount < startCount) {
                System.out.println("File or folder has been removed!");
                startCount -= startCount - currentCount;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
