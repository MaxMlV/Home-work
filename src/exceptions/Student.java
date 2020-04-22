package exceptions;

public class Student extends Human {
    private int grade;

    public Student(String firstName, String lastName, int age, int grade) {
        super(firstName, lastName, age);
        this.grade = grade;
    }

    public Student() {
        super();
    }
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " grade: " + getGrade();
    }
}
