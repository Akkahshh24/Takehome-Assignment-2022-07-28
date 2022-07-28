package com.example.product.service;

import java.util.List;

import com.example.product.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public void save(Product p);
	
	public Product findById(Integer id);
	
	public void deleteById(Integer id);
	
	public List<Product> searchByName(String name);
}
