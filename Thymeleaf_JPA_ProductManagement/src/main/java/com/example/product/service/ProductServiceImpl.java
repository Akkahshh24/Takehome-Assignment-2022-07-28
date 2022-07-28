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
	public List<Product> searchByName(String name) {
		List<Product> results = null;
		
		if(name != null && (name.trim().length() > 0)) {
			results = productRepo.findByNameLike(name);
		}
		else {
			results = findAll();
		}
		return results;
	}

}
