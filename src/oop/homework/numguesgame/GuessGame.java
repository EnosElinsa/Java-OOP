package oop.homework.numguesgame;

import java.util.Scanner;

/**
 * GuessGame类为整个项目的主体部分，包含：随机数的生成、游戏的主流程以及玩家数据的管理
 */
public class GuessGame {
	Player player;
	int randomNumber;
	Scanner in;
	GuessGame() {
		this.player = new Player();
		this.in = new Scanner(System.in);
	}
	
	/**
	 * 该方法用于产生一个在[0, 9]之间的随机数
	 * @return number 产生的随机数
	 */
	private static int generateARandomNumber() {
		int number = (int)(Math.random() * 10);
		return number;
	}
	
	public void start() {
		while (true) {
			this.randomNumber = generateARandomNumber(); // 生成一个随机数
			player.incrNumberOfGames(); // 每生成一个随机数，玩家游戏次数加一
			System.out.printf("第%d次游戏，程序生成了一个[0, 9]之间的数。\n", player.getNumberOfGames());
			while (player.getNumberOfTrialsLeft() > 0) {
				System.out.printf("你还有%d次机会，输入你猜的数：", player.getNumberOfTrialsLeft());
				int guessNumber = in.nextInt();
				if (guessNumber > randomNumber) {
					System.out.printf("你猜的数太大了！\n");
				}
				else if (guessNumber < randomNumber) {
					System.out.printf("你猜的数太小了！\n");
				}
				else {
					System.out.printf("恭喜你，猜对了");
					player.incrNumberOfWins(); // 玩家胜利次数加一
					break;
				}
				player.decrNumberOfTrialsLeft(); // 没有猜对时，玩家剩余的尝试次数减一
			}
			if (player.getNumberOfTrialsLeft() == 0) {
				System.out.printf("本次游戏失败！正确的数字是：%d", this.randomNumber);
				player.incrNumberOfFails(); // 所有尝试的次数用尽，玩家当次游戏失败，失败次数加一
			}
			System.out.printf("\n你还要继续游戏吗？（Y继续/N退出）：");
			String selection = in.next();
			if (selection.equals("Y") || selection.equals("y")) {
				player.restoreNumberOfTrialsLeft(); // 当玩家选择再一次游戏时，恢复玩家每次游戏时剩余的尝试次数为默认值
				continue;
			}
			else {
				break;
			}
		}
		System.out.printf("\n------------------------------------\n");
		System.out.printf("你一共进行了%d次游戏，成功%d次，失败%d次。", 
			player.getNumberOfGames(), player.getNumberOfWins(), player.getNumberOfFails());
		in.close();
	}
}
