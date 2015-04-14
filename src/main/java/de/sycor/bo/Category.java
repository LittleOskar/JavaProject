package de.sycor.bo; //business-Objekt

public class Category implements java.io.Serializable{
	private int id;
	private String catName;

	public Category() {

	}

	public Category(int id, String catName) {
		this.id = id;
		this.catName = catName;
	}

	public int getID2() {
		return id;
	}

	public void setID2(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return catName;
	}

	public void setCategory(String catName) {
		this.catName = catName;
	}

	public String toString() {
		return id + catName;
	}
}