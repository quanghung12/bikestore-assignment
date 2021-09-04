package com.quanghung.store.dao.stock;


import com.quanghung.store.dao.AbstractDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class StockDAO extends AbstractDAO<Stock> {

    public StockDAO() {
        super(Stock.class);
    }

    public Stock getByPrimaryKey(StockPrimaryKey stockId) {
        Session session = sessionFactory.getCurrentSession();
        Stock stock = session.find(Stock.class, stockId);
        return stock;
    }
}
