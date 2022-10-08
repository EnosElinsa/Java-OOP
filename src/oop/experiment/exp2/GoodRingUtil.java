package oop.experiment.exp2;

import java.util.Arrays;

public class GoodRingUtil {
    private GoodRingUtil() {};
    public static GoodRing[] createGoodRings(int numberOfRings) {
        GoodRing[] goodRings = new GoodRing[numberOfRings];
        for (int index = 0; index < numberOfRings; index++) {
            double[] radius = getRandomRadius();
            GoodRing ring = new GoodRing(radius[0], radius[1], "WHITE");
            goodRings[index] = ring;
        }
        return goodRings;
    }
    private static double[] getRandomRadius() {
        double[] radius = new double[2];
        radius[0] = Math.random() * 10;
        do {
            radius[1] = Math.random() * 10;
        } while (radius[1] <= radius[0]); // 外径必须大于内径
        return radius;
    }
    
    public static double totalArea(GoodRing[] goodRings) {
        double sum = 0;
        for (int index = 0; index < goodRings.length; index++) {
            sum += goodRings[index].getArea();
        }
        return sum;
    }

    public static void sort(GoodRing[] goodRings) {
        Arrays.sort(goodRings);
    }

    public static void outputGoodRings(GoodRing[] goodRings) {
        System.out.println("输出如下：");
        for (GoodRing ring : goodRings) {
            System.out.println(ring.getInnerRadius() + " " + ring.getOuterRadius()
             + " " + ring.getFillColor() + " " + ring.getArea());
        }
        System.out.println();
    }
}
