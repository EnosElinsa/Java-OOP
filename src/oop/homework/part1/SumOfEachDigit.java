package oop.homework.part1;

import java.util.Scanner;

/**
 * 读取一个正整数，假设输入的正整数一定在0（包括）到1000（不包括）之间。计算并输出该整数的各位数字之和
 */

public class SumOfEachDigit {
	public static int getSum(int number) {
		int sum = 0;
		while (number != 0) {
			sum += number % 10;
			number /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in);
		System.out.print("输入要进行计算的数："); int number = in.nextInt();
		System.out.println("各位数的和为：" + SumOfEachDigit.getSum(number));
		in.close();
	}
}
