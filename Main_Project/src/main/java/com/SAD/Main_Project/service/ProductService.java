package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.Product;

public interface ProductService {
	
	public void save(Product product);

	public Product findProductByPid(int pid);
}
