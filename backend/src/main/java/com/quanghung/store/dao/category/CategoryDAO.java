package com.quanghung.store.dao.category;

import com.quanghung.store.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class CategoryDAO extends AbstractDAO<Category> {
    public CategoryDAO() {
        super(Category.class);
    }
}
