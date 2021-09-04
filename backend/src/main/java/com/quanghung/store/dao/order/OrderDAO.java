package com.quanghung.store.dao.order;

import com.quanghung.store.dao.AbstractDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class OrderDAO extends AbstractDAO<Order> {


    public OrderDAO() {
        super(Order.class);
    }

    public List<Order> getOrderByCustomerName(String customerName) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery(
                    "from Order");
        if (customerName != null) {
            query = session.createQuery(
                    "from Order as o where o.customer.firstName = :searchString"
            );

            query.setParameter("searchString", customerName);
        }
        List<Order> orders = query.getResultList();
        return orders;
    }
}

