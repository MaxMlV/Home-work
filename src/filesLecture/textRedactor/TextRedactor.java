package filesLecture.textRedactor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TextRedactor {

    public static void createFile(String name) {
        File newFile = new File("textRedactor");
        try
        {
            boolean created = newFile.createNewFile();
            newFile.renameTo(new File(name + ".txt"));
            if(created)
                System.out.println("File has been created.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void saveText(String name, String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(name + ".txt"))) {
            writer.write(text);
            System.out.println("Text have been added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file name.");
        String name = scanner.nextLine();
        createFile(name);
        System.out.println("Now you can add some text in your file.");
        String text = scanner.nextLine();
        saveText(name, text);
    }
}
