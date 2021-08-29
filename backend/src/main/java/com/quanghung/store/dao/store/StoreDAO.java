package com.quanghung.store.dao.store;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StoreDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Store getStore(int storeId) {
        Session session = sessionFactory.getCurrentSession();
        Store store = session.get(Store.class, storeId);
        return store;
    }

    public List<Store> getStores() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Store");
        List<Store> stores = query.getResultList();
        return stores;

    }

    public Store save(Store store) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(store);
        return store;
    }

    public void delete(int storeId) {
        Session session = this.sessionFactory.getCurrentSession();
        Store store = session.get(Store.class, storeId);
        if(store != null) {
            session.delete(store);
        }
    }
}
