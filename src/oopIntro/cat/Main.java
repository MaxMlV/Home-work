package oopIntro.cat;

public class Main {
    public static void main(String[] args) {
        Cat catOne = new Cat();
        catOne.setName("Mr. Fluff");
        catOne.setAge(7);
        catOne.setWeight(10.4);
        System.out.println("It's " + catOne.getName() + ". He is " + catOne.getAge() + " years old.");
        System.out.println("His weight is " + catOne.getWeight() + ", and he still eating.");
        System.out.println();
        Cat catTwo = new Cat("Lisa", 8, 7);
        System.out.println("This is " + catTwo.getName() + ". She is " + catTwo.getAge() + " years old.");
    }
}
