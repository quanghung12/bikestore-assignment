package com.quanghung.vd1.api.Brand;


import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Brand.BrandDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("CreateBrandsAPI")
@RequestMapping("/brands")
public class Create {
    @Autowired
    BrandDAO brandDAO;

    @PostMapping()
    public ResponseEntity create(@RequestBody Request request) {
        if(request.name == null) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("reason", "name cannot be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
        }
        Brand a = new Brand(request.name);
        return ResponseEntity.ok(brandDAO.create(a));
    }

    public static class Request {
        public String name;
    }
}
