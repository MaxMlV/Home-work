package exceptions.controller;

import exceptions.model.Student;

import java.util.Arrays;
import java.util.Comparator;

public class Group implements RecruitmentOffice {
    private Student[] students = new Student[10];
    private Student[] militaryAgeStudents = new Student[10];

    public Group(Student[] students, Student[] militaryAgeStudents) {
        super();
        this.students = students;
        this.militaryAgeStudents = militaryAgeStudents;
    }

    public Group() {
        super();
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Student[] getMilitaryAgeStudents() {
        return militaryAgeStudents;
    }

    public void setMilitaryAgeStudents(Student[] militaryAgeStudents) {
        this.militaryAgeStudents = militaryAgeStudents;
    }

    private void checkIfGroupFull() throws GroupOutOfBoundsException {
        if (students[students.length - 1] != null) {
            throw new GroupOutOfBoundsException("Group is full.");
        }
    }

    public void insert(Student student, Student[] students) {
        try {
            checkIfGroupFull();
            for (int i = 0; i < students.length; i++) {
                if (students[i] == null) {
                    students[i] = student;
                    break;
                }
            }
        } catch (GroupOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (lastName.equals(students[i].getLastName())) {
                students[i] = null;
                break;
            }
        }
    }

    public String findStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].getLastName().equals(lastName)) {
                    return "Student found ---> " + students[i].getInfo();
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
    public boolean isMilitaryAgeMan(Student student) {
        if (student.getGender().equals("Male") && student.getAge() > 18) {
            return true;
        }
        return false;
    }

    public void militaryAgeArray() {
        for (Student student : students) {
            if (student != null && isMilitaryAgeMan(student)) {
                insert(student, militaryAgeStudents);
            }
        }
    }

    public void cleanMilitaryArray() {
        for (int i = 0; i < militaryAgeStudents.length; i++) {
            if (militaryAgeStudents[i] != null) {
                militaryAgeStudents[i] = null;
            }
        }
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
