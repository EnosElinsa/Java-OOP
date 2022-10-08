package oop.experiment.exp2;

/*
 * 步骤1：
 * （1）方法名应为GoodRing；用public可见性修饰符修饰构造方法比较合理；
 * （2）3个数据域应该用private可见性修饰符进行封装；
 * （3）计算方法应该用public可见性修饰符修饰。
 */
public class GoodRing implements Comparable<GoodRing> {
    private double innerRadius;
    private double outerRadius;
    private String fillColor;
    
    public GoodRing(double innerRadius, double outerRadius, String fillColor) {
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
        this.fillColor = fillColor;
    }

    public double getArea() {
        return (outerRadius * outerRadius - innerRadius * innerRadius) * Math.PI;
    }

    public double getInnerCircumference() {
        return 2 * innerRadius * Math.PI;
    }

    public double getOuterCircumference() {
        return 2 * outerRadius * Math.PI;
    }

    public double getInnerRadius() {
        return innerRadius;
    }
    public void setInnerRadius(double innerRadius) {
        this.innerRadius = innerRadius;
    }
    public double getOuterRadius() {
        return outerRadius;
    }
    public void setOuterRadius(double outerRadius) {
        this.outerRadius = outerRadius;
    }
    public String getFillColor() {
        return fillColor;
    }
    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }
 
    @Override
    public int compareTo(GoodRing compareRing) {
        return (int)(compareRing.getArea() - this.getArea()); 
    }
}
