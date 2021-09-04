package com.quanghung.store.dao.store;

import com.quanghung.store.dao.AbstractDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StoreDAO extends AbstractDAO<Store> {
    public StoreDAO() {
        super(Store.class);
    }

}
