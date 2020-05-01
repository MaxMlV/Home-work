package exceptions.view;

import exceptions.model.Group;
import exceptions.model.Student;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    private Group group;
    private Scanner scanner;

    public Console() {
        super();
        this.group = new Group();
        this.scanner = new Scanner(System.in);
    }

    private int menu() {
        System.out.println();
        System.out.println("------ GROUP MANAGEMENT MENU ------");
        System.out.println();
        System.out.println("<1> Add new student.");
        System.out.println("<2> Show group list.");
        System.out.println("<3> Remove student.");
        System.out.println("<4> Sort group list.");
        System.out.println("<5> Show list of military age students.");
        System.out.println("<6> Search student.");
        System.out.println("<7> Save group.");
        System.out.println("<8> Load group.");
        System.out.println();
        System.out.println("<0> Exit.");

        int choice = readInt(0, 8, "\t Invalid option!");
        return choice;
    }

    public void start() {
        while (true) {
            int choice = menu();
            switch (choice) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    showGroupList();
                    break;
                case 3:
                    removeStudent();
                    break;
                case 4:
                    sortMenu();
                    break;
                case 5:
                    showMilitaryAgeStudents();
                    break;
                case 6:
                    studentSearch();
                    break;
                case 7:
                    System.out.println(saveGroup());
                    break;
                case 8:
                    System.out.println(loadSave());
                    break;
                default:
                    throw new AssertionError();
            }
        }
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

    private void addNewStudent() {
        System.out.println("\t Enter first name of student.");
        String firstName = readString();
        System.out.println("\t Enter last name of student.");
        String lastName = readString();
        System.out.println("\t Enter age of student.");
        int age = readInt(1, Integer.MAX_VALUE, "\tInvalid value! Enter positive <int> number.");
        String gender = genderChoice();
        int gradePointAverage = calculateGrade();
        Student student = new Student(firstName, lastName, age, gender, gradePointAverage);
        group.insert(student);
        System.out.println("\t Student have been added to group!");
    }

    private String genderChoice() {
        System.out.println("\t Choose gender of student.");
        System.out.println();
        System.out.println("<1> Male");
        System.out.println("<2> Female");

        int choice = readInt(1, 2, "\t Invalid option!");
        switch (choice) {
            case 1:
                return "Male";
            case 2:
                return "Female";
            default:
                throw new AssertionError();
        }
    }

    private int calculateGrade() {
        System.out.println("\t Enter grade of 1st semester.");
        double gradeOne = readInt(1, 12, "\t Invalid value! (0 < 'int' < 13)");
        System.out.println("\t Enter grade of 2nd semester.");
        double gradeTwo = readInt(1, 12, "\t Invalid value! (0 < 'int' < 13)");
        return (int) ((gradeOne + gradeTwo) / 2);
    }

    private void showGroupList() {
        System.out.println("\t\t\t\t\tLIST OF STUDENTS");
        System.out.println();
        System.out.println(group.toString());
    }

    private String enterLast() {
        System.out.println("\t Enter last name of student.");
        String lastName = readString();
        return lastName;
    }

    private void removeStudent() {
        group.delete(enterLast());
    }

    private void studentSearch() {
        System.out.println(group.findStudent(enterLast()));
    }

    private void sortMenu() {
        System.out.println("\t Which sorting parameter you want to use?");
        System.out.println();
        System.out.println("<1> Sort by last name of student.");
        System.out.println("<2> Sort by age of student.");
        System.out.println("<3> Sort by grade point average.");

        int choice = readInt(1, 3, "\t Invalid value!");
        switch (choice) {
            case 1:
                group.sortByLastName();
                System.out.println("\t Sorted by last name!");
                break;
            case 2:
                group.sortByAge();
                System.out.println("\t Sorted by age!");
                break;
            case 3:
                group.sortByGrade();
                System.out.println("\t Sorted by GPA!");
                break;
            default:
                throw new AssertionError();
        }
    }

    private void showMilitaryAgeStudents() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : group.militaryAgeMan()) {
            if (student != null) {
                stringBuilder.append("\t" + student.getInfo() + "\n");
            }
        }
        System.out.println("\t\t\t\tLIST OF MILITARY AGE STUDENTS");
        System.out.println(stringBuilder.toString());
    }

    private String saveGroup() {
        try {
            File file = new File("savedGroup.txt");
            if (!(file.exists())) {
                file.createNewFile();
            }
            group.writeStudentsInto(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "\t Saved!";
    }

    private String loadSave() {
        File file = new File("savedGroup.txt");
        if (!(file.exists())) {
            return "\t Nothing to load!";
        }
        group.readSaved(file);
        return "\t Saved data has loaded.";
    }
}
