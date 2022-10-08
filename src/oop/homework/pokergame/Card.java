package oop.homework.pokergame;

/**
 * 卡牌类，包含卡牌的面值以及花色, 并且重写compareTo方法，便于卡牌间面值的比较。
 */
public class Card implements Comparable<Card> {
    private int faceValue;
    private Suits suit; 
    public Card(int faceValue, Suits suit) {
        this.faceValue = faceValue;
        this.suit = suit;
    }
    public int getFaceValue() {
        return faceValue;
    }
    public Suits getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card compareCard) {
        return compareCard.faceValue - this.faceValue;
    }
}    