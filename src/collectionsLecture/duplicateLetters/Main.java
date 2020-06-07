package collectionsLecture.duplicateLetters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static char[] getChars(String text) {
        String str = text.replaceAll("[^A-Za-z]+", "");
        return str.toCharArray();
    }

    public static List<List<Character>> getListOfChars(char[] letters) {
        List<List<Character>> listOfCharLists = new ArrayList<>();
        for (int i = 0; i < letters.length; i++) {
            List<Character> letter = new ArrayList<>();
            for (int j = 0; j < letters.length; j++) {
                if (letters[i] == letters[j]) {
                    letter.add(letters[j]);
                }
            }
            listOfCharLists.add(letter);
        }
        return removeDuplicates(listOfCharLists);
    }

    public static List<List<Character>> removeDuplicates(List<List<Character>> listOfLetterLists) {
        for (int i = 0; i < listOfLetterLists.size(); i++) {
            for (int j = 0; j < listOfLetterLists.size(); j++) {
                if (j != i && listOfLetterLists.get(i).get(0) == listOfLetterLists.get(j).get(0)) {
                    listOfLetterLists.remove(listOfLetterLists.get(j));
                }
            }
        }
        return listOfLetterLists;
    }

    public static String getText(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        File file = new File("C:\\Development\\folderToCopy\\Two.txt");
        String text = getText(file);

        System.out.println(text);
        System.out.println();

        char[] letters = getChars(text);

        List<List<Character>> listOfLetterLists;
        listOfLetterLists = getListOfChars(letters);

        listOfLetterLists.sort(new Comparator<List<Character>>() {
            @Override
            public int compare(List<Character> o1, List<Character> o2) {
                return o2.size() - o1.size();
            }
        });

        for (List<Character> letter : listOfLetterLists) {
            System.out.println(letter + "  <-- " + letter.size());
        }

    }
}
