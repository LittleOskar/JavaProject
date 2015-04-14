package de.sycor.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.sycor.be.MySQLAccess;
import de.sycor.bo.LineItems;
import de.sycor.bo.Basket;
import de.sycor.bo.Category;
import de.sycor.bo.CategoryList;
import de.sycor.bo.Product;
import de.sycor.bo.ProductList;
import de.sycor.bo.User;
import de.sycor.bo.UserList;

public class Controller {

	Scanner scan = new Scanner(System.in);
	ProductList products = new ProductList();
	CategoryList cats = new CategoryList();
	UserList user = new UserList();
	Basket basket = null;
	MySQLAccess mysqlaccess = new MySQLAccess();
	String whichFile;
	
	public Controller() {
		
	}
	
	public ArrayList<User> readUsers(){
		return mysqlaccess.readUsers();
	}
	
	public ArrayList<Product> readProducts(){
		return mysqlaccess.readProducts();
	}
	
	public ArrayList<Category> readCats(){
		return mysqlaccess.readCats();
	}

	public Basket readBasket(int userID){
		return mysqlaccess.readBasket(userID);
	}
	
	public void editProduct(Product p){
		mysqlaccess.editProduct(p);
	}
	
	public void editCategory(Category c){
		mysqlaccess.editCategory(c);
	}
	
	public void editBasketLine(LineItems lineitem, Basket basket){
		mysqlaccess.editBasketLine(lineitem, basket);
	}
	
//	public void updateBasketTotalPrice(LineItems b){
//		mysqlaccess.updateBasketTotalPrice(b);
//	}
	
	public void deleteProduct(int id){
		mysqlaccess.deleteProduct(id);
	}
	
	public void deleteCategory(int id){
		mysqlaccess.deleteCategory(id);
	}
	
	public void deleteBasketLine(int b_id, int userID){
		mysqlaccess.deleteBasketLine(b_id, userID);
	}
	
	public Basket basketExist(int userID){
		return mysqlaccess.basketExist(userID);
	}
	
	public int getNextID(){
		return Integer.parseInt(mysqlaccess.nextCID());
	}
	
	public int getNextCID(){
		return Integer.parseInt(mysqlaccess.nextID());
	}
	
	public int getNextUID(){
		return Integer.parseInt(mysqlaccess.nextUID());
	}
	
	public int getNextBID(){
		return Integer.parseInt(mysqlaccess.nextBID());
	}
	
	public int getBasketIDbyUserID(int userID){
		return mysqlaccess.getBasketIDbyUserID(userID);
	}
	
	public String readFiles(String gewähltesBackend) {
		if (gewähltesBackend.equalsIgnoreCase("mysql")) {
			products.setProductList(mysqlaccess.readProducts());
			cats.setCategoryList(mysqlaccess.readCats());
			user.setUserList(mysqlaccess.readUsers());
//			mysqlaccess.readBasket(userID);
			whichFile = "mysql";
		}
		return whichFile;
	}
	
	public List<Product> getProducts() {
		return products.getProducts();
	}
	
	public List<Category> getCats(){
		return cats.getCategories();
	}
	
	public List<User> getUsers(){
		return user.getUsers();
	}
	
	public List<LineItems> getBasket(){
		return basket.getLineItems();
	}

	public Product getProduct(int id) {
		return mysqlaccess.getProduct(id);
	}

//	public Product getProduct(int id) {
//		return products.getProduct(id);
//	}
	
	public int isCThere(String nameC) {
		int tempId = 0;
		boolean cThere = false;
		for (Category c : cats.getCategories()) {
			if (nameC.equals(c.getCategoryName())) {
				cThere = true;
				tempId = c.getID2();
			}
		}
		if (cThere == false) {
			int newCatId = cats.getFreeCatId();
			cats.addCategory(new Category(newCatId, nameC));
			List<Category> tmpC = new ArrayList<Category>();
			tmpC = cats.getCategories();
			List<Product> tmp = new ArrayList<Product>();
			tmp = products.getProducts();
			List<User> tmpU = new ArrayList<User>();
			tmpU = user.getUsers();
			Basket basket = readBasket(2);
			saveAllFiles(tmp, tmpC, tmpU, basket);
			tempId = newCatId;
		}
		return tempId;
	}

//	public boolean isCEmpty(int id) {
//		boolean there = false;
//		for (Product p : products.getProducts()) {
//			if (id == p.getCatID()) {
//				there = true;
//				break;
//			} else {
//				Iterator<Category> it = cats.getCategories().iterator();
//				while (it.hasNext()) {
//					Category cat = it.next();
//					if (id == cat.getID2()) {
//						csvhandler.deleteCategory(cat);
//						it.remove();
//						break;
//					}
//				}
//			}
//			break;
//		}
//		return there;
//	}

	public int freePId() {
		return products.getFreeId();
	}

	public int freeCId() {
		return cats.getFreeCatId();
	}
	
	public void saveUser(List<User> tmp){
		mysqlaccess.writeUsers(tmp);
	}
	
	public void saveCats(List<Category> tmp){
		mysqlaccess.writeCats(tmp);
	}
	
	public void saveProducts(List<Product> tmp){
		mysqlaccess.writeProducts(tmp);
	}
	
	public void saveBasket(Basket basket){
		mysqlaccess.writeBasket(basket);
	}
	
	public void saveAllFiles(List<Product> tmp, List<Category> tmpC, List<User> tmpU, Basket basket) {
		mysqlaccess.write(tmp, tmpC, tmpU);
		mysqlaccess.writeBasket(basket);
	}
	
	
	public List<Product> showPbyCId(int id) {
		return products.productsCatID(id);
	}

	public List<Product> searchCatbyID(int eingabe) {
		return products.productsCatID(eingabe);
	}
	
	
	public List<Product> searchP(String name) {
		return products.searchProduct(name);
	}

	public List<Category> searchC(String name) {
		return cats.searchCat(name);
	}

	public boolean doesCExist(int id) {
		for (Category c : cats.getCategories()) {
			if (id == c.getID2()) {
				return true;
			}
		}
		
		return false;
	}

	public void deleteP(Product p) {
		List<Product> tmp = new ArrayList<Product>();
		for (Product product : products.getProducts()) {
			if (product.getID() != p.getID()) {
				tmp.add(product);
			}
		}
		saveProducts(tmp);
	}

	public List<Product> filterPPrice(double min, double max) {
		return products.filterProdPrice(min, max);
	}

	public void addUserU(User u){
		user.addUser(u);
	}
	
	public void addCatsC(Category c){
		cats.addCategory(c);
	}

	public void addProductP(Product p) {
			products.addProduct(p);
	}
	
	public String actualBackend() {
		return whichFile;
	}
	
	public int userExist(String email, String password){
		return mysqlaccess.userExist(email, password);
	}
	
	public User getUserByUID(int userID){
		return mysqlaccess.getUserByUID(userID);
	}

}