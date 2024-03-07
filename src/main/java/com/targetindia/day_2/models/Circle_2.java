package com.targetindia.day_2.models;

public class Circle_2 extends Shape {
    private double PI = 3.141567;
    private double radius = 1.0;

    public Circle_2() {
    }

    public Circle_2(double radius) {
        this.radius = radius;
    }

    public Circle_2(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle[" + super.toString() + ", radius=" + radius + "]";
    }
}
