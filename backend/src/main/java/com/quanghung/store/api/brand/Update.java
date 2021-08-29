package com.quanghung.store.api.brand;


import com.quanghung.store.dao.brand.Brand;
import com.quanghung.store.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController("UpdateBrandsAPI")
@RequestMapping(path = "/brands")
public class Update {
    @Autowired
    BrandDAO brandDAO;

    @PutMapping(path = "/{brandId}")
    @Transactional
    public Brand Update(@PathVariable int brandId, @RequestBody Request request) {
        Brand b = brandDAO.getBrand(brandId);
        b.setBrandName(request.name);
        return brandDAO.save(b);
    }

    public static class Request {
        public String name;
    }
}
