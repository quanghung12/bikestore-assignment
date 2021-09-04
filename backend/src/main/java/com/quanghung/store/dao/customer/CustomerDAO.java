package com.quanghung.store.dao.customer;

import com.quanghung.store.dao.AbstractDAO;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;

@Repository
@Transactional
public class CustomerDAO extends AbstractDAO<Customer> {

    public CustomerDAO() {
        super(Customer.class);
    }

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
            customer.setStreet(c.getStreet());

            session.saveOrUpdate(customer);
            return customer;
        }

        return c;
    }


}
