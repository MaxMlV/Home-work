package hashMapLecture.intarectiveTranslator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> dictionary;

    public Dictionary() {
        this.dictionary = new HashMap<>();
    }

    public Map<String, String> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, String> dictionary) {
        this.dictionary = dictionary;
    }

    public void addWord(String eng, String ua) {
        this.dictionary.put(eng, ua);
    }

    public void saveToFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new PrintWriter(file))) {
            StringBuilder builder = new StringBuilder();
            this.dictionary.forEach((key, value) -> builder.append("\t" + key + " - " + value + "\n"));
            writer.write(builder.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
