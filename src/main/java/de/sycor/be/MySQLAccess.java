package de.sycor.be;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.sycor.bo.LineItems;
import de.sycor.bo.Basket;
import de.sycor.bo.Category;
import de.sycor.bo.Product;
import de.sycor.bo.User;
import de.sycor.util.Constants;

public class MySQLAccess implements FileHandler, Constants {
	Connection connect = null;
	Statement state = null;

	public MySQLAccess() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/webshop02", "root", "root");
			state = connect.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Product> readProducts() {
		ArrayList<Product> tmp = new ArrayList<Product>();
		ResultSet rs;
		try {
			rs = state.executeQuery("SELECT * FROM products");

			while (rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int categoryID = rs.getInt("categoryID");
				int amount = rs.getInt("amount");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				String picName = rs.getString("picName");
				Product p = new Product(id, name, categoryID, amount, price,
						description, picName);
				tmp.add(p);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}

	@Override
	public ArrayList<Category> readCats() {
		ArrayList<Category> cats = new ArrayList<Category>();
		try {
			ResultSet rs = state.executeQuery("SELECT * FROM categories");

			while (rs.next()) {
				int categoryID = rs.getInt("categoryID");
				String categoryName = rs.getString("categoryName");
				Category c = new Category(categoryID, categoryName);
				cats.add(c);

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cats;
	}

	@Override
	public ArrayList<User> readUsers() {
		ArrayList<User> user = new ArrayList<User>();
		try {
			ResultSet rs = state.executeQuery("SELECT * FROM user");

			while (rs.next()) {
				int userID = rs.getInt("userID");
				String email = rs.getString("email");
				String password = rs.getString("password");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String street = rs.getString("street");
				int plz = rs.getInt("plz");
				String town = rs.getString("town");
				int admin = rs.getInt("admin");
				User u = new User(userID, email, password, firstname, lastname, street, plz, town, admin);
				user.add(u);

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public Basket readBasket(int userID) {
		Basket basket = null;
		try{
			ResultSet rs = state.executeQuery("SELECT * FROM basket_head WHERE userID = " + userID);
			//gibt erstes Ergebnis aus
			rs.first();	
			int basketID = rs.getInt("basketID");
			int uID = rs.getInt("userID");
			double totalPrice = rs.getDouble("totalPrice");
			
			basket = new Basket(basketID, uID, totalPrice);
			rs.close();
		} catch (Exception e) {

		}
		try {
//			ResultSet rs = state.executeQuery("SELECT * FROM basket_lines INNER JOIN basket_head ON basket_head.basketID = basket_lines.basketID");
			ResultSet rs = state.executeQuery("SELECT * FROM basket_lines WHERE basketID = " + basket.getBasketID());
			while (rs.next()) {
				int b_id = rs.getInt("b_id");
				int linenumber = rs.getInt("linenumber");
				int productID = rs.getInt("productID");
				int amount = rs.getInt("amount");
				double price = rs.getDouble("price");
				LineItems lineItem = new LineItems(b_id, linenumber, productID, amount, price);
				basket.addLineItem(lineItem);
			}
			rs.close();
		} catch (Exception e) {

		}
		
		List<LineItems> lineitems = new ArrayList<LineItems>();
		lineitems = basket.getLineItems();
		double totalPrice = 0;
		for(LineItems l : lineitems){
			double oneItemTotalPrice = l.getAmount() * l.getPrice();
			totalPrice = oneItemTotalPrice + totalPrice;
		}
		basket.setTotalPrice(totalPrice);
		
		return basket;
	}
	

	@Override
	public void write(List<Product> products, List<Category> cats,
			List<User> user) {
		writeCats(cats);
		writeProducts(products);
		writeUsers(user);
	}

	public String nextUID() {
		String nextID = null;
		try {
			ResultSet rs;
			rs = state.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'user'");

			rs.next();
			nextID = rs.getString("Auto_increment");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nextID;
	}

	public String nextCID() {
		String nextID = null;
		try {
			ResultSet rs;
			rs = state
					.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'categories'");

			rs.next();
			nextID = rs.getString("Auto_increment");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nextID;
	}

	public String nextID() {
		String nextID = null;
		try {
			ResultSet rs;
			rs = state
					.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'products'");

			rs.next();
			nextID = rs.getString("Auto_increment");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nextID;
	}

	public String nextBID() {
		String nextBID = null;
		try {
			ResultSet rs;
			rs = state
					.executeQuery("SHOW TABLE STATUS WHERE `Name` = 'basket_head'");

			rs.next();
			nextBID = rs.getString("Auto_increment");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nextBID;
	}

	public void writeCats(List<Category> cats) {
		String sql = "INSERT INTO categories"
				+ "(categoryID, categoryName) VALUES" + "(?, ?)";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			Category c = cats.get(cats.size() - 1);

			ps.setInt(1, c.getID2());
			ps.setString(2, c.getCategoryName());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeProducts(List<Product> products) {
		String sql = "INSERT INTO products"
				+ "(id, name, categoryID, amount, price, description, picName) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			Product p = products.get(products.size() - 1);

			ps.setInt(1, p.getID());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getCatID());
			ps.setInt(4, p.getAmount());
			ps.setDouble(5, p.getPrice());
			ps.setString(6, p.getDescription());
			ps.setString(7, p.getPicName());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeUsers(List<User> user) {
		String sql = "INSERT INTO user"
				+ "(userID, email, password, firstname, lastname, street, plz, town, admin) VALUES"
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			User u = user.get(user.size() - 1);

			ps.setInt(1, u.getUserID());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			ps.setString(4, u.getFirstname());
			ps.setString(5, u.getLastname());
			ps.setString(6, u.getStreet());
			ps.setInt(7, u.getPlz());
			ps.setString(8, u.getTown());
			ps.setInt(9, u.getAdmin());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeBasket(Basket basket) {
		try {
			String sql = "UPDATE basket_head SET totalPrice = ? WHERE basketID = ?";

			PreparedStatement ps = connect.prepareStatement(sql);
			// zieht sich den letzten basket aus der ArrayList
			
			ps.setDouble(1, basket.getTotalPrice());
			ps.setInt(2, basket.getBasketID());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			String sql = "INSERT INTO basket_lines (basketID, linenumber, productID, amount, price) VALUES (?,?,?,?,?)";

			PreparedStatement ps = connect.prepareStatement(sql);
			
			List<LineItems> lineitems = basket.getLineItems();
			
			LineItems b = lineitems.get(lineitems.size() - 1);

			int test = lineitems.size();

			ps.setInt(1, basket.getBasketID());
			ps.setInt(2, test); // linenumber
			ps.setInt(3, b.getProductID());
			ps.setInt(4, b.getAmount());
			ps.setDouble(5, b.getPrice());
			ps.executeUpdate();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int getBasketIDbyUserID(int userID) {
		int basketID = 0;
		try {
			ResultSet rs = state.executeQuery("SELECT basketID FROM basket_head WHERE userID = " + userID);
			while (rs.next()) {
				basketID = rs.getInt("basketID");
			}
			rs.close();
		} catch (Exception e) {

		}
		return basketID;
	}
//lineitem b_id = -1
	public void editBasketLine(LineItems lineitem, Basket basket) {
		try {
			String sql = "UPDATE basket_lines SET amount = ? WHERE b_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			
			ps.setInt(1, lineitem.getAmount());
			ps.setInt(2, lineitem.getBID());
			ps.executeUpdate();

		} catch (Exception e) {

		}
		try {
			String sql = "UPDATE basket_head SET totalPrice = ? WHERE basketID = ?";
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setDouble(1, basket.getTotalPrice());
			ps.setInt(2, basket.getBasketID());
			ps.executeUpdate();

		} catch (Exception e) {

		}

	}

	public void editProduct(Product p) {
		String sql = "UPDATE products SET name = ?, categoryID = ?, amount = ?, price = ?, description = ?, picName = ? WHERE id = ?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, p.getName());
			ps.setInt(2, p.getCatID());
			ps.setInt(3, p.getAmount());
			ps.setDouble(4, p.getPrice());
			ps.setString(5, p.getDescription());
			ps.setString(6, p.getPicName());
			ps.setInt(7, p.getID());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readProducts();
	}

	public void editCategory(Category c) {
		String sql = "UPDATE categories SET categoryName = ? WHERE categoryID = ?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setString(1, c.getCategoryName());
			ps.setInt(2, c.getID2());
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readCats();
	}

	public void deleteProduct(int id) {
		String sql = "DELETE FROM products WHERE id = ?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);

			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readProducts();
	}

	public void deleteCategory(int id) {
		String sql = "DELETE FROM categories WHERE categoryID = ?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateBasketTotalPrice(Basket b) {
		String sql = "UPDATE basket_head SET totalPrice = ? WHERE basketID = ?";
		try {
			PreparedStatement ps = connect.prepareStatement(sql);
	
			ps.setDouble(1, b.getTotalPrice());
			ps.setInt(2, b.getBasketID());
			ps.executeUpdate();
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		readCats();
	}

	public void deleteBasketLine(int b_id, int userID) {
		try {
			String sql = "DELETE FROM basket_lines WHERE b_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, b_id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Basket basket = readBasket(userID);
		List<LineItems> lineitems = new ArrayList<LineItems>();
		lineitems = basket.getLineItems();
		double totalPrice = 0;
		for(LineItems l : lineitems){
			double oneItemTotalPrice = l.getAmount() * l.getPrice();
			totalPrice = oneItemTotalPrice + totalPrice;
		}
		basket.setTotalPrice(totalPrice);
		updateBasketTotalPrice(basket);
	}

	public Product getProduct(int id) {
		Product tmp = null;
		ResultSet rs;
		try {
			rs = state.executeQuery("SELECT * FROM products WHERE id ='" + id
					+ "'");

			while (rs.next()) {

				int Pid = rs.getInt("id");
				String name = rs.getString("name");
				int categoryID = rs.getInt("categoryID");
				int amount = rs.getInt("amount");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				String picName = rs.getString("picName");
				tmp = new Product(Pid, name, categoryID, amount, price,
						description, picName);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tmp;
	}

	public Category existsCat(String categoryName) {
		Category tmp = null;
		return tmp;
	}

	/**
	 * Gibt Produkte mit eingegebener Kategorie-Id aus.
	 */
	public List<Product> catsProducts(int categoryID) {
		List<Product> tmp = new ArrayList<Product>();
		List<Product> tmp2 = new ArrayList<Product>();

		ResultSet rs;
		try {
			rs = state
					.executeQuery("SELECT * FROM products WHERE categoryID ='"
							+ categoryID + "'");

			while (rs.next()) {

				int Pid = rs.getInt("id");
				String name = rs.getString("name");
				int catID = rs.getInt("categoryID");
				int amount = rs.getInt("amount");
				double price = rs.getDouble("price");
				String description = rs.getString("description");
				String picName = rs.getString("picName");
				tmp.add(new Product(Pid, name, catID, amount, price,
						description, picName));
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// for (int i = 0; i < tmp.size(); i++) {
		// int ID = tmp.get(i).getCatID();
		// if (ID == categoryID) {
		// tmp2.add(tmp.get(i));
		// }
		// }
		return tmp;
	}
	
	public int getRows(int userID){
		int rownumber = 0;
		try{
			ResultSet rs = state.executeQuery("SELECT * FROM basket_head WHERE userID = " + userID);
			//erstes Ergebnis
			while (rs.next()) {
				rownumber = rs.getInt(1);
				 return rownumber;
			}
			rs.close();
		} catch (Exception e) {

		}
		return rownumber;
	}
	
	public Basket basketExist(int userID){
		Basket basket = null;
		int rownumber = getRows(userID);
		
		if(rownumber == 0){
			basket = new Basket(0, userID, 0);
			try {
				String sql = "INSERT INTO basket_head (userID, totalPrice) VALUES (?, ?)";

				PreparedStatement ps = connect.prepareStatement(sql);
				ps.setInt(1, basket.getUserID());
				ps.setDouble(2, basket.getTotalPrice());
				ps.executeUpdate();

			} catch (Exception e) {
				System.out.println(e);
			}
			return basket;
		} else 
			basket = readBasket(userID);
			
			return basket;
			
	}
	
	public int userExist(String email, String password){
		ArrayList<User> user = readUsers();
		int userID = 0;
		for(User u : user){
			if(email.equals(u.getEmail()) && password.equals(u.getPassword())){
				userID = u.getUserID();
			}
		}
		
		return userID;
	}
	
	public User getUserByUID(int userID){
		ArrayList<User> user = readUsers();
		User u = new User();
		for(User use: user){
			if(userID == use.getUserID()){
				u = use;
			}
		}
		return u;
	}
	
}
