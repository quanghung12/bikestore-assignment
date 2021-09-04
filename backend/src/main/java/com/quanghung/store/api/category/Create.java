package com.quanghung.store.api.category;

import com.quanghung.store.dao.category.Category;
import com.quanghung.store.dao.category.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("CreateCategoriesAPI")
@RequestMapping(path = "/categories")
public class Create {
    @Autowired
    CategoryDAO categoryDAO;
    @PostMapping()
    public Category create(@RequestBody Request req) {
        Category category = new Category(req.name);
        return categoryDAO.save(category);
    }

    public static class Request {
        public String name;
    }

}
