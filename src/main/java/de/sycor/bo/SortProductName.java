package de.sycor.bo;

import java.util.Comparator;

public class SortProductName implements Comparator<Product> {
	public int compare(Product p1, Product p2) {
		return p1.getName().compareTo(p2.getName());
	}
}