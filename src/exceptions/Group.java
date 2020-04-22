package exceptions;

public class Group extends Student {
    private Student[] students = new Student[10];

    public Group(String firstName, String lastName, int age, int grade, Student[] students) {
        super(firstName, lastName, age, grade);
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

    public void insert(Student student, int place) throws GroupOutOfBoundsException {
        try {
            if (place > students.length) {
                throw new GroupOutOfBoundsException("Group is full.");
            }
            if (students[place - 1] == null) {
                students[place - 1] = student;
            } else {
                System.out.println("full.");
            }
        } catch (GroupOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (student == students[i]) {
                students[i] = null;
                break;
            }
        }
    }

    public String findStudent(String lastName) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getLastName().equals(lastName) && students[i] != null) {
                return "Student found ---> " + students[i].getInfo();
            }
        }
        return "Student not found.";
    }

    public void sortByLastName() {
        int j;
        for (int i = 1; i < students.length; i++) {
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
            stringBuilder.append(student.getInfo() + "\n");
        }
        return stringBuilder.toString();
    }
}
