package oop.homework.utilrate;

public class B extends Shape2D {
    private double radius;
    
    public B() {
        this.radius = 0;
    }

    public B(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
