package oop.experiment.exp2;

import java.util.Scanner;

public class TestRing {
    public static void main(String[] args) {
        GoodRing ring = new GoodRing(1, 2, "WHITE");
        System.out.println("内圆半径：" + ring.getInnerRadius());
        System.out.println("外圆半径：" + ring.getOuterRadius());
        System.out.println("填充颜色：" + ring.getFillColor());
        System.out.println("环的面积：" + ring.getArea());
        System.out.println("内圆周长：" + ring.getInnerCircumference());
        System.out.println("外圆周长：" + ring.getOuterCircumference());
        ring.setOuterRadius(3);
        System.out.println();
        System.out.println("内圆半径：" + ring.getInnerRadius());
        System.out.println("外圆半径：" + ring.getOuterRadius());
        System.out.println("填充颜色：" + ring.getFillColor());
        System.out.println("环的面积：" + ring.getArea());
        System.out.println("内圆周长：" + ring.getInnerCircumference());
        System.out.println("外圆周长：" + ring.getOuterCircumference());

        Scanner in = new Scanner(System.in);
        System.out.print("从键盘输入要创建的GoodRing对象的个数n:");
        int numberOfRings = in.nextInt();
        GoodRing[] goodRings = GoodRingUtil.createGoodRings(numberOfRings);
        GoodRingUtil.totalArea(goodRings);
        GoodRingUtil.outputGoodRings(goodRings);
        GoodRingUtil.sort(goodRings);
        GoodRingUtil.outputGoodRings(goodRings);
        in.close();
    }
}
