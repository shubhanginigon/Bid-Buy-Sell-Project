package com.SAD.Main_Project.service;

import java.util.List;

import com.SAD.Main_Project.model.Product;

public interface ProductService {
	
	public void save(Product product);

	public List<Product> findAll();
}
