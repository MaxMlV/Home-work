package imputOutputStream.duplicateTextFile;

import java.io.*;

public class FileOperations {
    public String[] readFile(File file) {
        String text = "";
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                text += line + " ";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] strArray = text.split(" ");
        return strArray;
    }

    public String[] duplicateWords(String[] arrayOne, String[] arrayTwo) {
        String duplicateText = "";
        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                if (arrayOne[i].equals(arrayTwo[j])) {
                    duplicateText += arrayOne[i] + " ";
                    break;
                }
            }
        }
        String[] duplicateArray = duplicateText.split(" ");
        return duplicateArray;
    }

    public void writeIntoFile(String[] strArray) {
        File file = new File("duplicateWords.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String word : strArray) {
                writer.write(word + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
