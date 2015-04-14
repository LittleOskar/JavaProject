package de.sycor.bo;

import java.util.ArrayList;
import java.util.List;

public class UserList {
	List<User> user = new ArrayList<User>();

	public UserList() {

	}

	/**
	 * gibt alle User aus
	 */
	
	public List<User> getUsers() {
		return user;
	}

	public void clearUserList(){
		user.clear();
	}
	
	/**
	 * fügt einen User zur Arraylist dazu
	 */
	public void addUser(User u) {
		user.add(u);

	}
	
	public void setUserList(List<User> user){
		this.user = user;
	}
	
	/**
	 * sucht nach der nächsthöheren freien id
	 */
	public int getFreeUserID() {
		int id = 0;
		for (int i = 0; i < user.size(); i++) {
			if (user.get(i).getUserID() > id) {
				User u = user.get(i);
				int t = u.getUserID();
				id = t;
			}
		}
		id++;
		return id;
	}
	
}
