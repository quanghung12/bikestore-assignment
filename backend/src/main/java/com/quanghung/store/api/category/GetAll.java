package com.quanghung.store.api.category;

import com.quanghung.store.dao.category.Category;
import com.quanghung.store.dao.category.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllCategoriesAPI")
@RequestMapping(path = "categories")
public class GetAll {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping()
    public List<Category> getAll() {
        return categoryDAO.getAll();
    }
}
