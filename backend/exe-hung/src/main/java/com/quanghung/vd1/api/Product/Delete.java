package com.quanghung.vd1.api.Product;


import com.quanghung.vd1.dao.Product.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteProductsAPI")
@RequestMapping(path = "/products")
public class Delete {
    @Autowired
    ProductDAO productDAO;

    @DeleteMapping(path = "/{productId}")
    public void Delete(@PathVariable int productId) {
        productDAO.delete(productId);
    }
}
