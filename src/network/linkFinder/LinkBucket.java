package network.linkFinder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LinkBucket {
    private String urlAddress;

    public LinkBucket(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public LinkBucket() {
        super();
    }

    public ArrayList<String> getHTMLFromURL() {
        ArrayList<String> htmlStr = new ArrayList<>();
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                htmlStr.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return htmlStr;
    }

    public ArrayList<String> leaveOnlyLinks() {
        ArrayList<String> html = getHTMLFromURL();
        ArrayList<String> cleanedHtml = html.stream()
                .filter(str -> str.contains("<a href"))
                .collect(Collectors.toCollection(ArrayList::new));
        return cleanedHtml;
    }

    public void saveToFile(File file, ArrayList<String> list) {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(file))) {
            for (String link : list) {
                writer.write(link + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
