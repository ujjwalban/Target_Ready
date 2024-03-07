package com.targetindia.day_2.programs;

import com.targetindia.day_2.models.Circle;
import com.targetindia.day_2.models.Cylinder;
public class assignment_1 {
    public static void main(String[] args)
    {
        Circle[] circles= {new Cylinder(12.34),new Cylinder(12.34,10.0),
        new Cylinder(12.34,10.0,"blue")};

        System.out.println("Cylinder 1" +" Area = " + circles[0].getArea() + " Volume = "  + ((Cylinder) circles[0]).getVolume() + " Color = " + circles[0].getColor());
        System.out.println("Cylinder 2" +" Area = " + circles[1].getArea() + " Volume = "  + ((Cylinder) circles[1]).getVolume() + " Color = " + circles[1].getColor());
        System.out.println("Cylinder 3" +" Area = " + circles[2].getArea() + " Volume = "  + ((Cylinder) circles[2]).getVolume() + " Color = " + circles[2].getColor());
    }
}
