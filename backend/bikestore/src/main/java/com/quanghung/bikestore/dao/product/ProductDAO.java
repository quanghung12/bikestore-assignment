package com.quanghung.bikestore.dao.product;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Product getProduct(Integer productId) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);
        return product;
    }

    public List<Product> getProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Product");
        List<Product> products = query.getResultList();
        return products;
    }

    public Product create(Product a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(a);
        return a;
    }

    public Product update(Product a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        return a;
    }

    public void delete(int productId) {
        Session session = this.sessionFactory.getCurrentSession();
        Product product = session.get(Product.class, productId);
        if(product != null) {
            session.delete(product);
        }
    }
}
