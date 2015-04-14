package de.sycor.bo; //Business-Objekt

public class Product implements java.io.Serializable{
	private int id;
	private String name;
	private int catID;
	private int amount;
	private double price;
	private String description;
	private String picName;

	public Product(int id, String name, int catID, int amount, double price, String description, String picurl) {
		this.id = id;
		this.name = name;
		this.catID = catID;
		this.amount = amount;
		this.price = price;
		this.description = description;
		this.picName = picurl;
		
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getCatID() {
		return catID;
	}

	public void setCatID(int id) {
		this.catID = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPicName() {
		return picName;
	}

	public void setPicName(String picurl) {
		this.picName = picurl;
	}

	public String toString() {
		return id + name + catID + amount + price + description + picName;
	}

}