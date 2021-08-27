package com.quanghung.vd1.api.Brand;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Brand.BrandDAO;
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
