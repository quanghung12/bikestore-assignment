package com.quanghung.store.api.brand;


import com.quanghung.store.dao.brand.Brand;
import com.quanghung.store.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("CreateBrandsAPI")
@RequestMapping("/brands")
public class Create {
    @Autowired
    BrandDAO brandDAO;

    @PostMapping()
    public Brand create(@RequestBody Request request) {
        Brand brand = new Brand(request.name);
        return brandDAO.save(brand);
    }

    public static class Request {
        public String name;
    }
}
