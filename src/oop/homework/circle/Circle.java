package oop.homework.circle;

public class Circle {
	private double x;
    private double y;
    private double radius;
    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public static String[] relationships = {"包含", "相交", "无关"};

    private double getDistance(Circle circle) {
        double distance = Math.sqrt(Math.pow(this.x - circle.getX(), 2) 
            + Math.pow(this.y - circle.getY(), 2));
        return distance;
    }

    public void getRelationship(Circle circle) {
        double distance = this.getDistance(circle);
        if (distance < Math.abs(this.radius - circle.getRadius())) {
            if (this.radius > circle.radius) {
                System.out.print(this.toString() + " " + relationships[0] + " " + circle.toString());
            }
            else {
                System.out.print(circle.toString() + " " + relationships[0] + " " + this.toString());
            }
        }
        else if (distance > Math.abs(this.radius - circle.getRadius())) {
            System.out.print(this.toString() + " 与 " + circle.toString() + " " + relationships[2]);
        }
        else {
            System.out.print(this.toString() + " 与 " + circle.toString() + " " + relationships[1]);
        }
    }

    @Override
    public String toString() {
        String str = "(" + this.x + "," + this.y + ")" + "-" + this.radius;
        return str;
    }
    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
}
