//package com.dbms;
//
//import java.security.Principal;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.dbms.dao.Cartdao;
//import com.dbms.dao.Productdao;
//import com.dbms.model.Product;
//
//@Controller
//public class CartController {
//
//	@Autowired
//	Cartdao cartdao;
//	@Autowired
//	Productdao productdao;
//	
//	@RequestMapping(value="/myproducts")
//	public ModelAndView showcart(Principal principal) {
//		
//		ModelAndView model = new ModelAndView("userproducts");
//		String username = principal.getName();
//		List<Product> myproducts= cartdao.showCart(username);
//		model.addObject("myproducts",myproducts);
//		return model;
//	}
//	
//	@RequestMapping(value="/add/{productid}")
//	public String addtocart(Principal principal, @PathVariable(value="productid") int productid) {
//		
//		String username = principal.getName();
//		Product product = productdao.getproductbyid(productid);
//		if(cartdao.checkInCart(username, product)) {
//			return "redirect:/myproducts";
//		}
//		
//		cartdao.addToCart(username, product);
//		return "redirect:/myproducts";
//	}
//	
//	@RequestMapping(value="/remove/{productid}")
//	public String removefromcart(Principal principal, @PathVariable(value="productid") int productid) {
//		
//		String username = principal.getName();
//		Product product = productdao.getproductbyid(productid);
//		
//		cartdao.removeFromCart(username, product);
//		return "redirect:/myproducts";
//	}
//}
