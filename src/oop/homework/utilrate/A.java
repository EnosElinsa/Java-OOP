package oop.homework.utilrate;

public class A extends Shape2D {
    private double width;
    private double height;
    
    public A() {
        this.width = 0;
        this.height = 0;
    }

    public A(double width, double height) {
        this.width = width;
        this.height = height;
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

    @Override
    public double getArea() {
        return width * height;
    }
}
