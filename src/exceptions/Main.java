package exceptions;

public class Main {
    public static void main(String[] args) throws GroupOutOfBoundsException {
        Student studentOne = new Student("Max", "Maleev", 21, 4);
        Student studentTwo = new Student("Anton", "Aleksandrov", 20, 3);
        Student studentThree = new Student("Amirah", "Stark", 23, 5);
        Student studentFour = new Student("Calvin", "Gill", 30, 2);
        Student studentFive = new Student("Lane", "Webb", 20, 2);
        Student studentSix = new Student("Rory", "Kane", 25, 4);
        Student studentSeven = new Student("Santiago", "Villa", 26, 4);
        Student studentEight = new Student("Dorian", "Yates", 20, 4);
        Student studentNine = new Student("Kimora", "Shea", 21, 7);
        Student studentTen = new Student("Jairo", "Maxwell", 21, 6);
        Group group = new Group();
        group.insert(studentOne, 1);
        group.insert(studentTwo, 2);
        group.insert(studentThree,3);
        group.insert(studentFour,4);
        group.insert(studentFive,5);
        group.insert(studentSix,6);
        group.insert(studentSeven, 7);
        group.insert(studentEight,8);
        group.insert(studentNine,9);
        group.insert(studentTen,10);
        System.out.println(group.toString());
    }
}
