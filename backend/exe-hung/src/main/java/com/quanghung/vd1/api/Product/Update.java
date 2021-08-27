package com.quanghung.vd1.api.Product;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Category.Category;
import com.quanghung.vd1.dao.Product.Product;
import com.quanghung.vd1.dao.Product.ProductDAO;
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
