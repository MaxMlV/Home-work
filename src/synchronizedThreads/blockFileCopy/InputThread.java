package synchronizedThreads.blockFileCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputThread implements Runnable {
    private Action action;
    private File in;

    public InputThread(Action action, File in) {
        this.action = action;
        this.in = in;
    }

    public File getIn() {
        return in;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        byte[] bytes = new byte[3];
        try (FileInputStream input = new FileInputStream(in)) {
            while (input.read(bytes) > 0) {
                action.setBytes(bytes);
            }
            action.setStop(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
