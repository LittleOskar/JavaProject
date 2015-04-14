package de.sycor.bo;

public class LineItems implements java.io.Serializable {
	private int b_id;
	private int linenumber;
	private int productID;
	private int amount;
	private double price;

	public LineItems() {

	}

	public LineItems(int b_id, int linenumber, int productID, int amount, double price) {
		this.b_id = b_id;
		this.linenumber = linenumber;
		this.productID = productID;
		this.amount = amount;
		this.price = price;
	}

	public int getBID(){
		return b_id;
	}
	
	public void setBID(int b_id){
		this.b_id = b_id;
	}
	
	public int getLinenumber(){
		return linenumber;
	}
	
	public void setLinenumber(int linenumber){
		this.linenumber = linenumber;
	}
	
	public int getProductID() {
		return productID;
	}
	
	public void setProductID(int productID) {
		this.productID = productID;
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

	public String toString() {
		return ""+ b_id + linenumber + productID + amount + price;
	}
}
