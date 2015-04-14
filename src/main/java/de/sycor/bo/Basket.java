package de.sycor.bo; //business-Objekt

import java.util.ArrayList;
import java.util.List;

public class Basket {
	List<LineItems> lineitems = new ArrayList<LineItems>();
	private int userID;
	private double totalPrice;
	private int basketID;
	
	public Basket(int basketID, int userID, double totalPrice){
		this.basketID = basketID;
		this.userID = userID;
		this.totalPrice = totalPrice;
	}
	
	public int getBasketID() {
		return basketID;
	}

	public void setBasketID(int basketID) {
		this.basketID = basketID;
	}
	
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * gibt alle Baskets aus
	 */
	public List<LineItems> getLineItems() {
		return lineitems;
	}
	
	public void clearLineItems(){
		lineitems.clear();
	}

	/**
	 * fügt eine Basket(-Line) zur Arraylist hinzu
	 */
	public void addLineItem(LineItems b) {
		lineitems.add(b);
	}
	
	public String toString() {
		return " " + basketID + userID + totalPrice;
	}
}