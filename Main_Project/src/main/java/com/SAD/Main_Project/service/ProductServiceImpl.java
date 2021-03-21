package com.SAD.Main_Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepo productRepo;

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub

        // Save User
        productRepo.save(product);
		
	}

	@Override
	public Product findProductByPid(int pid) {
		// TODO Auto-generated method stub
		return productRepo.findProductByPid(pid);
	}
	

}
