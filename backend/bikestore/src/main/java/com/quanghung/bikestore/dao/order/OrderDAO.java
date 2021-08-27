package com.quanghung.bikestore.dao.order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Order save(Order o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return o;
    }
}

