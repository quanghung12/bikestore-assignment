package com.quanghung.store.api.category;

import com.quanghung.store.dao.category.Category;
import com.quanghung.store.dao.category.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@RestController("UpdateCategoriesAPI")
@RequestMapping(path = "/Categories")
public class Update {
    @Autowired
    CategoryDAO categoryDAO;
    @PutMapping(path = "/{categoryId}")
    @Transactional
    public Category update(@PathVariable int categoryId, @RequestBody Request req) {
        Category c = categoryDAO.getCategory(categoryId);
        c.setCategoryName(req.name);
        return categoryDAO.save(c);
    }

    public static class Request{
        public String name;
    }
}


