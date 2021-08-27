package com.quanghung.bikestore.api.category;

import com.quanghung.bikestore.dao.category.Category;
import com.quanghung.bikestore.dao.category.categoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllCategoriesAPI")
@RequestMapping(path = "Categories")
public class GetAll {
    @Autowired
    categoryDAO categoryDAO;

    @GetMapping()
    public List<Category> getAll(@RequestParam(required = false) String q) {
        return categoryDAO.getCategories();
    }
}
