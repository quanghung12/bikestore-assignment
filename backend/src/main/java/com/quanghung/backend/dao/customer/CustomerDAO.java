package com.quanghung.backend.dao.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;


@Repository
public class CustomerDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Customer createIfNotExists(Customer c) {
        try {
            create(c);
        } catch (Exception e) {
            update(c);
        }
        return getCustomerEmail(c.getEmail());
    }


    public Customer getCustomer(Integer customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        return customer;
    }

    public Customer getCustomerEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, email);
        return customer;
    }

    public List<Customer> getAllCustomer() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("From customers");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    public Customer create(Customer a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(a);
        return a;
    }

    public Customer update(Customer a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        return a;
    }

    public void delete(Integer customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer a = getCustomer(customerId);
        if (a != null) {
            session.delete(a);
        }
    }

}
