package com.quanghung.store.api.brand;


import com.quanghung.store.dao.brand.Brand;
import com.quanghung.store.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllBrandsAPI")
@RequestMapping(path = "/brands")
public class GetAll {
    @Autowired
    BrandDAO brandDAO;

    @GetMapping
    public List<Brand> GetAll() {
        return brandDAO.getAll();
    }
}
