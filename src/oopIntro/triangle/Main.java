package oopIntro.triangle;

public class Main {
    public static void main(String[] args) {
        Triangle triangleOne = new Triangle(4,5,6);
        System.out.println(triangleOne.toString());
        double areaOfTriangleOne = triangleOne.triangleArea();
        System.out.println("Area of this triangle is: " + areaOfTriangleOne);
        System.out.println();
        Triangle triangleTwo = new Triangle();
        triangleTwo.setSideA(6);
        triangleTwo.setSideB(6);
        triangleTwo.setSideC(4);
        System.out.println(triangleTwo.toString());
        System.out.println("Area of this triangle is: " + triangleTwo.triangleArea());
    }
}
