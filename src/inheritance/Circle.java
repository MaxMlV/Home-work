package inheritance;

public class Circle extends Shape {
    private Point a = new Point();
    private Point b = new Point();

    public Circle(Point a, Point b) {
        super();
        this.a = a;
        this.b = b;
    }

    public Circle() {
        super();
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * a.distance(a, b);
    }

    @Override
    double getArea() {
        return Math.PI * Math.pow(a.distance(a, b), 2);
    }
}
