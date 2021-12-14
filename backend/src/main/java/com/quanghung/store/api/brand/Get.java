package com.quanghung.store.api.brand;


import com.quanghung.store.dao.ResponseObject;
import com.quanghung.store.dao.brand.Brand;
import com.quanghung.store.dao.brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController("GetBrandAPI")
@RequestMapping(path = "/brands")
public class Get {
    @Autowired
    BrandDAO brandDAO;

    @GetMapping(path = "/{brandId}")
    public ResponseEntity<ResponseObject> Get(@PathVariable int brandId) {
        Optional<Brand> foundBrand = brandDAO.findById(brandId);
        return foundBrand.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query brand successfully", foundBrand)
                ):
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Cannot find brand with id: "+ brandId, "")
                );
    }

}
