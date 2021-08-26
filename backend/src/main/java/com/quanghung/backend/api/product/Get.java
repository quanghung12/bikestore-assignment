package com.quanghung.backend.api.product;

import com.quanghung.backend.dao.brand.Brand;
import com.quanghung.backend.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetBrandAPI")
@RequestMapping(path = "/brands")
public class Get {
    @Autowired
    BrandDAO brandDAO;

    @GetMapping(path = "/{brandId}")
    public Brand Get(@PathVariable int brandId) {
        return brandDAO.getBrand(brandId);
    }

}