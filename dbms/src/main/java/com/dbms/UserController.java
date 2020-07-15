package com.dbms;

import java.security.Principal;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.dao.Cartdao;
import com.dbms.dao.Categorydao;
import com.dbms.dao.Orderdao;
import com.dbms.dao.Productdao;
import com.dbms.dao.Userdao;
import com.dbms.model.Cart;
import com.dbms.model.Category;
import com.dbms.model.Listproducts;
import com.dbms.model.Orders;
import com.dbms.model.Product;
import com.dbms.model.User;
import com.dbms.model.Userorders;


@Controller
public class UserController {

	@Autowired
	Cartdao cartdao;
	@Autowired
	Userdao userdao;
	@Autowired
	Categorydao categorydao;
	@Autowired
	Productdao productdao;
	@Autowired
	Orderdao orderdao;
	
	@RequestMapping("/dashboard")
	public ModelAndView user(Principal principal) {

		ModelAndView model = new ModelAndView("dashboard");
		String loggedInUserName = principal.getName();
		model.addObject("user", loggedInUserName);
		model.addObject("name", "Spring Security USER Custom Login");
		model.addObject("description", "Protected page for user !");
		return model;
	}
	
	@RequestMapping("/profile")
	public ModelAndView viewprofile(Principal principal) {
		
		ModelAndView model = new ModelAndView("profiledetails");
		String username = principal.getName();
		User user = userdao.getCustomerbyusername(username);
		model.addObject("userinfo", user);
		return model;
	}
	
	@RequestMapping(value = "/allproducts")
	  public ModelAndView viewallproducts(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_allproducts");
	    
	    List<Product> allproducts = productdao.showallproducts();
	    mav.addObject("allproducts", allproducts);
	
	    return mav;
	  }
	@RequestMapping(value = "/allproducts/{product_id}")
	  public ModelAndView viewcategoriesforproduct(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="product_id") int product_id) {
	    ModelAndView mav = new ModelAndView("view_allcategory");
	    
	    Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 mav.addObject("allcategories", categories);
		 mav.addObject("product", product);
	
	    return mav;
	  }
	
	@RequestMapping(value = "/myproducts")
	  public ModelAndView viewmycart(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_cart");
	    String loggedInUserName = principal.getName();
	    
	    List<Listproducts> cartproducts = cartdao.showCart(loggedInUserName);
	    int sum=0;
	    if (cartproducts!=null) {
		    for(int i=0;i<cartproducts.size();i++) {
		    	Listproducts lp = cartproducts.get(i);
		    	if (lp.getAvailable()=="IN STOCK") 
		    	{
		    		
		    	int x =lp.getQuantity()*cartproducts.get(i).getPrice();
		    	cartproducts.get(i).setPrice(x);
		    	sum = sum +x;
		    	
		    	}
		    }
		    mav.addObject("sum", sum);
		    mav.addObject("string", "GRAND TOTAL ");
		    mav.addObject("message","CART!!");
	    }
	    else {
	    	
	    	mav.addObject("message","CART IS EMPTY!!");
	    	
	    }
	    mav.addObject("cartproducts", cartproducts);
	    
	    
	    return mav;
	  }
	
	@RequestMapping(value = "/reviewcart")
	  public ModelAndView confirmcart(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("confirmcart");
	    String loggedInUserName = principal.getName();
	    
	    List<Listproducts> cartproducts = cartdao.showCart(loggedInUserName);
	    List<Listproducts> newcartproducts = new ArrayList<Listproducts>();
	    
	    int sum=0;
	    if (cartproducts!=null) {
		    for(int i=0;i<cartproducts.size();i++) {
		    	
		    	Listproducts lp = cartproducts.get(i);
		    	if (lp.getAvailable()=="IN STOCK") 
		    	{
		    	int x =lp.getQuantity()*cartproducts.get(i).getPrice();
		    	cartproducts.get(i).setPrice(x);
		    	sum = sum +x;
		    	newcartproducts.add(lp);
		    	
		    	}
		    }
		    mav.addObject("sum", sum);
		    mav.addObject("string", "GRAND TOTAL = ");
		    if (sum==0)
		    {
		    	mav.addObject("yes", "yes");
		    	
		    }
	    }
	    mav.addObject("cartproducts", newcartproducts);
	    
	
	    return mav;
	  }
	@RequestMapping(value = "/confirmed")
	  public ModelAndView orderplaced(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("placed");
	    String loggedInUserName = principal.getName();
	    
	    List<Listproducts> cartproducts = cartdao.showCart(loggedInUserName);
	    List<Listproducts> newcartproducts = new ArrayList<Listproducts>();
	    int sum=0;
	    if (cartproducts!=null) {
		    for(int i=0;i<cartproducts.size();i++) {
		    	Listproducts lp = cartproducts.get(i);
		    	
		    	if (lp.getAvailable()=="IN STOCK") 
		    	{
			    	int x =lp.getQuantity()*cartproducts.get(i).getPrice();
			    	cartproducts.get(i).setPrice(x);
			    	sum = sum +x;
			    	newcartproducts.add(lp);
		    	
		    	}
	   	
		    }
	    }
	    
	    if(newcartproducts.size()!=0) {
	    
	    	orderdao.placeorder(newcartproducts, sum, loggedInUserName);
	    	mav.addObject("sum", sum);
	        
		    mav.addObject("cartproducts", newcartproducts);
	    	
	    }
	    
	
	    return mav;
	  
	
		}
	
	
	
	@RequestMapping(value = "/myproducts/remove/{product_id}/{packet_size}", method = RequestMethod.GET)
	  public ModelAndView removeproduct(Principal principal, HttpServletRequest request, HttpServletResponse response,@PathVariable(value="product_id") int product_id, @PathVariable(value="packet_size") double packet_size) 
	{
	    ModelAndView mav = new ModelAndView("removeitemfromcart");
	    String loggedInUserName = principal.getName();
	    
	    Listproducts lp = cartdao.getcartitembyusername_pid_psize(loggedInUserName, product_id, packet_size);
	    Category cat = categorydao.getcategorybysizeandid(product_id, packet_size);
		Product p = productdao.getproductbyid(product_id);
		mav.addObject("cat", cat);
		mav.addObject("p", p);
		mav.addObject("lp", lp);
		
	    return mav;
	    
	}
	
	@RequestMapping(value = "/myproducts/remove/{product_id}/{packet_size}", method = RequestMethod.POST)
	  public String removeproductProcess(Principal principal, HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, 
			  @PathVariable(value="packet_size") double packet_size,
			  @Valid @ModelAttribute("lp") Listproducts lp, Model m, BindingResult result) 
		{
			if(result.hasErrors()) 
			{
				m.addAttribute("error", "INVALID");
				return "redirect:/myproducts/remove/{product_id}/{packet_size}";
			}
		
		String loggedInUserName = principal.getName();
		Listproducts check = (Listproducts)cartdao.getcartitembyusername_pid_psize(loggedInUserName,product_id,packet_size );
		Category cat = categorydao.getcategorybysizeandid(product_id, packet_size);
			
		
			if(check.getQuantity()<lp.getQuantity()) 
			{
				m.addAttribute("error", "Entered more number of items than in the cart");
				return "redirect:/myproducts/remove/{product_id}/{packet_size}";
			}
				
			
			if(check.getQuantity()==lp.getQuantity()) {
				cartdao.updateitemincart(loggedInUserName,lp,"remove","yes");}
			else {
				cartdao.updateitemincart(loggedInUserName,lp,"remove","no");
			}
			
				 	
	    return "redirect:/myproducts";
	    
		}
	
	@RequestMapping(value = "/allproducts/{product_id}/{packet_size}/add", method = RequestMethod.GET)
	  public ModelAndView additemtocart(Principal principal, HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, @PathVariable(value="packet_size") double packet_size) {
		 ModelAndView mav = new ModelAndView("addtocart");
		 String loggedInUserName = principal.getName();
		 
		 Listproducts lp = cartdao.getcartitembyusername_pid_psize(loggedInUserName,product_id,packet_size);
		 Category cat = categorydao.getcategorybysizeandid(product_id, packet_size);
		 Product p = productdao.getproductbyid(product_id);
		 mav.addObject("cat", cat);
		 mav.addObject("p", p);

		 if(lp!=null) {
			 mav.addObject("message","Item already in cart!");	
			 mav.addObject("amount", lp.getQuantity());
			 mav.addObject("lp",lp);
			 
		 }
		 else {
			 Listproducts lp1 = new Listproducts();
			 lp1.setPacket_size(packet_size);
			 Product p1 = productdao.getproductbyid(product_id);
			 lp1.setProduct(p1);
			 lp1.setQuantity(0);
			 mav.addObject("message","Item not in Cart");
			 mav.addObject("amount", 0);
			 lp1.setPrice(categorydao.getpricebyidandsize(product_id, packet_size).intValue());
			 if(lp1.getQuantity()>categorydao.getquantitybysizeandid(p1.getProduct_id(), lp1.getPacket_size()).intValue() )
					lp1.setAvailable("NOT IN STOCK");
				else
					lp1.setAvailable("IN STOCK");
			 mav.addObject("lp",lp1);
		 }
		 
	    return mav;
	  }
	
	@RequestMapping(value = "/allproducts/{product_id}/{packet_size}/add", method = RequestMethod.POST)
	  public String additemtocartPROCESS(Principal principal, HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, 
			  @PathVariable(value="packet_size") double packet_size,
			  @Valid @ModelAttribute("lp") Listproducts lp, Model m, BindingResult result) {
		if(result.hasErrors()) {
			m.addAttribute("error", "INVALID");
			return "redirect:/allproducts/{product_id}/{packet_size}/add";}
		
		String loggedInUserName = principal.getName();
		Listproducts check = (Listproducts)cartdao.getcartitembyusername_pid_psize(loggedInUserName,product_id,packet_size );
		Category cat = categorydao.getcategorybysizeandid(product_id, packet_size);
		if(lp.getQuantity()!=0) {	
		if(check!=null)
		{
			if(check.getQuantity()+lp.getQuantity()>cat.getQuantity()) {
				m.addAttribute("error", "Enter Less Quantity");
				return "redirect:/allproducts/{product_id}/{packet_size}/add";
				
			}
			
			cartdao.updateitemincart(loggedInUserName,lp,"add","no");
			
		}
		else
		{
			if(cat.getQuantity()<lp.getQuantity()) {
				m.addAttribute("error", "Enter Less Quantity");
				return "redirect:/allproducts/{product_id}/{packet_size}/add";
				
			}
			
			cartdao.additemincart(loggedInUserName, lp);	
		}
		}
		else
		{
			return "redirect:/allproducts/{product_id}/{packet_size}/add";
			
		}
	    return "redirect:/myproducts";    
		}
	
	@RequestMapping(value = "/emptycart/confirm")
	  public ModelAndView emptycartconfirm(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_cart");
	    String loggedInUserName = principal.getName();
	    cartdao.emptycart(loggedInUserName);
	    List<Listproducts> cartproducts = cartdao.showCart(loggedInUserName);
	    mav.addObject("message", "CART IS EMPTY!!");
	    mav.addObject("cartproducts", cartproducts);
	
	    return mav;
	  }
	
	@RequestMapping(value = "/emptycart")
	  public ModelAndView emptycart(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_cart1");
	    String loggedInUserName = principal.getName();
	    
	    
	    List<Listproducts> cartproducts = cartdao.showCart(loggedInUserName);
	    mav.addObject("cartproducts", cartproducts);
	    mav.addObject("message", "CART!!");
	
	    return mav;
	  }
	
	@RequestMapping(value = "/myorders")
	  public ModelAndView showorders(Principal principal, HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("myorders");
	    String loggedInUserName = principal.getName();
	    
	    List<Userorders> orders= orderdao.getuserorders(loggedInUserName);
	   
	    mav.addObject("orders", orders);
	
	    return mav;
	  }
	@RequestMapping(value = "/myorders/{order_id}")
	  public ModelAndView getsummary(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("myordersummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("check", "check");
		mav.addObject("date", date);
		mav.addObject("time", time);
		
		
	    return mav;
	  }
	@RequestMapping(value = "/myorders/{order_id}/cancel")
	  public ModelAndView cancelcheck(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("myordersummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("check", "checking");
		mav.addObject("date", date);
		mav.addObject("time", time);
		
		
	    return mav;
	  }
	
	@RequestMapping(value = "/myorders/{order_id}/cancelconfirm")
	  public ModelAndView cancelfinal(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("showcancelled");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	   
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
	    
	    

	    orderdao.cancelorder(orders,order_id);
	    String status = orderdao.getstatusforid(order_id);
	    mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("check", "checking");
		mav.addObject("date", date);
		mav.addObject("time", time);	
		 if(!status.equals("Cancelled")) {
		    	
		    	mav.addObject("oops", "ORDER CANNOT BE CANCELLED NOW!!");
		    	return mav;
		    	
		    }
		
	    
	    mav.addObject("message", "ORDER CANCELLED!!");
		
	    return mav;
	  }
	
	
	
}
