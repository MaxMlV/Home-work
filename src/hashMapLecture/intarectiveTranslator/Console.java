package hashMapLecture.intarectiveTranslator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class Console {
    private Scanner scanner;
    private Dictionary dictionary;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.dictionary = new Dictionary();
    }

    public int menu() {
        System.out.println("-----DICTIONARY-----\n");
        System.out.println("<1> Add new word.");
        System.out.println("<2> Show all words.");
        System.out.println("<3> Save your dictionary.\n");
        System.out.println("<0> Exit.");

        int choice = readInt(0, 3, "Invalid value!");
        return choice;
    }

    public void start() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                case 1:
                    addNewWord();
                    break;
                case 2:
                    showAll();
                    break;
                case 3:
                    saveDictionary();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private String readEngString() {
        String name;
        while (true) {
            try {
                name = scanner.nextLine();
                if (name.matches("[A-Za-z]+")) {
                    break;
                } else {
                    throw new IOException();
                }
            } catch (Exception e) {
                System.out.println("\t <Name> must contain letters from english alphabet.");
            }
        }
        return name;
    }

    private String readUaString() {
        String name;
        while (true) {
            try {
                name = scanner.nextLine();
                if (name.matches("[А-ЩЬЮЯҐЄІЇа-щьюяґєії']+")) {
                    break;
                } else {
                    throw new IOException();
                }
            } catch (Exception e) {
                System.out.println("\t <Name> must contain letters from ukrainian alphabet.");
            }
        }
        return name;
    }

    private int readInt(int min, int max, String errorText) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    break;
                }
                throw new IOException();
            } catch (Exception e) {
                System.err.println(errorText);
            }
        }
        return choice;
    }

    private void addNewWord() {
        System.out.println("\t Enter a new word for your dictionary.");
        String eng = readEngString();
        System.out.println("\t Enter translation of this word.");
        String ua = readUaString();
        this.dictionary.addWord(eng, ua);
        System.out.println("\t Word successfully added!\n");
    }

    private void showAll() {
        System.out.println("-----DICTIONARY (ENG/UA)-----\n");
        Map<String, String> dictionary = this.dictionary.getDictionary();
        dictionary.forEach((key, value) -> System.out.println("\t" + key + " - " + value));
        System.out.println();
    }

    private void saveDictionary() {
        File file = new File("dictionary.txt");
        this.dictionary.saveToFile(file);
        System.out.println("\t Dictionary successfully saved.\n");
    }
}
