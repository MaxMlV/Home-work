package collectionsLecture.tenMinusTwo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void createList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        list.remove(0);
        list.remove(0);
        int lastNum = list.size()-1;
        list.remove(lastNum);
        System.out.println(list);
    }

    public static void main(String[] args) {
        createList();
    }
}
