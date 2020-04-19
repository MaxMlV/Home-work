package oopIntro.cat;

public class Cat {
    private String name;
    private int age;
    private double weight;

    public Cat(String name, int age, double weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public Cat() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
