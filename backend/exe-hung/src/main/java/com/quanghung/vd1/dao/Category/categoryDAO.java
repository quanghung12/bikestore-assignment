package com.quanghung.vd1.dao.Category;

import com.quanghung.vd1.dao.Brand.Brand;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class categoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Category getCategory(Integer categoryID) {
        Session session = this.sessionFactory.getCurrentSession();
        Category category = session.get(Category.class, categoryID);
        return category;
    }

    public List<Category> getCategories() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("From categories");
        List<Category> categories = query.getResultList();
        return categories;
    }

    public Category create(Category a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(a);
        return a;
    }

    public Category update(Category a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
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
