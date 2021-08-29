package com.quanghung.store.dao.customer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Customer createIfNotExists(Customer c) {
        try {
            c = save(c);
        } catch (Exception e) {
            Session session = this.sessionFactory.getCurrentSession();
            session.clear();

            Query query = session.createQuery("from Customer as c where email = :emailCustomerRequest");
            query.setParameter("emailCustomerRequest", c.getEmail());
            Customer customer = (Customer) query.getSingleResult();
            customer.setFirstName(c.getFirstName());
            customer.setEmail(c.getEmail());
            customer.setCity(c.getCity());
            customer.setPhone(c.getPhone());

            session.saveOrUpdate(customer);
            return customer;
        }

        return c;
    }

    public Customer getCustomer(Integer customerId) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, customerId);
        return customer;
    }

    public List<Customer> getCustomers() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Customer");
        List<Customer> customers = query.getResultList();
        return customers;
    }

    public Customer save(Customer a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(a);
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
