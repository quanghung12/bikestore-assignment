package com.quanghung.store.api.product;


import com.quanghung.store.dao.product.Product;
import com.quanghung.store.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetProductsAPI")
@RequestMapping(path = "/products")
public class Get {
    @Autowired
    ProductDAO productDAO;

    @GetMapping(path = "{productId}")
    public Product get(@PathVariable int productId) {
        return productDAO.findById(productId);
    }
}
