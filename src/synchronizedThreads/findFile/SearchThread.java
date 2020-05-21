package synchronizedThreads.findFile;

import java.io.File;

public class SearchThread implements Runnable {
    private File fileSystem;
    private String searchFileName;

    public SearchThread(File fileSystem, String searchFileName) {
        this.fileSystem = fileSystem;
        this.searchFileName = searchFileName;
    }

    public File getFileSystem() {
        return fileSystem;
    }

    public void setFileSystem(File fileSystem) {
        this.fileSystem = fileSystem;
    }

    public String getSearchFileName() {
        return searchFileName;
    }

    public void setSearchFileName(String searchFileName) {
        this.searchFileName = searchFileName;
    }

    public File getSearchFile(File directory) {
//        if (directory != null) {
//            if (directory.getName().equals(fileName)) {
//                System.out.println(directory.getAbsolutePath());
//            } else {
//                File[] files = directory.listFiles();
//                for (File file : files) {
//                    if (file.isDirectory()) {
//                        getSearchFile(directory);
//                    } else if (file.getName().equals(fileName)) {
//                        System.out.println(directory.getAbsolutePath());
//                    }
//                }
//            }
//        }
        File foundFile = null;
        try {
            for (File fileInDirectory : directory.listFiles()) {
                if (fileInDirectory.getName().equals(searchFileName)) {
                    foundFile = fileInDirectory;
                    break;
                } else if (fileInDirectory.isDirectory()) {
                    foundFile = getSearchFile(fileInDirectory);
                    if (foundFile != null) {
                        return foundFile;
                    }
                }
            }
        } catch (NullPointerException e) {
        } finally {
            return foundFile;
        }
    }

    @Override
    public void run() {
        File res = getSearchFile(fileSystem);
        if (res != null) {
            System.out.println("File was found: " + res.getAbsolutePath());
        }
    }
}
