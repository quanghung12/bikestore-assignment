package com.quanghung.vd1.api.Category;

import com.quanghung.vd1.dao.Category.Category;
import com.quanghung.vd1.dao.Category.categoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetCategoryAPI")
@RequestMapping(path = "/Categories")
public class Get {
    @Autowired
    categoryDAO categoryDAO;

    @GetMapping(path = "/{categoryID}")
    public Category get(@PathVariable Integer categoryID) {
        return categoryDAO.getCategory(categoryID);
    }
}
