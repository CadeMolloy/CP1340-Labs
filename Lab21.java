//CP1340 Lab 2 - Classes and Objects I
//Student: Cade Molloy - 20175269
//Due Date: October 11th, 2022
//Prof: Branko Cirovic

public class Lab21 {
    public static void main (String[] args) {
        Circle obj1 = new Circle();
        System.out.println(obj1.toString());
        System.out.println("Area: "+obj1.area());
        System.out.println("Circumference: "+obj1.circumference());

        Circle obj2 = new Circle(10);
        System.out.println(obj2.toString());
        System.out.println("Area: "+obj2.area());
        System.out.println("Circumference: "+obj2.circumference());

        Circle obj3 = new Circle(new Point(7,8));
        System.out.println(obj3.toString());
        System.out.println("Area: "+obj3.area());
        System.out.println("Circumference: "+obj3.circumference());

        Circle obj4 = new Circle(30,new Point(10,11));
        System.out.println(obj4.toString());
        System.out.println("Area: "+obj4.area());
        System.out.println("Circumference: "+obj4.circumference());
    }
}

class Point {
    private int x;
    private int y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return ("("+x+" "+y+")");
    }
}

class Circle {
    private int radius;
    private Point center;

    public Circle() {
        radius = 1;
        center = new Point();
    }

    public Circle(int radius) {
        this.radius = radius;
        center = new Point();
    }

    public Circle(Point center) {
        radius = 1;
        this.center = center;
    }

    public Circle(int radius,Point center) {
        this.radius = radius;
        this.center = center;
    }

    public double area() {
        return 3.14*radius*radius;
    }

    public double circumference() {
        return 2*3.14*radius;
    }

    public String toString() {
        return "Radius: "+radius+"\tCenter: "+center.toString();
    }
}