package collectionsLecture.theBigBangClones;

import java.util.ArrayDeque;

public class Main {

    public static void drinkCola(ArrayDeque<Scientist> scientists) {
        int count = 2;
        while (count > 0) {
            scientists.addLast(scientists.getFirst());
            count--;
        }
        scientists.removeFirst();
    }

    public static void main(String[] args) {
        ArrayDeque<Scientist> scientists = new ArrayDeque<>();

        scientists.add(new Scientist("Sheldon"));
        scientists.add(new Scientist("Leonard"));
        scientists.add(new Scientist("Howard"));
        scientists.add(new Scientist("Raj"));

        for (Scientist s :
                scientists) {
            System.out.print(s.getName() + ", ");
        }
        System.out.println();

        drinkCola(scientists);
        drinkCola(scientists);

        for (Scientist s : scientists) {
            System.out.print(s.getName() + ", ");
        }
        System.out.println();

    }
}
