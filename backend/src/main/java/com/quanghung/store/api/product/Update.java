package com.quanghung.store.api.product;


import com.quanghung.store.dao.brand.BrandDAO;
import com.quanghung.store.dao.category.CategoryDAO;
import com.quanghung.store.dao.product.Product;
import com.quanghung.store.dao.product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@RestController("UpdateProductsAPI")
@RequestMapping(path = "/products")
public class Update {
    @Autowired
    ProductDAO productDAO;
    @Autowired
    BrandDAO brandDAO;
    @Autowired
    CategoryDAO categoryDAO;

    @PutMapping(path = "/{productId}")
    @Transactional
    public Product Update(@PathVariable int productId, @RequestBody Request req) {

        Product a = productDAO.getProduct(productId);
        a.setProductName(req.productName);
        a.setBrandId(req.brandId);
        a.setCategoryId(req.categoryId);
        a.setModelYear(req.modelYear);
        a.setListPrice(req.listPrice);
        a.setImageId(req.imageId);
        return productDAO.save(a);
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
