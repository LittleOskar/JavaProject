package de.sycor.bo;

public class User {
	private int userID;
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String street;
	private int plz;
	private String town;
	private int admin;

	public User() {

	}

	public User(int userID, String email, String password, String firstname, String lastname, String street, int plz, String town, int admin) {
		this.userID = userID;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.plz = plz;
		this.town = town;
		this.admin = admin;
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String street){
		this.street = street;
	}
	
	public int getPlz(){
		return plz;
	}
	
	public void setPlz(int plz){
		this.plz = plz;
	}
	
	public String getTown(){
		return town;
	}
	
	public void setTown(String town){
		this.town = town;
	}
	
	public int getAdmin(){
		return admin;
	}
	
	public void setAdmin(int admin){
		this.admin = admin;
	}
	
	public String toString() {
		return userID + email + password + firstname + lastname + street + plz + town + admin;
	}
}