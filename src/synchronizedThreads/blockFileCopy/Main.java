package synchronizedThreads.blockFileCopy;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        Action action = new Action();

        File inputFile = new File("C:\\Development\\folderToCopy\\One.txt");
        File outputFolder = new File(inputFile.getName());

        InputThread inputThread = new InputThread(action, inputFile);
        OutputThread outputThread = new OutputThread(action, outputFolder);

        Thread input = new Thread(inputThread);
        Thread output = new Thread(outputThread);

        input.start();
        output.start();

        System.out.println("Stared copy file: " + inputFile.getName());
    }
}
