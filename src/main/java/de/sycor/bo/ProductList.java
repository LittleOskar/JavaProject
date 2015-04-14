package de.sycor.bo; //business-Objekt

import java.util.ArrayList;
import java.util.List;


public class ProductList {

	List<Product> products = new ArrayList<Product>();
	public ProductList() {
		
	}

	/**
	 * gibt alle Produkte der Liste aus
	 */
	public List<Product> getProducts() {
		return products;
	}
	
	public void clearPList(){
		products.clear();
	}

	/**
	 * fügt ein Produkt zur Arraylist dazu
	 */
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public void setProductList(List<Product> products){
		this.products = products;
	}

	/**
	 * gibt das Produkt mit der eingegebenen id aus
	 */
	public Product getProduct(int id) {
		for (int i = 0; i < products.size(); i++) {
			if (id == products.get(i).getID()) {
				return products.get(i);
			}
		}
		return null;
	}

	/**
	 * sucht nach der nächsthöheren freien id
	 */
	public int getFreeId() {
		
		int id = 0;
		for (int i = 0; i < products.size(); i++) {
			if (products.get(i).getID() > id) {
				Product p = products.get(i);
				int t = p.getID();
				id = t;
			}
		}
		id++;
		return id;
	}
	/**
	 * Gibt Produkte entsprechend des Suchkriteriums aus
	 */
	public List<Product> searchProduct(String productName) {
		List<Product> tmp = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {
			String name = products.get(i).getName();
			if (productName.toUpperCase().equals(name.toUpperCase()) || name.toUpperCase().contains(productName.toUpperCase())) {
				tmp.add(products.get(i));
			}
		}
		return tmp;

	}
	
	public List<Product> filterProdPrice(double minPrice, double maxPrice){
		List<Product> tmp = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++){
			if(products.get(i).getPrice() >= minPrice && products.get(i).getPrice() <= maxPrice){
				tmp.add(products.get(i));
			}
		}
		
		
		return tmp;
	}
	/**
	 * Gibt Produkte mit eingegebener Kategorie-Id aus.
	 */
	public List<Product> productsCatID(int catID) {
		List<Product> tmp = new ArrayList<Product>();
		for (int i = 0; i < products.size(); i++) {		//Liste wird Produkt für Produkt durchgegangen
			int cID = products.get(i).getCatID();		//Variable um die CategoryID aus dem aktuellen Produktlisten-element zu bekommen wird erstellt
			if (cID == catID) {							//Wenn die Eingabe dem der id entspricht
				tmp.add(products.get(i));
			}
		}
		return tmp;										//gibt die Produkte in der tmp-Liste wieder zurück

	}
	
}