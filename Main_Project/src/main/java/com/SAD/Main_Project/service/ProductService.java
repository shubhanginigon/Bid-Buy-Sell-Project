package com.SAD.Main_Project.service;

import com.SAD.Main_Project.model.Product;

import java.text.ParseException;
import java.util.List;

public interface ProductService {

    Product findById(int id);

    List<Product> findAllProducts();

    void save(Product product) throws ParseException;
}
