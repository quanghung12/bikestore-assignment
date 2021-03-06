package com.quanghung.store.api.category;

import com.quanghung.store.dao.category.CategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteCategoriesAPI")
@RequestMapping(path = "categories")
public class Delete {
    @Autowired
    CategoryDAO categoryDAO;

    @DeleteMapping(path = "/{categoryID}")
    public void delete(@PathVariable int categoryID) {
        categoryDAO.delete(categoryID);
    }
}
