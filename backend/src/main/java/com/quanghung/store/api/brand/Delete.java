package com.quanghung.store.api.brand;


import com.quanghung.store.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteBrandsAPI")
@RequestMapping(path = "/brands")
public class Delete {
    @Autowired
    BrandDAO brandDAO;

    @DeleteMapping(path = "/{brandId}")
    public void delete(int brandId) {
        brandDAO.delete(brandId);
    }
}
