package filesLecture.saveArray;

import java.io.*;

public class SaveArray {

    public static void saveArray(String text, File file) {
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String fromArrayToString(int[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] rows : array) {
            for (int col : rows) {
                stringBuilder.append(String.format("%-6.6s\t", "" + col));
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        int[][] numbers = new int[6][6];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                numbers[i][j] = j+1;
            }
        }
        File file = new File("src/filesLecture/saveArray/saveArray.txt");
        saveArray(fromArrayToString(numbers), file);
    }
}
