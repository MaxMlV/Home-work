package imputOutputStream.duplicateTextFile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileOne = new File("C:\\Development\\New folder\\One.txt");
        File fileTwo = new File("C:\\Development\\New folder\\Two.txt");

        FileOperations fileOperation = new FileOperations();

        String[] duplicate = fileOperation.duplicateWords(fileOperation.readFile(fileOne), fileOperation.readFile(fileTwo));

        fileOperation.writeIntoFile(duplicate);
    }
}
