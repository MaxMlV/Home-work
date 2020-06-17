package network.practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class InternetAddressCheck {
    private Map<String, String> result = new HashMap<>();

    public InternetAddressCheck(Map<String, String> result) {
        this.result = result;
    }

    public InternetAddressCheck() {
        super();
    }

    public Map<String, String> getResult() {
        return result;
    }

    public void setResult(Map<String, String> result) {
        this.result = result;
    }

    public void loadLinksFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String link = "";
            while ((link = reader.readLine()) != null) {
                if (!result.containsKey(link)) {
                    result.put(link, checkURL(link));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String checkURL(String urlAddress) {
        try {
            URL url = new URL(urlAddress);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int response = connection.getResponseCode();
            if (response >= 200 && response < 300) {
                return " - is OK.";
            } else {
                return " is not OK. (" + connection.getResponseMessage() + ")";
            }
        } catch (IOException e) {
            return " - is not registered!";
        }
    }
}
