package multithreadingOne.folderMultiCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyThread implements Runnable {
    private File in;
    private File out;

    public CopyThread(File in, File out) {
        this.in = in;
        this.out = out;
    }

    public File getIn() {
        return in;
    }

    public File getOut() {
        return out;
    }

    private void fileCopy() throws IOException {
        if (in != null) {
            FileInputStream inputStream = new FileInputStream(in);
            FileOutputStream outputStream = new FileOutputStream(out.getAbsolutePath() + File.separator + in.getName());
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                outputStream.write(b);
            }
            inputStream.close();
            outputStream.close();
        }
    }

    @Override
    public void run() {
        try {
            fileCopy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
