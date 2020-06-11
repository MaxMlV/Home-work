package hashMapLecture.practice;

import java.util.*;

public class Main {

    public static Map<Object, Integer> generateMap(List<Object> objects) {
        Map<Object, Integer> num = new HashMap<>();
        for (int i = 0; i < objects.size(); i++) {

        }
        return num;
    }

    public List<Object> uniqueObjects(List<Object> objects) {
        List<Object> uniqueObjects = new ArrayList<>();
        for (int i = 0; i < objects.size(); i++) {
            
        }
    }

    public static void main(String[] args) {
        List<Object> objects = new ArrayList<>();
        objects.add(new Human("Max", 21));
        objects.add(new Student("Anton", 21, 10));
        objects.add(new Student("Jack", 29, 8));
        objects.add(new Worker("Igor", 21, "Military"));
        objects.add(new Worker("Alexander", 38, "Teacher"));

        Map<Object, Integer> num = generateMap();

        for (Object object : objects) {
            int count = num.get(object);
            num.put(object, count+1);
        }

        System.out.println(objects);
        System.out.println(num);
    }
}
