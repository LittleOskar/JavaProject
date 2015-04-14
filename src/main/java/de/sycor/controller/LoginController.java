package de.sycor.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import de.sycor.bo.Category;
import de.sycor.bo.User;

//@SessionAttributes(value= {"user", "loggedIn"})
@Controller
public class LoginController {

	de.sycor.controller.Controller ctr = new de.sycor.controller.Controller();

	@ModelAttribute("categoryList")
	public ArrayList<Category> sidebar() {
		ctr.readFiles("mysql");
		ArrayList<Category> cats = ctr.readCats();
	return cats;
	}
	
	
	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, @ModelAttribute("inputUser") User inputUser,
			ModelAndView model) {
		HttpSession session = request.getSession();
		model.addObject("email", inputUser.getEmail());
		model.addObject("password", inputUser.getPassword());
		// validate E-Mail methode!
		if (inputUser.getEmail() != "" && inputUser.getPassword() != "" && inputUser.getEmail() != null
				&& inputUser.getPassword() != null) {
			int userID = ctr.userExist(inputUser.getEmail(), inputUser.getPassword());
			inputUser = ctr.getUserByUID(userID);
			session.setAttribute("user", inputUser);
		}

		// model.addObject("user", inputUser);

		model.addObject("inputUser", new User());
		System.out.println(inputUser);
		return new ModelAndView("index", "page", "login");
	}
	
	@ModelAttribute("logout")
	public void logout(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.setAttribute("user", null);
	}
}