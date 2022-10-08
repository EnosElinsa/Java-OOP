package oop.homework.pokergame;

import java.util.ArrayList;

/**
 * 扑克牌类。
 * 含有一个Card类型的ArrayList，表示一副扑克牌（扑克牌中的牌是按顺序放好的）。
 */
public class Poker {
    public static final int MAX_FACE_VALUE = 13;
    public static final int INIT_CARDS_NUM = 4;
    public static final int CAPACITY = MAX_FACE_VALUE * INIT_CARDS_NUM;
    public static String[] suits = {"黑桃", "红心", "草花", "方块"};
    public static String[] faceValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
    ArrayList<Card> cards;  // 一副扑克牌
    
    Poker() {
        this.cards = new ArrayList<Card>();
        Suits[] suits = Suits.values(); 
        // 按照面值和花色顺序生成一副扑克牌
        for (int faceValue = 1; faceValue <= MAX_FACE_VALUE; faceValue++) {
            for (int suitIndex = 0; suitIndex < INIT_CARDS_NUM; suitIndex++) {
                this.cards.add(new Card(faceValue, suits[suitIndex]));
            }
        }
    }
}
