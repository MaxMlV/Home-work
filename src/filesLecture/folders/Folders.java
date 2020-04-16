package filesLecture.folders;

import java.io.File;

public class Folders {

    public static void foldersOutput(File folder) {
        File[] folders = folder.listFiles();
        for (File folderElem : folders) {
            if (!folderElem.isFile()) {
                System.out.println(folderElem.getName());
            }
        }
    }

    public static void main(String[] args) {
        File folder = new File("src/filesLecture/folders");
        foldersOutput(folder);
    }
}
