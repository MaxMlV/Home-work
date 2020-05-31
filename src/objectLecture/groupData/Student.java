package objectLecture.groupData;

import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private int group;

    public Student(String firstName, String lastName, int age, int group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return lastName + "  " + firstName + "   age: " + age;
    }
}
