package interfaceLecture;

public class Main {
    public static void main(String[] args) {
        Dog dogOne = new Dog("Charlie");
        Dog dogTwo = new Dog("Grimm");
        Cat cat = new Cat("Cat", 5, "White");
        Ball ball = new Ball(13, "Yellow");

        dogOne.bite(cat);
        dogOne.bite(dogOne);
        dogOne.bite(ball);
        dogOne.bite(dogTwo);
    }
}
