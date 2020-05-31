package objectLecture.groupData;

import java.io.*;
import java.util.Scanner;

public class Console {
    private Scanner scanner = new Scanner(System.in);
    private Faculty faculty;

    private int mainMenu() {
        System.out.println("------STUDENTS DATA BASE------\n");
        System.out.println("\t <1> Add student.");
        System.out.println("\t <2> Show list.");
        System.out.println("\t <3> Save faculty list.");
        System.out.println("\t <4> Load saved data.\n");
        System.out.println("\t <0> Exit.");

        int choice = readInt(0, 4, "Invalid value!");
        return choice;
    }

    public void start() {
        while (true) {
            int choice = mainMenu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addStudent();
                    break;
                case 2:
                    showList();
                    break;
                case 3:
                    saveData();
                    break;
                case 4:
                    loadData();
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

    private void loadData() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("facultyData.dat"))) {
            this.faculty = (Faculty) input.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("facultyData.dat"))) {
            output.writeObject(this.faculty);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showList() {
        for (int i = 0; i < this.faculty.getGroups().length; i++) {
            System.out.println("  GROUP №" + i + 1);
            for (int j = 0; j < this.faculty.getGroups()[i].getStudents().length; j++) {
                Student[] group = this.faculty.getGroups()[i].getStudents();
                while (group[j] != null) {
                    System.out.println("\t " + j + 1 + ". " + group[j].toString());
                }
                break;
            }
        }
    }

    private void addStudent() {
        System.out.println("\t Enter number of group.");
        int group = readInt(1, 10, "Invalid value!");
        System.out.println("\t Enter student's first name.");
        String firstName = readString();
        System.out.println("\t Enter student's last name.");
        String lastName = readString();
        System.out.println("\t Enter student's age.");
        int age = readInt(17, 99, "Invalid value!");
        Student student = new Student(firstName, lastName, age, group);
        faculty.addToGroup(group, student);
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

    private String readString() {
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
                System.out.println("\t <Name> must contain letters from latin alphabet.");
            }
        }
        return name;
    }
}
