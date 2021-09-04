package com.quanghung.store.dao.brand;

import com.quanghung.store.dao.AbstractDAO;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BrandDAO extends AbstractDAO<Brand> {

    public BrandDAO() {
        super(Brand.class);
    }

}
