package com.quanghung.vd1.api.Brand;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllBrandsAPI")
@RequestMapping(path = "/brands")
public class GetAll {
    @Autowired
    BrandDAO brandDAO;

    @GetMapping
    public List<Brand> GetAll(@RequestParam(required = false) String q) {
        return brandDAO.getBrands(q);
    }
}
