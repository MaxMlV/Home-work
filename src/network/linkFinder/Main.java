package network.linkFinder;

import java.io.File;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LinkBucket linkBucket = new LinkBucket("https://prog.kiev.ua/forum/index.php");
        File file = new File("C:\\Development\\folderToCopy\\Links.txt");

        ArrayList<String> links = linkBucket.getHTMLFromURL();
        links = linkBucket.leaveOnlyLinks();

        linkBucket.saveToFile(file, links);
    }
}
