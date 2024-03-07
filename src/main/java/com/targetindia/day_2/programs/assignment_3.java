package com.targetindia.day_2.programs;

import com.targetindia.day_2.models.Shape;
import com.targetindia.day_2.models.Circle_2;
import com.targetindia.day_2.models.Rectangle;
import com.targetindia.day_2.models.Square;


public class assignment_3 {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle_2(1, "blue", true),
                new Circle_2(2, "plain", false),
                new Circle_2(3, "black", true),
                new Rectangle(10, 11),
                new Rectangle(11, 12, "purple", true),
                new Rectangle(12, 13, "plain", false),
                new Square(20),
                new Square(10, "plain", false),
                new Square(11, "orange", true)};

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
        }
    }

}
