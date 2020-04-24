package exceptions.model;

public class Student extends Human {
    private int grade;

    public Student(String firstName, String lastName, int age, String gender, int gradePointAverage) {
        super(firstName, lastName, age, gender);
        this.grade = gradePointAverage;
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
        return super.getInfo() + "    grade: " + getGrade();
    }
}
