package com.targetindia.day_2.models;

public class Circle {
    public double PI = 3.141567;
    private double radius = 1.0;
    private String color = "red";
    public Circle() {}
    public Circle(double radius){
        this.radius = radius;
    }
    public Circle(double radius,String color)
    {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea()
    {
       return PI*radius*radius;
    }
    @Override
    public String toString() {
        return "Circle[" + "radius  =" + radius + ",color =" + color  +"]";
    }

}
