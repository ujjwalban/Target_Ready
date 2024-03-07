package com.targetindia.day_2.models;

public class Cylinder extends Circle{
    private double height = 1.0;
    public Cylinder(double radius) {
       super(radius);
    }
    public Cylinder(double radius,double height) {
        super(radius);
        this.height = height;
    }
    public Cylinder(double radius,double height,String color){
        setRadius(radius);
        this.height = height;
        setColor(color);
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getVolume(){
        return PI*getRadius()*getRadius()*height;
    }


}
