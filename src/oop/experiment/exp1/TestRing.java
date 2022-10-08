package oop.experiment.exp1;

public class TestRing {
    public static void main(String[] args) {
        // Ring ring = new Ring(5, 8, "RED");
        Ring ring = new Ring();
        System.out.println("内圆半径：" + ring.innerRadius);
        System.out.println("外圆半径：" + ring.outerRadius);
        System.out.println("填充颜色：" + ring.fillColor);
        System.out.println("环的面积：" + ring.getArea());
        System.out.println("内圆周长：" + ring.getInnerCircumference());
        System.out.println("外圆周长：" + ring.getOuterCircumference());
    }
}
