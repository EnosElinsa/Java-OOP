package oop.homework.numguesgame;

/**
 * Player玩家类，包含了玩家的数据：numberOfGames(游戏次数)、numberOfWins(游戏胜利次数)、
 * numberOfFails(游戏失败次数)、numberOfTrialsLeft(单次游戏中剩余的尝试次数)；
 * 同时提供了玩家在游戏过程中修改游戏数据以及获取玩家数据的方法。
 */
public class Player {
	private int numberOfGames;
	private int numberOfWins;
	private int numberOfFails;
	private int numberOfTrialsLeft;
	private static final int MAX_TRIALS_TIMES = 3; // 默认玩家最多的尝试次数为3次
	Player() {
		this.numberOfGames = 0;
		this.numberOfWins = 0;
		this.numberOfFails = 0;
		this.numberOfTrialsLeft = MAX_TRIALS_TIMES;
	}
	
	public int getNumberOfGames() {
		return numberOfGames;
	}
	public void incrNumberOfGames() {
		this.numberOfGames++;
	}
	
	public int getNumberOfWins() {
		return numberOfWins;
	}
	public void incrNumberOfWins() {
		this.numberOfWins++;
	}
	
	public int getNumberOfFails() {
		return numberOfFails;
	}
	public void incrNumberOfFails() {
		this.numberOfFails++;
	}
	
	public int getNumberOfTrialsLeft() {
		return this.numberOfTrialsLeft;
	}
	public void decrNumberOfTrialsLeft() {
		this.numberOfTrialsLeft--;
	}
	public void restoreNumberOfTrialsLeft() {
		this.numberOfTrialsLeft = MAX_TRIALS_TIMES;
	}
}
