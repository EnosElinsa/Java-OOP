package oop.homework.part1;

public class Draw4Cards {
    public static void main(String[] args) {
        Pile pile = new Pile();
        System.out.printf("--------------------------");
        for (int times = 1; times <= Pile.MAX_FACE_VALUE; times++) {
            pile.draw4Cards();
        }
        System.out.printf("\n--------------------------\n");
        System.out.printf("共计%d组和为24", pile.getTimesOfWin());
    }
 }

/**
 * 牌堆类
 */
class Pile {
    private int[] cards; // 数组索引对应牌面数值大小，值对应着该牌面数值大小的牌的剩余张数。
    public static final int MAX_FACE_VALUE = 13; // 最大牌面数值大小为13。
    public static final int INIT_CARDS_NUM = 4; // 每种牌的初始张数为4。
    private int timesOfWin; // 抽到的4张牌的面值总和为24的次数
    public int getTimesOfWin() {
    	return this.timesOfWin;
    }
    
    Pile() {
        this.cards = new int[MAX_FACE_VALUE + 1]; // 不使用第0位。
        for(int index = 1; index <= MAX_FACE_VALUE; index++) {
            this.cards[index] = INIT_CARDS_NUM;
        }
    }
    

    /**
     * 该方法用于抽取牌堆中的一张牌。
     * @return card 抽到的牌的牌面数值。
     */
    private int drawACard() {
        boolean isACardDrew = false;
        int card = 0;
        while (isACardDrew == false) {
            card = (int)(Math.random() * Pile.MAX_FACE_VALUE + 1);
            if (this.cards[card] > 0) {
                this.cards[card]--; // 牌堆中对应面值的牌的数量减1。
                isACardDrew = true; // 抽牌成功。
            }
        }
        return card;   
    }

    /**
     * 该方法用于一次性抽取4张牌，并将抽到的4张牌展示出来。
     * @return Nothing.
     */
    public void draw4Cards() {
        int[] cardList = new int[4];
        for (int numberOfCardsDrew = 0; numberOfCardsDrew < 4; numberOfCardsDrew++) {
            cardList[numberOfCardsDrew] = drawACard();
        }
        display4Cards(cardList);
    }

    /**
     * 该方法用于展示抽到的4张牌，如果抽到的4张牌的面值总和为24时，进行提示。
     * @param cardList 抽到的4张牌。
     * @return Nothing.
     */
    private void display4Cards(int[] cardList) {
        System.out.println();
        int sumOf4Cards = 0;
        for (int i = 0; i < 4; i++) {
            int card = cardList[i];
            sumOf4Cards += card;
            if (i == 3) {
                System.out.printf("%2d = %2d", card, sumOf4Cards);
                if (sumOf4Cards == 24) {
                    System.out.printf(" YES");
                    this.timesOfWin++;
                }
            }
            else {
                System.out.printf("%2d + ", card);
            }
        }
    }
    
}

