package inheritance;

import utilPackages.piNumber.PiNumber;

public class Main {
    public static void main(String[] args) {
        Point pointA = new Point(1, 4);
        Point pointB = new Point(5,4);
        Point pointC = new Point(6, 2);
        Point pointD = new Point(3, 3);
        Triangle triangle = new Triangle(pointA, pointB, pointC);
        Rectangle rectangle = new Rectangle(pointA, pointB, pointC, pointD);
        Circle circle = new Circle(pointA, pointB);

        Board board = new Board();
        board.insert(1, triangle);
        board.insert(3, rectangle);
        board.insert(4, circle);
        board.insert(2, rectangle);

        board.shapeInfo();

        System.out.println();
        board.delete(2);
        board.shapeInfo();
    }
}
