package multithreads.folderMultiCopy;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File inFolder = new File("C:\\Development\\folderToCopy");
        File outFolder = new File(inFolder.getName());
        outFolder.mkdirs();

        File[] inFiles = inFolder.listFiles();

        for (int i = 0; i < inFiles.length; i++) {
            Thread thread = new Thread(new CopyThread(inFiles[i], outFolder));
            thread.start();
        }
    }
}
