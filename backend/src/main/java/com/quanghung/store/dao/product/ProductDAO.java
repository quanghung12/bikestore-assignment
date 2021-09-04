package com.quanghung.store.dao.product;


import com.quanghung.store.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class ProductDAO extends AbstractDAO<Product> {
    public ProductDAO() {
        super(Product.class);
    }
}
