package oop.homework.part1;

import java.util.Scanner;

public class PalindromePrimes {
	private static boolean isPalindromicNumber(int number) {
		if (number / 10 == 0) {
			return true;
		}
		int temp = number;
		int newNumber = 0;
		while (temp != 0) {
			newNumber = newNumber * 10 + temp % 10;
			temp /= 10;
		}
		// 将原数字进行倒转后与原数字进行数字上的比较来判断是否为回文数
		return newNumber == number;
	}
	
	private static boolean isPrimes(int number) {
		for (int divisor = 2; divisor <= (int)Math.sqrt(number); divisor++) {
			if (number % divisor == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static int[] getNPalindromePrimes(int numberOfPalindromePrimes) {
		int[] palindromePrimes = new int[numberOfPalindromePrimes];
		for (int number = 2, count = 0; count < numberOfPalindromePrimes; number++) {
			if (isPrimes(number) && isPalindromicNumber(number)) {
				palindromePrimes[count] = number;
				count++;
			}
		}
		return palindromePrimes;
	}
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("输入个数：");
		int numberOfPalindromePrimes = in.nextInt();
		int[] nPalindromePrimes = 
				PalindromePrimes.getNPalindromePrimes(numberOfPalindromePrimes);
		System.out.printf("前%d个同时为素数和回文数的正整数是：\n", numberOfPalindromePrimes);
		for (int number : nPalindromePrimes) {
			System.out.print(number + " ");
		}

		in.close();
	}
}