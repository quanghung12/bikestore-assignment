package com.quanghung.bikestore.api.category;

import com.quanghung.bikestore.dao.category.Category;
import com.quanghung.bikestore.dao.category.categoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController("UpdateCategoriesAPI")
@RequestMapping(path = "/Categories")
public class Update {
    @Autowired
    categoryDAO categoryDAO;
    @PutMapping(path = "/{categoryID}")
    public ResponseEntity update(@PathVariable int categoryID, @RequestBody Request req) {
        if(req.name == null) {
            Map<String, String> errorBody = new HashMap<>();
            errorBody.put("reason", "name can not be null");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorBody);
        }
        Category a = categoryDAO.getCategory(categoryID);
        a.setCategoryName(req.name);
        return ResponseEntity.ok(categoryDAO.update(a));
    }

    public static class Request{
        public String name;
    }
}


