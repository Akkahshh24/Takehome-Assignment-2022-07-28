package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.product.entity.Product;
import com.example.product.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/productList")
	public String productListView(Model model) {
		List<Product> productList = productService.findAll();
		model.addAttribute("PRODUCT", productList);
		return "productUI/products.html";
	}
	
	@GetMapping("/showFormForAdd")
	public String productForm(Model model) {
		model.addAttribute("PRODUCT", new Product());
		return "productUI/productform.html";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("PRODUCT") Product p) {
		productService.save(p);
		return "redirect:/products/productList";
	}
	
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("productId") Integer id, Model model) {
		Product p = productService.findById(id);
		model.addAttribute("PRODUCT", p);
		return "productUI/productform.html";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("productId") Integer id) {
		productService.deleteById(id);
		return "redirect:/products/productList";
	}
	
	@GetMapping("/search")
	public String search(@RequestParam("productName") String name, Model model) {
		List<Product> productList = productService.searchByName(name);
		model.addAttribute("PRODUCT", productList);
		return "productUI/productList";
	}

}
