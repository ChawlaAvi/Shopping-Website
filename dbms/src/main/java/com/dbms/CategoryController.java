package com.dbms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dbms.dao.Categorydao;
import com.dbms.dao.Productdao;
import com.dbms.model.Category;
import com.dbms.model.Product;


@Controller
public class CategoryController {

  @Autowired
  Categorydao categorydao;
  @Autowired
  Productdao productdao;
  
//  @RequestMapping(value = "/categories")
//  public ModelAndView allcategories(HttpServletRequest request, HttpServletResponse response) {
//    ModelAndView mav = new ModelAndView("allcategories");
//    
//    List<Category> allcategories = categorydao.showallcategories();
//    mav.addObject("allcategories", allcategories);
//
//    return mav;
//  }
//  @RequestMapping(value = "/categories/{categoryid}")
//  public ModelAndView categoryproducts(HttpServletRequest request, HttpServletResponse response, @PathVariable(value = "categoryid") int categoryid) {
//    ModelAndView mav = new ModelAndView("categoryproducts");
//    
//    List<Product> categoryproducts = productdao.showallproductsbycategory(categoryid);
//    Category category = categorydao.getcategorybyid(categoryid);
//    
//    mav.addObject("categoryproducts", categoryproducts);
//    mav.addObject("category",category);
//
//    return mav;
//  }
  
}
