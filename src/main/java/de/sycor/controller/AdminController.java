package de.sycor.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import de.sycor.bo.Product;

@org.springframework.stereotype.Controller
public class AdminController {
	
	de.sycor.controller.Controller ctr = new de.sycor.controller.Controller();
	
//	@RequestMapping(value = "/editProduct")
//	public ModelAndView login(HttpServletRequest request, @ModelAttribute("editedProduct") Product editedProduct, @RequestParam(value = "pID") int pID, ModelAndView model) {
//		HttpSession session = request.getSession();
//		
//		ArrayList<Product> products = ctr.readProducts();
//		Product product = new Product(0, null, 0, 0, 0, null, null);
//		for(Product p : products){
//			if(p.getID() == pID){
//				product = p;
//				System.out.println("current Product: " + product);
//			}
//		}
//		
//		if(editedProduct.getPicName() != "" && editedProduct.getPicName() != null){
//			product.setPicName(editedProduct.getPicName());
//		}
		
		
//		
//		model.addObject("email", inputUser.getEmail());
//		model.addObject("password", inputUser.getPassword());
//		// validate E-Mail methode!
//		if (inputUser.getEmail() != "" && inputUser.getPassword() != "" && inputUser.getEmail() != null
//				&& inputUser.getPassword() != null) {
//			int userID = ctr.userExist(inputUser.getEmail(), inputUser.getPassword());
//			inputUser = ctr.getUserByUID(userID);
//			session.setAttribute("user", inputUser);
//		}

		// model.addObject("user", inputUser);
//		model.addObject("editedProduct", editedProduct);
//		return new ModelAndView("index", "page", "productDetail");
//	}
}
