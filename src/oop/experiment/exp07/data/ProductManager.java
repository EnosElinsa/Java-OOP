package oop.experiment.exp07.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	private List<Product> productsList = new ArrayList<>();
	private int overallQuantityInStock;
	private double overallInventoryAmount;

	public Scanner in = new Scanner(System.in);
	
	public ProductManager() {}
	
	public void addProduct() {
		System.out.print("Input the id of the Product: ");
		String id = in.next();
		if(isProductExisted(id)) {
			Product product = findViaId(id);
			System.out.println("Product info:\nId\tName\t\tPrice\t\tQuantity in Stock\tInventory Amount\tIn Store Date\n" + product.toString());
			System.out.print("Input the increased quantity of the product: ");
			int increasedQuantity = in.nextInt();
			product.incrementQuantityInStock(increasedQuantity);
			System.out.println("Stock increase done");
			System.out.println("Product info:\nId\tName\t\tPrice\t\tQuantity in Stock\tInventory Amount\tIn Store Date\n" + product.toString());
			System.out.println("\n");
		} else {
			System.out.print("Input the name of the product: ");
			String name = in.next();
			System.out.print("Input the price of the product: ");
			double price = in.nextDouble();
			System.out.print("Input the quantity in stock of the product: ");
			int quantityInStock = in.nextInt();
			Product newProduct = new Product(id, name, price, quantityInStock, new Date());
			productsList.add(newProduct);
			System.out.println("Product " + name + " added");
			System.out.println("Product info:\nId\tName\t\tPrice\t\tQuantity in Stock\tInventory Amount\tIn Store Date\n" + newProduct.toString());
			System.out.println("\n");
		}
	}
	
	public void sellProduct() {
		System.out.print("Input the id of the Product:");
		String id = in.next();
		if (isProductExisted(id)) {
			Product product = findViaId(id);
			System.out.println("Product info:\nId\tName\t\tPrice\t\tQuantity in Stock\tInventory Amount\tIn Store Date\n" + product.toString());
			System.out.print("Input sales quantity: ");
			int salesQuantity = in.nextInt();
			if (salesQuantity > product.getQuantityInStock()) {
				System.out.println("Insufficient quantity in stock!");
				System.out.println("\n");
			}
			else {
				product.incrementQuantityInStock(-1 * salesQuantity);
				System.out.println("Transaction done");
				System.out.println("\n");
			}
		}
		else {
			System.out.println("Invalid id!");
			System.out.println("\n");
		}
	}
	
	public void search() {
		System.out.print("Input the tag(id, name, price, quantityInStock, inStoreDate): ");
		String tag = in.next();
		boolean isValidTag = true;
		switch(tag) {
		case "id": productsList.sort(null); break;
		case "name": productsList.sort(Product.nameComparator); break;
		case "price": productsList.sort(new Product().new priceComparator()); break;
		case "quantityInStock": productsList.sort(Product.quantityInStockComparator); break;
		case "inStoreDate": productsList.sort(Product.inStoreDateComparator); break;
		default: isValidTag = false; System.out.println("Invalid tag!");
		}
		if (isValidTag) display();
		System.out.println("\n");
	}

	public void getStatistics() {
		for (Product p : productsList) {
			overallQuantityInStock += p.getQuantityInStock();
			overallInventoryAmount += p.getQuantityInStock() * p.getPrice();
		}
		System.out.println("Overall Quantity in Stock: " + overallQuantityInStock);
		System.out.println("Overall Inventory Amount: " + overallInventoryAmount);
		System.out.println("\n");
	}
	
	private boolean isProductExisted(String id) {
		for (Product p : productsList) {
			if(p.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
	private Product findViaId(String id) {
		for (Product p : productsList) {
			if(p.getId().equals(id)) {
				return p;
			}
		}
		return null;
	}
	
	public void display() {
		System.out.println("Id\tName\t\tPrice\t\tQuantity in Stock\tInventory Amount\tIn Store Date");
		System.out.println("----------------------------------------------------------------------------------------------");
		for (Product p : productsList) {
			System.out.println(p.toString());
		}
	}
}
