package inheritance;

public class Triangle extends Shape {
    private Point a = new Point();
    private Point b = new Point();
    private Point c = new Point();

    public Triangle(Point a, Point b, Point c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle() {
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

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + a +
                ", sideB=" + b +
                ", sideC=" + c +
                '}';
    }

    @Override
    double getPerimeter() {
        return a.distance(a, b) + b.distance(b, c) + c.distance(a, c);
    }

    @Override
    double getArea() {
        double p = (a.distance(a, b) + b.distance(b, c) + c.distance(a, c)) / 2;
        return Math.sqrt(p * (p - a.distance(a, b)) * (p - b.distance(b, c)) * (p - c.distance(a, c)));
    }
}
