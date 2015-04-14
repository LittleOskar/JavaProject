package de.sycor.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import de.sycor.bo.Basket;
import de.sycor.bo.Category;
import de.sycor.bo.Product;
import de.sycor.bo.User;

@Controller
public class SiteController {

	de.sycor.controller.Controller ctr = new de.sycor.controller.Controller();

	@ModelAttribute("categoryList")
	public ArrayList<Category> sidebar() {
		ctr.readFiles("mysql");
		ArrayList<Category> cats = ctr.readCats();
		return cats;
	}
	
	@ModelAttribute("mostbought")
	public ArrayList<Product> mostbought() {
		ctr.readFiles("mysql");
		ArrayList<Product> mostbought = new ArrayList<Product>();
		ArrayList<Product> products = ctr.readProducts();
		
		for(Product p : products){
			if(p.getID() <= 2){
				mostbought.add(p);
			}
		}
		
		return mostbought;
		
	}
	
	//
	// @ModelAttribute("productList")
	// public ArrayList<Product> productList() {
	// ctr.readFiles("mysql");
	// ArrayList<Product> productList = ctr.readProducts();
	// return productList;
	// }
	//
	// @ModelAttribute("basket")
	// public Basket basketList(@RequestParam(value="userID") int userID) {
	// ctr.readFiles("mysql");
	// Basket basket = ctr.readBasket(userID);
	// return basket;
	// }

	@RequestMapping(value = { "/", "/home" })
	public ModelAndView index() {
		ModelAndView model = new ModelAndView("index", "page", "home");
		ctr.readFiles("mysql");
		ArrayList<Product> products = ctr.readProducts();
		ArrayList<Product> tmp = products;
		ArrayList<Product> latest = new ArrayList<Product>();

		for (int i = 1; i <= 6; i++) {
			Product p = tmp.get(tmp.size() - i);
			latest.add(p);
		}

		model.addObject("latestProducts", latest);
		return model;
	}

	@RequestMapping("/products")
	public ModelAndView products() {
		ModelAndView model = new ModelAndView("index", "page", "products");
		ctr.readFiles("mysql");
		ArrayList<Product> products = ctr.readProducts();

		model.addObject("products", products);
		return model;
	}

	@RequestMapping("/cats_products")
	public ModelAndView cats_products(@RequestParam(value = "catID") int catID, @RequestParam(value = "detailPage", defaultValue="false") boolean detailPage) {
		ModelAndView model;
		
		if(detailPage == true){
			model = new ModelAndView("cats_products");
		} else{
		model = new ModelAndView("index", "page", "cats_products");
		}
		ctr.readFiles("mysql");
		ArrayList<Product> cats_products = new ArrayList<Product>();
		cats_products.clear();
		cats_products = (ArrayList<Product>) ctr.showPbyCId(catID);

		model.addObject("cats_products", cats_products);

		return model;
	}

	@RequestMapping("/categories")
	public ModelAndView categories() {
		ModelAndView model = new ModelAndView("index", "page", "categories");
		ctr.readFiles("mysql");
		ArrayList<Category> cats = new ArrayList<Category>();
		cats.clear();
		cats = ctr.readCats();

		model.addObject("cats", cats);

		return model;
	}

	@RequestMapping("/productDetail")
	public ModelAndView productDetail(@RequestParam(value = "pID") int pID) {
		ModelAndView model = new ModelAndView("index", "page", "productDetail");
		ctr.readFiles("mysql");
		Product pr = null;
		pr = ctr.getProduct(pID);
		model.addObject("product", pr);

		return model;
	}

}
