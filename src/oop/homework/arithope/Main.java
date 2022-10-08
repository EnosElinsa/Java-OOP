package oop.homework.arithope;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("输入：");
        String input = iScanner.nextLine();
        System.out.println("输出：" + new IntegerArithmeticExpression(input).getResult());
        iScanner.close();
    }
}
