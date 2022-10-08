package oop.homework.pokergame;

import java.util.ArrayList;

/**
 * 辅助游戏进行的类，包含了一个用于发牌的静态方法。
 */
public class GameHelpers {
    /**
     * 一个用于生成一个发牌序列的静态方法。
     * 假设一副扑克牌（在该程序中为Poker类型的对象）中的牌是按顺序依次放好的，该方法生成的发牌顺序数组
     * 中的值（一个在[0, 51]的随机整数数，不重复出现）表示在扑克牌中的第几张牌，以此来表示一个随机发牌的序列。
     * @return sequence 返回的是一个包含发牌的顺序的整数数组。
     */
    public static ArrayList<Integer> deal() {
        ArrayList<Integer> sequence = new ArrayList<Integer>(); // 发牌顺序的数组
        int countOfValidNumberGenerated = 0;
        while (countOfValidNumberGenerated < Poker.CAPACITY) {
            int number = generateRandomNumber(); // 生成一个在[0, 51]的随机整数数，用于表示
            if (!sequence.contains(number)) {
                sequence.add(number);
                countOfValidNumberGenerated++;
            }
        }
        return sequence;
    }

    /**
     * 生成多副扑克牌的发牌顺序。
     * @param numbeOfPoker 扑克牌的副数。
     * @return sequence 返回的是一个包含发牌的顺序的整数数组。
     */
    public static ArrayList<Integer> deal(int numbeOfPoker) {
        ArrayList<Integer> sequence = new ArrayList<Integer>(); // 发牌顺序的数组
        for (int i = 0; i < numbeOfPoker; i++) {
            sequence.addAll(deal());
        }
        return sequence;
    }

    /**
     * 生成一个在[0, 51]的随机数数
     * @return number 生成的随机数
     */
    private static int generateRandomNumber() {
        int number = (int)(Math.random() * Poker.CAPACITY);
        return number;
    }
}
