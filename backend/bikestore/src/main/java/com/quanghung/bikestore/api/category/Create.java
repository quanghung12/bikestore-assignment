package com.quanghung.bikestore.api.category;

import com.quanghung.bikestore.dao.category.Category;
import com.quanghung.bikestore.dao.category.categoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController("CreateCategoriesAPI")
@RequestMapping(path = "/Categories")
public class Create {
    @Autowired
    categoryDAO categoryDAO;
    @PostMapping()
    public ResponseEntity create(@RequestBody Request req) {
        if(req.name == null) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("reason", "name can not be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
        }
        Category a = new Category(req.name);
        return ResponseEntity.ok(categoryDAO.create(a));
    }

    public static class Request {
        public String name;
    }

}
