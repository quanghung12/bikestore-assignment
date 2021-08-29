package com.quanghung.store.api.product;


import com.quanghung.store.dao.product.Product;
import com.quanghung.store.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllProductsAPI")
@RequestMapping(path = "/products")
public class GetAll {
    @Autowired
    ProductDAO productDAO;
    @GetMapping()
    public List<Product> GetAll(@RequestParam(required = false) String q) {
        return productDAO.getProducts(q);
    }

}
