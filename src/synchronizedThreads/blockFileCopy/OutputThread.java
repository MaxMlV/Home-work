package synchronizedThreads.blockFileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputThread implements Runnable {
    private Action action;
    private File out;

    public OutputThread(Action action, File out) {
        this.action = action;
        this.out = out;
    }

    public int countOfBytes() {
        int count = 0;
        try (FileInputStream inputStream = new FileInputStream(out)) {
            while (inputStream.read() > 0) {
                count += 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public void run() {
        float count = countOfBytes();
        byte[] bytes = new byte[3];
        float arrSize = bytes.length;
        try (FileOutputStream output = new FileOutputStream(out.getName())) {
            float percentOfCopying = (arrSize / count) * 100;
            float percents = 0;
            while (!action.isStop()) {
                bytes = action.getBytes();
                output.write(bytes, 0, bytes.length);
                System.out.println("Copying... " + percents + "%");
                percents += percentOfCopying;
                Thread.sleep(500);
            }
            System.out.println("File " + out.getName() + " have been copied successful!");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
     }
}
