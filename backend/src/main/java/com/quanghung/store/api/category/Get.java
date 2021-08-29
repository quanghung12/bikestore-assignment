package com.quanghung.store.api.category;

import com.quanghung.store.dao.category.Category;
import com.quanghung.store.dao.category.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetCategoryAPI")
@RequestMapping(path = "/Categories")
public class Get {
    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping(path = "/{categoryID}")
    public Category get(@PathVariable Integer categoryID) {
        return categoryDAO.getCategory(categoryID);
    }
}
