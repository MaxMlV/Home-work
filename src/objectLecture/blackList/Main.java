package objectLecture.blackList;

public class Main {

    public static void main(String[] args) {
        BlackList blackList = new BlackList(new Object[10]);
        Stack stack = new Stack(new Object[10]);

        Square square = new Square(3);
        Circle circle = new Circle(10);
        Triangle triangle = new Triangle(1,1,2);

        stack.addObject(square, blackList);
        stack.addObject(circle, blackList);

        for (Object obj :
                stack.getObjects()) {
            System.out.print(obj + ",  ");
        }

        System.out.println();

        System.out.println(stack.topOfStack() + " <-- on top!");

        stack.deleteObject();

        System.out.println(stack.topOfStack() + " <-- on top!");

        blackList.add(triangle);

        stack.addObject(triangle, blackList);

        System.out.println(stack.topOfStack() + " <-- on top!");
    }
}
