package com.SAD.Main_Project.service;

import java.util.Collections;
import java.util.List;

import com.SAD.Main_Project.helpers.DateConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.repo.ProductRepo;

import javax.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Autowired
	ProductRepo productRepo;

	DateConverter converter = new DateConverter();

	@Transactional
	@Override
	public void save(Product product) {

		LOGGER.info("PRODUCT RECEIVED WITH DETAILS: {}", product);

		// Convert the dates
		product.setStartDate(converter.convertToLocalDateTimeFromString(product.getStartDate_()));
		product.setFinishDate(converter.convertToLocalDateTimeFromString(product.getFinishDate_()));

        productRepo.save(product);
		
	}

	@Override
	public Product findById(int id) {
		return productRepo.findById(id).orElse(new Product());
	}

	@Override
	public List<Product> findAll() {
		List<Product> products = productRepo.findAll();
		Collections.reverse(products);
		return products;
	}
}
