package com.quanghung.store.dao.order;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public class OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Order save(Order o) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(o);
        return o;
    }

    public Order get(Integer OrderId) {
        Session session = sessionFactory.getCurrentSession();
        Order order = session.find(Order.class, OrderId);
        return order;
    }

    public OrderItem saveOrderItem(OrderItem o) {
        Session session = sessionFactory.getCurrentSession();
        session.save(o);
        return o;
    }

}

