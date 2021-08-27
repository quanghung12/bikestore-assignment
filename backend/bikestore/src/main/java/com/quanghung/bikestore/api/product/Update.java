package com.quanghung.bikestore.api.product;


import com.quanghung.bikestore.dao.brand.Brand;
import com.quanghung.bikestore.dao.category.Category;
import com.quanghung.bikestore.dao.product.Product;
import com.quanghung.bikestore.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController("UpdateProductsAPI")
@RequestMapping(path = "/products")
public class Update {
    @Autowired
    ProductDAO productDAO;

    @PutMapping(path = "/{productId}")
    public ResponseEntity Update(@PathVariable int productId, @RequestBody Request req) {
        Product a = productDAO.getProduct(productId);
        a.setCategory(req.categoryId);
        a.setBrand(req.brandId);
        a.setListPrice(req.listPrice);
        a.setModelYear(req.modelYear);
        a.setProductName(req.productName);
        return ResponseEntity.ok(productDAO.update(a));
    }

    public static class Request {
        public String productName;
        public Brand brandId;
        public Category categoryId;
        public int modelYear;
        public BigDecimal listPrice;
    }
}
