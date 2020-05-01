package imputOutputStream.copyFormatFiles;

import java.io.*;

public class FileOperation implements FileFilter {
    private String[] formatsArray;

    public FileOperation(String... formatsArray) {
        super();
        this.formatsArray = formatsArray;
    }

    public void fileCopy(File in, File out) throws IOException {
        File[] filesInFolder = in.listFiles();
        if (filesInFolder != null) {
            for (File file : filesInFolder) {
                if (this.accept(file)) {
                    FileInputStream inputStream = new FileInputStream(file);
                    FileOutputStream outputStream = new FileOutputStream(out.getAbsolutePath() + File.separator + file.getName());
                    int b = 0;
                    while ((b = inputStream.read()) != -1) {
                        outputStream.write(b);
                    }
                    inputStream.close();
                    outputStream.close();
                }
            }
        }
    }

    private boolean check(String ext) {
        for (String stringExt : formatsArray) {
            if (stringExt.equals(ext)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean accept(File pathname) {
        int pointerIndex = pathname.getName().lastIndexOf(".");
        if (pointerIndex == -1) {
            return false;
        }
        String ext = pathname.getName().substring(pointerIndex + 1);
        return check(ext);
    }
}
