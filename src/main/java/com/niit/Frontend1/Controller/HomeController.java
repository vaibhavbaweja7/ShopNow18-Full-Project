package com.niit.Frontend1.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



import com.niit.Backend.dao.CatDao;
import com.niit.Backend.dao.ProDao;
import com.niit.Backend.dao.UserDao;
import com.niit.Backend.model.Billing;
import com.niit.Backend.model.Category;
import com.niit.Backend.model.Product;
import com.niit.Backend.model.Shipping;
import com.niit.Backend.model.User;

@Controller
public class HomeController {

	@Autowired
	private Category category;
	@Autowired
	private CatDao catDao;
	@Autowired
	private Product product;
	@Autowired 
	ProDao prodao;
	@Autowired
	private User user;
	@Autowired
	private UserDao userDao;
	@RequestMapping("/")
	public String homePage(HttpSession session)
	{
		session.setAttribute("listCategory", catDao.retrieveCategory());
		return "index";
	}
	 
	 @RequestMapping("/form")
	  public String formPage() 
	  {
		  return "form";
		  
	  }
	 @RequestMapping("/adminHome")
	  public String adminpage()
	  {
	  return "Admin";
	  } 
	 
	 
	 @RequestMapping("/Category")
	  public  String categoryPage(Model model) 
	  {  
		 
	  List<Category> list=catDao.retrieveCategory(); 
		 
		 model.addAttribute("listCategory",list);
		 model.addAttribute("category",category);
		
		  return "Category";
		  
	  }
	 
	 @RequestMapping("/Product")
	 public String productPage(Model model)
	 {
		 List<Product> list=prodao.retrieveProduct(); 
		 
		 model.addAttribute("listProduct",list);
		 model.addAttribute("product",product);
		model.addAttribute("listCategory",catDao.retrieveCategory());
		
		 
	 return "Product";
	 }
	 
@RequestMapping("/index")
public String indexpage()
{return "index";
}

@RequestMapping("/User")
public String loginPage(Model model)
{
	List<User> list=userDao.retrieveUser();
	model.addAttribute("listUser", list);
	model.addAttribute("user", user);
	return "User";
	
}
@RequestMapping("/Login")
public String loginpPage()
{
	return "Login";
}

@RequestMapping("/Signup")
public String signupPage(Model model)
{
	model.addAttribute("user", user);
	return "Signup";
}

@RequestMapping(value = "/addUser", method = RequestMethod.POST)
public String submit(@Valid @ModelAttribute("user") User u, BindingResult result, Model model,RedirectAttributes redirect) {
	if (result.hasErrors()) {
		System.out.println("-- error occurred --");
		return "Signup";
	} else {
		System.out.println("-- UserController -- addUser begins -- ");
		Shipping shipping = new Shipping();
		Billing billing = new Billing();
		user.setBilling(billing);
		user.setShipping(shipping);
		userDao.addUser(u);
		List<User> list=userDao.retrieveUser();
		model.addAttribute("listUser", list);
		
		redirect.addFlashAttribute("success", "You have been registered with ShopNow18");
		return "redirect:/Signup";
	}
}



@RequestMapping("/pCategories/{categoryId}")
public String pCategoriespage(@PathVariable("categoryId")String categoryId,Model model,HttpSession session)
{
	prodao.retrieveProductbyId(categoryId);
	session.setAttribute("getProductbyId", prodao.retrieveProductbyId(categoryId));
	return "pCategories";
}
@RequestMapping("/Productdetails/{productId}")
public String product1page(@PathVariable("productId")String productId,Model model,HttpSession session)

{
	prodao.getProduct(productId);
	session.setAttribute("productDetails",prodao.getProduct(productId));
	return "Productdetails";
}
@RequestMapping("/cart")
public String cartPage()
{
	return "cart";
}

}
