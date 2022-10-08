package oop.homework.firstday;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("输入年份：");
        int year = in.nextInt();
        System.out.printf("该年第1天是星期几: %d", FirstDayOfTheYear.getFirstDayofTheYear(year));
        in.close();
    }
}
