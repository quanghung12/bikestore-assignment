package com.quanghung.store.api.product;


import com.quanghung.store.dao.product.Product;
import com.quanghung.store.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController("CreateProductsAPI")
@RequestMapping(path = "/products")
public class Create {
    @Autowired
    ProductDAO productDAO;

    @PostMapping()
    public ResponseEntity Create(@RequestBody Request req){
        Product a = new Product(req.productName, req.brandId,
                req.categoryId, req.modelYear, req.listPrice, req.imageId);
        return ResponseEntity.ok(productDAO.save(a));
    }

    public static class Request {
        public String productName;
        public int brandId;
        public int categoryId;
        public int modelYear;
        public BigDecimal listPrice;
        public String imageId;
    }
}
