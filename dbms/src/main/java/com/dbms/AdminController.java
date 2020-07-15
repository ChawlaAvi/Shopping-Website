package com.dbms;

import java.security.Principal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.dao.Categorydao;
import com.dbms.dao.Orderdao;
import com.dbms.dao.Productdao;
import com.dbms.dao.Userdao;
import com.dbms.dao.Workerdao;
import com.dbms.model.Category;
import com.dbms.model.Orders;
import com.dbms.model.Product;
import com.dbms.model.User;
import com.dbms.model.Userorders;
import com.dbms.model.Worker;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	Categorydao categorydao;
	@Autowired
	Productdao productdao;
	@Autowired
	Workerdao workerdao;
	
	@Autowired	
	Orderdao orderdao;
	
	@Autowired	
	Userdao userdao;
	
	
	@RequestMapping("")
	public ModelAndView admin(Principal principal) {

		ModelAndView model = new ModelAndView("admin");
		String loggedInUserName = principal.getName();
		model.addObject("user", loggedInUserName);
		model.addObject("name", "Spring Security Custom Login Demo");
		model.addObject("description", "Protected page !");
		return model;
	}
	
	@RequestMapping(value = "/addproduct")
	  public ModelAndView allproducts(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("displayallproducts");
	    
	    List<Product> allproducts = productdao.showallproducts();
	    if(allproducts.size()!=0) {
	    	mav.addObject("allproducts", allproducts);
	    	mav.addObject("message", "PRODUCTS");
	    	
	    }
	    else
	    	mav.addObject("message", "NOPRODUCTS");
	    
	    
	    return mav;
	  }
	

	
	@RequestMapping(value = "/customers")
	  public ModelAndView viewcustomers(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("customers");
	    
	    List<User> allcustomers = userdao.allcustomers();
	    if(allcustomers!=null) {
	    	mav.addObject("allcustomers", allcustomers);
	    	mav.addObject("message", "CUSTOMERS");
	    }
	    else {
	    	
	    	mav.addObject("message", "NOCUSTOMERS");
	    }
	    
	    
	    
	
	    return mav;
	  }
	
	@RequestMapping(value = "/customers/{username}")
	  public ModelAndView viewcustomersorders(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="username") String username) {
	    ModelAndView mav = new ModelAndView("usersorders");
	    
	    List<Userorders> userorders = orderdao.getuserorders(username);
	    if(userorders==null)
	    {
	    	mav.addObject("user", username);
	    	mav.addObject("message", "NO ORDERS PLACED!");
	    	
	    }
	    else {
		    mav.addObject("userorders", userorders);
		    mav.addObject("user", username);
		    
	    }
	    return mav;
	  }
	
	@RequestMapping(value = "/customers/{username}/{order_id}")
	  public ModelAndView customerorder(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="username") String username, @PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("usersorders");
	    
	    List<Userorders> userorders = orderdao.getuserorders(username);
	    mav.addObject("userorders", userorders);
	    mav.addObject("user", username);
	
	    return mav;
	  }
	
	@RequestMapping(value = "/addnewproductname", method = RequestMethod.GET )
	  public ModelAndView allnewproductname(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("addnewname");
	    Product product = new Product();
	    mav.addObject("product", product);
	    return mav;
	  }
	@RequestMapping(value = "/addnewproductname", method = RequestMethod.POST )
	  public String allnewproductnameprocess(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("product") Product product, BindingResult result, Model model) {
	    
		if(result.hasErrors()) {
			return "addnewname";
		}
		else {
			
			if(productdao.getproductbyname(product.getProduct_name().toLowerCase())!=null) {
				model.addAttribute("error", "Product exists");
				return "redirect:/admin/addnewproductname";
			}
			productdao.addproducttoproducttable(product);
			
			return "redirect:/admin/addproduct";
	    
		}
	  }
	
	@RequestMapping(value = "/addproduct/{product_id}/categoryadd", method = RequestMethod.GET )
	  public ModelAndView addnewcategorttoproduct(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id) {
	    ModelAndView mav = new ModelAndView("addnewcategory");
	    Product product = productdao.getproductbyid(product_id);
	    Category cat = new Category();
	    List<Category> categories = categorydao.getcategorybyid(product_id);
		 
		if(categories!=null) {
			mav.addObject("allcategories", categories);
			mav.addObject("message", "PRODUCTS");
		}
		else
		{
			mav.addObject("message", "NOPRODUCTS");
		}
	    
	    cat.setProduct_id(product_id);
	    mav.addObject("product", product);
	    mav.addObject("category", cat);
	    
	    return mav;
	  }
	
	@RequestMapping(value = "/addproduct/{product_id}/categoryadd", method = RequestMethod.POST )
	  public String addnewcategorttoproductProcess(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id,  @Valid @ModelAttribute("category") Category cat,  BindingResult result, Model m) {
	    		
		if(result.hasErrors()) {
			m.addAttribute("error", "INVALID");
			return "redirect:/admin/addproduct/{product_id}/categoryadd";
		}
		else {
			
			if(categorydao.getcategorybysizeandid(product_id, cat.getPacket_size())!=null) {
				
				m.addAttribute("error", "PACKET SIZE ALREADY EXISTS");
				return "redirect:/admin/addproduct/{product_id}";
				
			}
		
		categorydao.addcategorytoproduct(cat);
		return "redirect:/admin/addproduct/{product_id}";
		
		}
		
	  }

	@RequestMapping(value = "/addproduct/{product_id}")
	  public ModelAndView allcategories(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id) {
		 ModelAndView mav = new ModelAndView("displayallcategoryproducts");
		 Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 
		 if(categories!=null) {
		 mav.addObject("allcategories", categories);
		 mav.addObject("product", product);
		 mav.addObject("message", "PRODUCTS");
		 }
		 else
		 {
			 mav.addObject("product", product);
			 mav.addObject("message", "NOPRODUCTS");
		 }
		 
		 
	    return mav;
	  }
	@RequestMapping(value = "/addproduct/{product_id}/{packet_size}", method = RequestMethod.GET)
	  public ModelAndView additemtocategory(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, @PathVariable(value="packet_size") int packet_size) {
		 ModelAndView mav = new ModelAndView("addcategoryitem");
		 Product product = productdao.getproductbyid(product_id);
		 Category category = categorydao.getcategorybysizeandid(product_id, packet_size);
		 
		 
		 mav.addObject("category", category);
		 mav.addObject("product", product);
	
	    return mav;
	  }
	
	@RequestMapping(value = "/addproduct/{product_id}/{packet_size}", method = RequestMethod.POST)
	  public String additemtocategoryPROCESS(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, 
			  @PathVariable(value="packet_size") int packet_size,
			  @Valid @ModelAttribute("category") Category category, Model m, BindingResult result) {
		if(result.hasErrors()) {
			m.addAttribute("error", "INVALID");
			return "addcategoryitem";
		}
		
		
		categorydao.updatequantity(category);
		 	
	    return "redirect:/admin/addproduct/{product_id}";
	    
		}
	
	
	@RequestMapping(value = "/allproducts")
	  public ModelAndView viewallproducts(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_products");
	    
	    List<Product> allproducts = productdao.showallproducts();
	    if(allproducts.size()!=0) {
	    	mav.addObject("allproducts", allproducts);
	    	mav.addObject("message", "PRODUCTS");
	    }
	    else{
	    	
	    	mav.addObject("message", "NOPRODUCTS");
	    }
	    return mav;
	  }
	@RequestMapping(value = "/allproducts/{product_id}")
	  public ModelAndView viewcategoriesforproduct(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="product_id") int product_id) {
	    ModelAndView mav = new ModelAndView("view_category");
	    
	    Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 if(categories!=null) {
		 	mav.addObject("allcategories", categories);
		 	mav.addObject("product", product);
		 	mav.addObject("message", "PRODUCTS");
		 }
		 else {
			 mav.addObject("product", product);
			 mav.addObject("message", "NOPRODUCTS");
			 
		 }
	    return mav;
	  }
	
	@RequestMapping(value = "/allproducts/{product_id}/remove")
	  public ModelAndView removeproduct(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="product_id") int product_id) {
	    ModelAndView mav = new ModelAndView("view_category");
	    
	    Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 if(categories!=null) {
		 	mav.addObject("allcategories", categories);
		 	mav.addObject("product", product);
		 	mav.addObject("message", "PRODUCTS");
		 	mav.addObject("show", "yes");
		 }
		 else {
			 mav.addObject("product", product);
			 mav.addObject("message", "NOPRODUCTS");
			 
		 }
	    return mav;
	  }
	@RequestMapping(value = "/allproducts/{product_id}/{packet_size}/remove")
	  public ModelAndView removecategory(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, @PathVariable(value="packet_size") double packet_size) {
	    ModelAndView mav = new ModelAndView("view_category");
	    
	    Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 if(categories!=null) {
		 	mav.addObject("allcategories", categories);
		 	mav.addObject("product", product);
		 	mav.addObject("message", "PRODUCTS");
		 	mav.addObject("showcat", "yes");
		 	mav.addObject("pack", packet_size);
		 }
		 else {
			 mav.addObject("product", product);
			 mav.addObject("message", "NOPRODUCTS");
			 
		 }
	    return mav;
	  }
	
	@RequestMapping(value = "/allproducts/{product_id}/{packet_size}/removeyes")
	  public ModelAndView removecategoryyes(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="product_id") int product_id, @PathVariable(value="packet_size") double packet_size) {
	    ModelAndView mav = new ModelAndView("view_category");
	    
	    categorydao.removecategory(product_id, packet_size);
		productdao.updatefullcarttable();
	    	
	    Product product = productdao.getproductbyid(product_id);
		 List<Category> categories = categorydao.getcategorybyid(product_id);
		 if(categories!=null) {
		 	mav.addObject("allcategories", categories);
		 	mav.addObject("product", product);
		 	mav.addObject("message", "PRODUCTS");
		 	mav.addObject("showcat", "yes");
		 	mav.addObject("pack", packet_size);
		 	mav.addObject("done", "yes");
		 }
		 else {
			 mav.addObject("product", product);
			 mav.addObject("message", "NOPRODUCTS");
			 
		 }
	    return mav;
	  }
	
	@RequestMapping(value = "/allproducts/{product_id}/removeyes")
	  public ModelAndView removePRODUCT(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="product_id") int product_id) {
		ModelAndView mav = new ModelAndView("view_products");
		
		productdao.removeproductbyid(product_id);
		productdao.updatefullcarttable();
		
	    List<Product> allproducts = productdao.showallproducts();
	    if(allproducts!=null) {
	    	mav.addObject("allproducts", allproducts);
	    	mav.addObject("message", "PRODUCTS");
	    }
	    else{
	    	
	    	mav.addObject("message", "NOPRODUCTS");
	    }
	    return mav;
	  }
	
	

	@RequestMapping(value = "/allworkers")
	  public ModelAndView viewworkers(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("view_workers");
	    
	    List<Worker> allworkers = workerdao.viewworkers();
	    if(allworkers.size()!=0) {
	    mav.addObject("allworkers", allworkers);
	    }
	    else
	    {
	    	mav.addObject("message", "NO WORKERS");
	    }
	
	    return mav;
	  }
	@RequestMapping(value = "/allworkers/{worker_id}")
	  public ModelAndView worker_info(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="worker_id") int worker_id) {
	    ModelAndView mav = new ModelAndView("worker_info");
	    
	    Worker worker = workerdao.getworkerbyid(worker_id);
	    mav.addObject("worker", worker);
	    mav.addObject("worker_id", worker_id);
	
	    return mav;
	  }
	
	@RequestMapping(value = "/allworkers/{worker_id}/remove")
	  public ModelAndView removeworker(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="worker_id") int worker_id) {
	    ModelAndView mav = new ModelAndView("worker_info");
	    
	    Worker worker = workerdao.getworkerbyid(worker_id);
	    mav.addObject("worker", worker);
	    mav.addObject("worker_id", worker_id);
	    mav.addObject("check", "yes");
	
	    return mav;
	  }
	
	@RequestMapping(value = "/allworkers/{worker_id}/removeyes")
	  public ModelAndView removeworkeryes(HttpServletRequest request, HttpServletResponse response, @PathVariable(value="worker_id") int worker_id) {
	    ModelAndView mav = new ModelAndView("worker_info");
	    
	    workerdao.removeworkerbyid(worker_id);
	    
	    mav.addObject("message", "WORKER HAS BEEN REMOVED!!");
	    
	    Worker worker = workerdao.getworkerbyid(worker_id);
	    mav.addObject("worker", worker);
	    mav.addObject("worker_id", worker_id);
	    

	    	
	    return mav;
	  }
	
	@RequestMapping(value = "/addworker", method = RequestMethod.GET )
	  public ModelAndView addworker(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("add_worker");
	    Worker worker = new Worker();
	    worker.setStatus("Working");
	    mav.addObject("worker", worker);
	    return mav;
	  }
	
	@RequestMapping(value = "/addworker", method = RequestMethod.POST )
	  public String addworkerProcess(HttpServletRequest request, HttpServletResponse response, @Valid @ModelAttribute("worker") Worker worker, Model model, BindingResult result) {		
		
		System.out.println("asdjhgadsjhkdsajkhdsjkh");
		if(result.hasErrors()) {
			
			
			model.addAttribute("error", "INVALID");
			return "redirect:/admin/addworker";
		}
		else {

		
			
			workerdao.addworker(worker);
			
			
			return "redirect:/admin/allworkers";
	    
		}
	  }
	
	@RequestMapping("/**")
	public String errorpage() {
	    return "error";
	}
	
	@RequestMapping(value = "/orders")
	  public ModelAndView vieworders(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("orders_received");
	    
	    List<Userorders> orders = orderdao.getallorders();
	    
	    if (orders!=null)
	    mav.addObject("orders", orders);
	
	    else
	    	mav.addObject("message", "NO ORDERS RECEIVED!!");
	    
	    return mav;
	  }
	
	@RequestMapping(value = "/orders/{order_id}")
	  public ModelAndView getsummary(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("orderSummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    String username = orderdao.getusernamebyorderid(order_id);
	    
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("username", username);
		mav.addObject("id", order_id);
		mav.addObject("check", "check");
		mav.addObject("date", date);
		mav.addObject("time", time);
		
	    return mav;
	  }
	@RequestMapping(value = "/orders/{order_id}/confirm")
	  public ModelAndView confirm(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("orderSummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    String username = orderdao.getusernamebyorderid(order_id);
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("username", username);
		mav.addObject("check", "confirm");
		mav.addObject("date", date);
		mav.addObject("time", time);
		
	    return mav;
	  }
	
	@RequestMapping(value = "/orders/{order_id}/cancel")
	  public ModelAndView cancel(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("orderSummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    String username = orderdao.getusernamebyorderid(order_id);
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("username", username);
		mav.addObject("check", "cancel");
		mav.addObject("date", date);
		mav.addObject("time", time);
		
	    return mav;
	  }
	
	@RequestMapping(value = "/orders/{order_id}/confirmconfirm")
	  public ModelAndView confirmconfirm(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("orderSummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    
	    orderdao.confirmorder(orders, order_id);
	    
	    String status = orderdao.getstatusforid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    String username = orderdao.getusernamebyorderid(order_id);
	    
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
	    
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("username", username);
		mav.addObject("id", order_id);
		mav.addObject("date", date);
		mav.addObject("time", time);
		
	    return mav;
	  }
	
	@RequestMapping(value = "/orders/{order_id}/cancelconfirm")
	  public ModelAndView cancelconfirm(HttpServletRequest request, HttpServletResponse response,@PathVariable(value="order_id") int order_id) {
	    ModelAndView mav = new ModelAndView("orderSummary");
	    
	    List<Orders> orders = orderdao.getorderbyid(order_id);
	    Date date = orderdao.getdateforid(order_id);
	    Time time = orderdao.gettimeforid(order_id);
	    String username = orderdao.getusernamebyorderid(order_id);
	    orderdao.cancelorder(orders, order_id);
	    
	    String status = orderdao.getstatusforid(order_id);
	    int sum=0;
	    for(int i=0;i<orders.size();i++)
	    {
	    	sum = sum + orders.get(i).getAmount(); 
	    }
	    
		mav.addObject("order", orders);
		mav.addObject("total", sum);
		mav.addObject("status", status);
		mav.addObject("id", order_id);
		mav.addObject("username", username);
		mav.addObject("date", date);
		mav.addObject("time", time);
		
		
	    return mav;
	  }
	

	
}
