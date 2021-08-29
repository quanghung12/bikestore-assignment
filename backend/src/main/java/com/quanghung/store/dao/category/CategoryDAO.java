package com.quanghung.store.dao.category;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Category getCategory(Integer categoryID) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, categoryID);
        return category;
    }

    public List<Category> getCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("From Category");
        List<Category> categories = query.getResultList();
        return categories;
    }

    public Category save(Category a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.saveOrUpdate(a);
        return a;
    }

    public void delete(Integer categoryID) {
        Session session = this.sessionFactory.getCurrentSession();
        Category b = getCategory(categoryID);
        if (b != null) {
            session.delete(b);
        }
    }
}
