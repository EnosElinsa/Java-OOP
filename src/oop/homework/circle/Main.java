package oop.homework.circle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("输入第一个圆 x y r : ");
        double x1 = in.nextDouble();
        double y1 = in.nextDouble();
        double r1 = in.nextDouble();
        Circle circle1 = new Circle(x1, y1, r1);
        System.out.printf("输入第二个圆 x y r : ");
        double x2 = in.nextDouble();
        double y2 = in.nextDouble();
        double r2 = in.nextDouble();
        Circle circle2 = new Circle(x2, y2, r2);
        circle1.getRelationship(circle2);
        in.close();
    }
}
