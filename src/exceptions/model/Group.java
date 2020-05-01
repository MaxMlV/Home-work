package exceptions.model;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Group implements RecruitmentOffice {
    private Student[] students = new Student[10];

    public Group() {
        super();
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    private int checkGroupFullness() {
        int count = 0;
        for (Student student : students) {
            if (student == null) {
                count++;
            }
        }
        return count;
    }

    public void insert(Student student) {
        try {
            if (checkGroupFullness() > 0) {
                for (int i = 0; i < students.length; i++) {
                    if (students[i] == null) {
                        students[i] = student;
                        break;
                    }
                }
            } else {
                throw new GroupOutOfBoundsException("Group is full.");
            }
        } catch (GroupOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && lastName.equals(students[i].getLastName())) {
                students[i] = null;
                System.out.println("\t Student have been removed.");
                break;
            } else if (i == students.length - 1) {
                System.out.println("\t Student doesn't exist.");
            }
        }
    }

    public String findStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getLastName().equals(lastName)) {
                    return "  Found  ==>  " + students[i].getInfo();
                }
            }
        }
        return "Student not found.";
    }

    Comparator<Student> byLastName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return o1.getLastName().compareTo(o2.getLastName());
        }
    };

    Comparator<Student> byAge = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return Integer.compare(o2.getAge(), o1.getAge());
        }
    };

    Comparator<Student> byGrade = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if (o1 == null && o2 == null) {
                return 0;
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 == null) {
                return -1;
            }
            return Integer.compare(o2.getGrade(), o1.getGrade());
        }
    };

    public void sortByLastName() {
        Arrays.sort(students, byLastName);
    }

    public void sortByAge() {
        Arrays.sort(students, byAge);
    }

    public void sortByGrade() {
        Arrays.sort(students, byGrade);
    }

    @Override
    public Student[] militaryAgeMan() {
        Student[] military = new Student[10];
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null && students[i].getGender().equals("Male") && students[i].getAge() >= 18) {
                military[i] = students[i];
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
