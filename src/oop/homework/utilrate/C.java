package oop.homework.utilrate;

public class C extends Shape2D {
    private double topBase;
    private double bottomBase;
    private double height;

    public C() {
        this.topBase = 0;
        this.bottomBase = 0;
        this.height = 0;
    }

    public C(double topBase, double bottomBase, double height) {
        this.topBase = topBase;
        this.bottomBase = bottomBase;
        this.height = height;
    }

    public double getTopBase() {
        return topBase;
    }

    public void setTopBase(double topBase) {
        this.topBase = topBase;
    }

    public double getBottomBase() {
        return bottomBase;
    }

    public void setBottomBase(double bottomBase) {
        this.bottomBase = bottomBase;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * (topBase + bottomBase) * height;
    }
}
