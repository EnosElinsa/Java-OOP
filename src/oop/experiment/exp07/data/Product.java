package oop.experiment.exp07.data;

import java.util.Comparator;
import java.util.Date;
import java.util.Objects;

public class Product implements Comparable<Product>, Cloneable {
	
	private String id;
	private String name;
	private double price;
	private int quantityInStock;
	private Date inStoreDate;

	public Product() {}	
	public Product(String id, String name, double price, int quantityInStock, Date inStoreDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.inStoreDate = inStoreDate;
	}
	
	public class priceComparator implements Comparator<Product> {

		@Override
		public int compare(Product o1, Product o2) {
			return Double.compare(o1.getPrice(), o2.getPrice());
		}
	};
	
	static Comparator<Product> quantityInStockComparator = new Comparator<Product>() {

		@Override
		public int compare(Product o1, Product o2) {
			return Integer.compare(o1.getQuantityInStock(), o2.getQuantityInStock());
		}
	};
	
	static Comparator<Product> inStoreDateComparator = (Product o1, Product o2) -> {
		return o1.getInStoreDate().compareTo(o2.getInStoreDate());
	};
	
	static Comparator<Product> nameComparator = (Product o1, Product o2) -> {
		return o1.getName().compareTo(o2.getName());
	};

	@Override
	public int compareTo(Product other) {
		return id.compareTo(other.getId());
	}

	@Override
	public Product clone() {
		try {
			Product temp = (Product)super.clone();
			temp.inStoreDate = (Date)this.inStoreDate.clone();
			return temp;
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	@Override
	public boolean equals(Object other) {
		if (other == null) return false;
		if (other == this) return true;
		if (other.getClass() != this.getClass()) return false;
		Product otherP = (Product) other;
		if (otherP.getId().equals(this.id) && otherP.getName().equals(this.name)
				&& otherP.getPrice() == this.price && otherP.getQuantityInStock() == this.quantityInStock
				&& otherP.getInStoreDate().equals(this.inStoreDate)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, quantityInStock, inStoreDate);
	}
	
	@Override
	public String toString() {
		return String.format("%s\t%s\t%.2f\t\t%d\t\t%.2f\t\t%s", id, name, price, quantityInStock, quantityInStock * price, inStoreDate.toString());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityInStock() {
		return quantityInStock;
	}
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	public void incrementQuantityInStock(int increment) {
		this.quantityInStock += increment;
	}
	public Date getInStoreDate() {
		return inStoreDate;
	}
	public void setInStoreDate(Date inStoreDate) {
		this.inStoreDate = inStoreDate;
	}
} 
