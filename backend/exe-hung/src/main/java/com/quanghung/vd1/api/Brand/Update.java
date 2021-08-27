package com.quanghung.vd1.api.Brand;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("UpdateBrandsAPI")
@RequestMapping(path = "/brands")
public class Update {
    @Autowired
    BrandDAO brandDAO;

    @PutMapping(path = "/{brandId}")
    public ResponseEntity Update(@PathVariable int brandId, @RequestBody Request request) {
        if(request.name == null) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("reason", "name cannot be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
        }
        Brand a = brandDAO.getBrand(brandId);
        a.setBrandName(request.name);
        return ResponseEntity.ok(brandDAO.update(a));
    }

    public static class Request {
        public String name;
    }
}
