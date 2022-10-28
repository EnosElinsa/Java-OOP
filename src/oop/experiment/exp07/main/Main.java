package oop.experiment.exp07.main;

import oop.experiment.exp07.data.ProductManager;

public class Main {

	public static void main(String[] args) {
		ProductManager productManager = new ProductManager();
		boolean exitFlag = false;
		while (true) {
			System.out.println(" 0: Add/Modify a product\n 1: Sell some products\n 2: Search with a tag\n 3: Get Statistic\n 4: Quit");
			int option = productManager.in.nextInt();
			switch (option) {
				case 0: productManager.addProduct(); break;
				case 1: productManager.sellProduct(); break;
				case 2: productManager.search(); break;
				case 3: productManager.getStatistics(); break;
				case 4: exitFlag = true; break;
				default: System.out.println("Invalid option!");
			}
			if (exitFlag) {
				break;
			}
		}
		productManager.in.close();
	}
}
