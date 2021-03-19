package com.SAD.Main_Project.service;

import com.SAD.Main_Project.helpers.LocalDateConverter;
import com.SAD.Main_Project.model.Product;
import com.SAD.Main_Project.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    LocalDateConverter localDateConverter = new LocalDateConverter();

    @Override
    public Product findById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepo.findAll();
    }

    @Transactional
    @Override
    public void save(Product product) throws ParseException {

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
        Date startDate = formatter.parse(product.getStartDate_());
        Date finishDate = formatter.parse(product.getStartDate_());

        java.sql.Date sqlStartDate = localDateConverter.convertUtilDateToSqlDate(startDate);
        java.sql.Date sqlFinishDate = localDateConverter.convertUtilDateToSqlDate(finishDate);

        product.setStartDate(localDateConverter.convertToEntityAttribute(sqlStartDate));
        product.setFinishDate(localDateConverter.convertToEntityAttribute(sqlFinishDate));

        productRepo.save(product);
    }
}
