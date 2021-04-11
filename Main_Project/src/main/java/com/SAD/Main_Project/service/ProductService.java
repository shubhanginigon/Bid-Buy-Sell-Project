package com.SAD.Main_Project.service;

import java.text.ParseException;
import java.util.List;

import com.SAD.Main_Project.model.Product;


public interface ProductService {

	Product findById(int id);

	List<Product> findAll();

	void save(Product product);
}
