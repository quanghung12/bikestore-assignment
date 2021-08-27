package com.quanghung.vd1.api.Product;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Category.Category;
import com.quanghung.vd1.dao.Product.Product;
import com.quanghung.vd1.dao.Product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(productDAO.create(a));
    }

    public static class Request {
        public String productName;
        public Brand brandId;
        public Category categoryId;
        public int modelYear;
        public BigDecimal listPrice;
        public String imageId;
    }
}
