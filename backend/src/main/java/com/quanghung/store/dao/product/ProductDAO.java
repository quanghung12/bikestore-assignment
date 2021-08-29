package com.quanghung.store.dao.product;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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

    public Product save(Product a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(a);
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
