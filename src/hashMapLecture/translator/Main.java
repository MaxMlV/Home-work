package hashMapLecture.translator;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static String[] readFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String string = bufferedReader.readLine();
            return string.split(",");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveTranslation(File file, Map<String, String> hashMap, String word) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(hashMap.get(word));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File english = new File("C:\\Development\\Translate\\English.in.txt");
        File ukrainian = new File("C:\\Development\\Translate\\Ukraine.out.txt");
        String[] engWords = readFile(english);

        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("Hello", "Привіт");
        dictionary.put("World", "Мир");

        String word = engWords[1];

        saveTranslation(ukrainian, dictionary, word);
    }
}
