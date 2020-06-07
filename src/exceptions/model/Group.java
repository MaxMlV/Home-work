package exceptions.model;

import java.io.*;
import java.util.*;

public class Group implements RecruitmentOffice {
    private List<Student> students;

    public Group() {
        super();
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    public void insert(Student student) {
        try {
            if (count() < 10) {
                this.students.add(student);
            } else {
                throw new GroupOutOfBoundsException("Group is full.");
            }
        } catch (GroupOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String lastName) {
        for (Student s : this.students) {
            if (s.getLastName().equals(lastName)) {
                this.students.remove(s);
            }
        }
    }

    public Student findStudent(String lastName) {
        for (Student s : this.students) {
            if (s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }

    public int count() {
        return this.students.size();
    }

    public void sortByLastName() {
        this.students.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
    }

    public void sortByAge() {
        this.students.sort((o1, o2) -> o1.getAge() - o2.getAge());
    }

    public void sortByGrade() {
        this.students.sort((o1, o2) -> o1.getGrade() - o2.getGrade());
    }

    @Override
    public List<Student> militaryAgeMan() {
        List<Student> military = new ArrayList<>();
        for (Student s : students) {
            if (s.getGender().equals("Male") && s.getAge() > 18) {
                military.add(s);
            }
        }
        return military;
    }

    public void writeStudentsInto(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Student student : students) {
                if (student != null) {
                    writer.println(student.getFirstName() + "," + student.getLastName() + "," + student.getAge() + ","
                            + student.getGender() + "," + student.getGrade());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readSaved(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String[] studentStr = line.split(",");
                if (studentStr.length == 5) {
                    Student student = new Student();
                    student.setFirstName(studentStr[0]);
                    student.setLastName(studentStr[1]);
                    student.setAge(Integer.parseInt(studentStr[2]));
                    student.setGender(studentStr[3]);
                    student.setGrade(Integer.parseInt(studentStr[4]));
                    insert(student);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            return "\t Invalid data!";
        }
        return "\t Saved data has loaded.";
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            if (student != null) {
                stringBuilder.append("\t" + student.getInfo() + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
