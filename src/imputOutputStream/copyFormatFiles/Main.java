package imputOutputStream.copyFormatFiles;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File in = new File("C:\\Development\\Java\\FruitStoreApp\\src\\model");
        File out = new File(".");
        FileOperation fileOperation = new FileOperation("java");
        try {
            fileOperation.fileCopy(in, out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
