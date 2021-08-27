package com.quanghung.vd1.api.Product;


import com.quanghung.vd1.dao.Product.Product;
import com.quanghung.vd1.dao.Product.ProductDAO;
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
    public List<Product> GetAll() {
        return productDAO.getProducts();
    }

}
