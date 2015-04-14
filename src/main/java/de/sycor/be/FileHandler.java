package de.sycor.be;

import java.util.ArrayList;
import java.util.List;

import de.sycor.bo.Category;
import de.sycor.bo.Product;
import de.sycor.bo.User;

public interface FileHandler {

	public ArrayList<Product> readProducts();
	public ArrayList<Category> readCats();
	public ArrayList<User> readUsers();
	public void write(List<Product> products, List<Category> cats, List<User> user);
}
