package network.practice;

import java.io.File;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        InternetAddressCheck internetAddressCheck = new InternetAddressCheck();
        File file = new File("C:\\Development\\folderToCopy\\Links.txt");

        internetAddressCheck.loadLinksFromFile(file);
        Map<String, String> result = internetAddressCheck.getResult();

        result.forEach((key, value) -> System.out.println(key + value));
    }
}
