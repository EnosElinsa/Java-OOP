package oop.homework.pokergame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * </p>Player玩家类</p>
 */
public class Player {
    /**
     * </p>玩家的持牌器</p>
     * </p>是一个二维的ArrayList，每一维的ArrayList由相同花色的牌构成</p>
     */
    private ArrayList<ArrayList<Card>> cardHolder;
    Player() {
        cardHolder = new ArrayList<ArrayList<Card>>();
        for(int i = 0; i < Poker.INIT_CARDS_NUM; i++) {
            ArrayList<Card> list = new ArrayList<Card>();
            cardHolder.add(list);
        }
    }

    /**
     * 用于给玩家发牌的函数
     * @param card 要发给玩家的牌
     */
    public void dealACard(Card card) {
        Suits suit = card.getSuit(); // 获取该牌的花色
        int indexOfsuit = suit.ordinal(); // 获取该花色在枚举中的索引
        cardHolder.get(indexOfsuit).add(card); // 将牌添加到玩家持牌器中对应花色的一维ArrayList中
    }

    /**
     * 将玩家持牌器中的所有牌按照花色顺序进行展示
     */
    public void showCards() {
        // 对玩家的持牌器中的牌按照牌面值的大小进行降序排序
        for (int i = 0; i < Poker.INIT_CARDS_NUM; i++) {
            Collections.sort(cardHolder.get(i));
        }
        for (int indexOfSuits = 0; indexOfSuits < Poker.INIT_CARDS_NUM; indexOfSuits++) {
            System.out.print(Poker.suits[indexOfSuits] + "：");
            for (Card card : cardHolder.get(indexOfSuits)) {
                System.out.print(Poker.faceValues[card.getFaceValue() - 1] + " ");
            }
            System.out.println();
        }
    }
}

