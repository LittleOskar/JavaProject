package de.sycor.bo;

import java.util.ArrayList;
import java.util.List;

public class CategoryList {

	List<Category> cats = new ArrayList<Category>();

	public CategoryList() {

	}

	/**
	 * gibt alle Kategorien aus
	 */
	
	public List<Category> getCategories() {
		return cats;
	}

	public void clearCList(){
		cats.clear();
	}
	
	/**
	 * fügt ein Product zur Arraylist dazu
	 */
	public void addCategory(Category c) {
		cats.add(c);

	}
	
	public void setCategoryList(List<Category> cats){
		this.cats = cats;
	}
	
	/**
	 * sucht nach der nächsthöheren freien id
	 */
	public int getFreeCatId() {
		int id = 0;
		for (int i = 0; i < cats.size(); i++) {
			if (cats.get(i).getID2() > id) {
				Category c = cats.get(i);
				int t = c.getID2();
				id = t;
			}
		}
		id++;
		return id;
	}
	
	/**
	 * gibt Kategorien entsprechend des Suchkriteriums aus
	 */
	public List<Category> searchCat(String categoryName) {
		List<Category> tmp = new ArrayList<Category>();
		for (int i = 0; i < cats.size(); i++) {
			String cName = cats.get(i).getCategoryName();
			if (categoryName.equals(cName) || cName.contains(categoryName)) {
				
				tmp.add(cats.get(i));
			}
		}
		return tmp;
	}
}
