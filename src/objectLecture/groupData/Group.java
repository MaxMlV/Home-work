package objectLecture.groupData;

import java.io.Serializable;

public class Group implements Serializable {
    private Student[] students = new Student[10];

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

    public void addStudent(Student student) {
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
}
