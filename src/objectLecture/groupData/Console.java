package objectLecture.groupData;

import java.io.*;
import java.util.Scanner;

public class Console {
    private Scanner scanner;
    private Faculty faculty;

    public Console() {
        super();
        this.scanner = new Scanner(System.in);
        this.faculty = new Faculty();
    }

    private int mainMenu() {

        System.out.println("\n------STUDENTS DATA BASE------\n");
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
        System.out.println("\t Data has been loaded from file!");
    }

    private void saveData() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("facultyData.dat"))) {
            output.writeObject(this.faculty);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("\t Data has been saved!");
    }

    private void showList() {
        for (int i = 0; i < this.faculty.getGroups().length; i++) {
            System.out.println("  GROUP №" + (i + 1) + "\n");
            if (this.faculty.getGroups()[i] != null) {
                for (int j = 0; j < this.faculty.getGroups()[i].getStudents().length; j++) {
                    Student student = this.faculty.getGroups()[i].getStudents()[j];
                    if (student != null) {
                    System.out.println("\t " + (j + 1) + ". " + student.getLastName() + " " + student.getFirstName() + "   age: " + student.getAge());
                    }
                }
                System.out.println();
            }
        }
    }

    private void addStudent() {
        System.out.println("\t Enter number of group.");
        int group = readInt(1, 5, "Invalid value!");
        System.out.println("\t Enter student's first name.");
        String firstName = readString();
        System.out.println("\t Enter student's last name.");
        String lastName = readString();
        System.out.println("\t Enter student's age.");
        int age = readInt(17, 99, "Invalid value!");
        Student student = new Student(firstName, lastName, age, group);
        this.faculty.addToGroup(group-1, student);
        System.out.println("\t Student successfully added in " + group + " group!");
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
