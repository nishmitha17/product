package com.te.productweb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.te.productweb.beans.ProductInfoBean;
import com.te.productweb.dao.ProductDao;

@Controller
public class ProductController {
    @Autowired
	private ProductDao Dao;
	@GetMapping("/login")
	public String getProductForm() {
		return "productLogin";
	}
	
	@PostMapping("/login")
	public String getProductData(int id,String accessType,HttpServletRequest request,ModelMap map) {
		ProductInfoBean product=Dao.authenticate(id,accessType);
		System.out.println(product);
		if(product!=null) {
			HttpSession session=request.getSession();
			session.setAttribute("loggedIn", product);
			return "productHome";		
		}
		else {
			map.addAttribute("errMsg", "Invalid Credential");
			return "productLogin";
		}
		
	}

}
