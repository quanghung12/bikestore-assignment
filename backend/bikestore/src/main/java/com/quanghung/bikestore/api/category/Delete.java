package com.quanghung.bikestore.api.category;

import com.quanghung.bikestore.dao.category.categoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteCategoriesAPI")
@RequestMapping(path = "Categories")
public class Delete {
    @Autowired
    categoryDAO categoryDAO;

    @DeleteMapping(path = "/{categoryID}")
    public void delete(@PathVariable int categoryID) {
        categoryDAO.delete(categoryID);
    }
}
