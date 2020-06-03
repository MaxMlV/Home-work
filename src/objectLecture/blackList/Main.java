package objectLecture.blackList;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        BlackList blackList = new BlackList(new Object[10]);
        Stack stack = new Stack(new Object[10]);

        Square square = new Square(3);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(1,1,2);

        System.out.println(stack.addObject(square.getClass(), blackList));
        System.out.println(stack.addObject(circle.getClass(), blackList));

        System.out.println(stack.topOfStack());

        System.out.println(stack.deleteObject());
    }
}
