package com.quanghung.store.dao.stock;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class StockDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Stock get(StockPrimaryKey stockId) {
        Session session = sessionFactory.getCurrentSession();
        Stock stock = session.find(Stock.class, stockId);
        return stock;
    }

    public Stock update(Stock s) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(s);
        return s;
    }
}
