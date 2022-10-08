package oop.homework.utilrate;

import java.util.ArrayList;

public class SteelPlate {
    private double width;
    private double height;
    public SteelPlate(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getUtilizationRate(ArrayList<Shape2D> shapes) {
        double sumOfUtilizedArea = 0;
        for (Shape2D shape : shapes) {
            sumOfUtilizedArea += shape.getArea();
        }
        return sumOfUtilizedArea / this.getArea();
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getArea() {
        return height * width;
    }
}
