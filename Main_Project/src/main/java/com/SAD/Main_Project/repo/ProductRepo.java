package com.SAD.Main_Project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.SAD.Main_Project.model.Product;

@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepo extends JpaRepository<Product, Integer> {
	
	Product findProductByPid(int pid);
}
