package oop.experiment.exp1;

/*
 * 思考题1：三个数据域变量的初始默认值分别为：0.0, 0.0, null;
 * 构造方法前不能有返回值。
 * 思考题2：出现错误"The constructor Ring() is undefined"; 
 * 出现这个错误的原因是：当用户自己定义了自己的构造函数时，
 * 编译的时候系统不会为该类自动添加无参的构造方法，因此该类中不存在无参的构造方法。
 * 思考题3：此时没有错误发生；此时的两个Ring方法都是Ring类的构造方法的重载
 */

public class Ring {
    double innerRadius;
    double outerRadius;
    String fillColor;

    Ring() {
        innerRadius = 1;
        outerRadius = 2;
        fillColor = "WHITE";
    }

    Ring(double iRadius, double oRadius, String color) {
        innerRadius = iRadius;
        outerRadius = oRadius;
        this.fillColor = color;
    }

    double getArea() {
        return (outerRadius * outerRadius - innerRadius * innerRadius) * Math.PI;
    }

    double getInnerCircumference() {
        return 2 * innerRadius * Math.PI;
    }

    double getOuterCircumference() {
        return 2 * outerRadius * Math.PI;
    }
}
