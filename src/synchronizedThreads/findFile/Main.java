package synchronizedThreads.findFile;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        String searchFileName = "LookingFor.txt";
        String message = "File was found: ";
        File fileSystem = new File("C:\\");
        File[] directories = fileSystem.listFiles();

//        for (File fileInSystem : directories) {
//            if (fileInSystem.getName().equals(searchFileName)) {
//                System.out.println(message + fileInSystem.getAbsolutePath());
//                break;
//            } else if (fileInSystem.isDirectory()) {
//                Thread thread = new Thread(new SearchThread(fileInSystem, searchFileName));
//                thread.start();
//            }
//        }
        for (int i = 0; i < directories.length; i++) {
            if (directories[i].isDirectory()) {
                Thread thread = new Thread(new SearchThread(fileSystem, searchFileName));
                thread.start();
            } else if (directories[i].getName().equals(searchFileName)) {
                System.out.println(message + directories[i].getAbsolutePath());
                break;
            }
        }
    }
}
