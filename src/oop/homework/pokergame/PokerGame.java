package oop.homework.pokergame;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 1. 共有m幅扑克牌，每幅扑克牌不包括大王和小王共52张牌。<br/>
 * 2. 可能有n个人参与扑克游戏，2<=n<=52。<br/>
 * 3. 程序运行时输入扑克牌幅数m和人数n，然后所有牌分别依次分发给n个人。
 * 不能整除时，每个人的牌数可以不同，如3个人1幅牌，则第1个人18张，第2个和第3个人17张牌。<br/>
 * 4. 发牌完成后按花色（顺序为黑桃、红心、草花、方块）和牌面大小输出每个人得到的牌。<br/>
 */

public class PokerGame {
    public void startGame() { 
        Scanner in; in = new Scanner(System.in);

        int numebrOfDecks; System.out.printf("输入扑克牌副数："); numebrOfDecks = in.nextInt();
        Poker poker = new Poker();
        ArrayList<Integer> sequence = GameHelpers.deal(numebrOfDecks); // 发牌的序列

        int numberOfPlayers; System.out.printf("输入玩家人数："); numberOfPlayers = in.nextInt();
        Player[] playerList = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            playerList[i] = new Player();
        }

        System.out.printf("------------------------------");
        System.out.printf("\n输出如下：\n");
        
        int playerIndex = 0;
        for (int cardIndex : sequence) {
            playerList[playerIndex].dealACard(poker.cards.get(cardIndex));
            playerIndex = (playerIndex + 1) % numberOfPlayers;
        }

        playerIndex = 1;
        for (Player player : playerList) {
            System.out.printf("第%d个人：\n", playerIndex++);
            player.showCards();
        }
        System.out.printf("------------------------------");
        in.close();
    }
}
