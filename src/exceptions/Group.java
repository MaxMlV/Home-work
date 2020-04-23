package exceptions;

public class Group {
    private Student[] students = new Student[10];

    public Group(Student[] students) {
        super();
        this.students = students;
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

    public void insert(Student student) throws GroupOutOfBoundsException {
        try {
            for (int i = 0; i < students.length; i++) {
                if (students[students.length-1] != null) {
                    throw new GroupOutOfBoundsException("Group is full.");
                } else if (students[i] == null) {
                    students[i] = student;
                    break;
                }
            }
        } catch (GroupOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (student.equals(students[i])) {
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

    public void sortByLastName() {
        int j;
        for (int i = 1; i < students.length; i++) {
            if (students[i] == null) {
                break;
            }
            Student temp = students[i];
            j = i;
            while (j > 0 && students[j-1].getLastName().compareTo(temp.getLastName()) > 0) {
                students[j] = students[j-1];
                --j;
            }
            students[j] = temp;
        }
    }

    @Override
    public String toString() {
        sortByLastName();
        StringBuilder stringBuilder = new StringBuilder();
        for (Student student : students) {
            if (student != null) {
                stringBuilder.append(student.getInfo() + "\n");
            }
        }
        return stringBuilder.toString();
    }
}
