package inheritance;

public class Rectangle extends Shape {
    private Point a = new Point();
    private Point b = new Point();
    private Point c = new Point();
    private Point d = new Point();

    public Rectangle(Point a, Point b, Point c, Point d) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Rectangle() {
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

    public Point getD() {
        return d;
    }

    public void setD(Point d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                '}';
    }

    @Override
    double getPerimeter() {
        return a.distance(a, b) + b.distance(b, c) + c.distance(c, d) + d.distance(a, d);
    }

    @Override
    double getArea() {
        return a.distance(a, b) * b.distance(b, c);
    }
}
