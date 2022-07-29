package com.example.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.entity.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public List<Product> findAll() {
		return productRepo.findAll();
	}

	@Override
	public void save(Product p) {
		productRepo.save(p);
		
	}

	@Override
	public Product findById(Integer id) {
		Optional<Product> result = productRepo.findById(id);
		Product p = null;
		
		if(result.isPresent())
			p = result.get();
		
		return p;
	}

	@Override
	public void deleteById(Integer id) {
		productRepo.deleteById(id);
		
	}

	@Override
	public List<Product> findByName(String name) {
		List<Product> results = null;
		
		if(name != null && (name.trim().length() > 0)) {
			results = productRepo.findByName(name);
		}
		else {
			results = findAll();
		}
		return results;
	}
	

	@Override
	public List<Product> findByCategoryId(Integer categoryId) {
		List<Product> results = null;
		
		if(categoryId!= 0 && (categoryId>0)) {
			results = productRepo.findByCategoryId(categoryId);
		}
		else {
			results = findAll();
		}
		
		return results;
	}

}
