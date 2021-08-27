package com.quanghung.bikestore.dao.brand;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.Query;
import java.util.List;


@Repository
public class BrandDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Brand getBrand(Integer brandId) {
        Session session = this.sessionFactory.getCurrentSession();
        Brand brand = session.get(Brand.class, brandId);
        return brand;
    }

    public List<Brand> getBrands(String searchString) {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery("from Brand");
        if(searchString != null) {
            qry = session.createQuery("from Brand as b where b.brandName like :searchField");
            qry.setParameter("searchField", searchString);
        }
        List<Brand> brands = qry.getResultList();
        return brands;
    }

    public Brand create(Brand a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(a);
        return a;
    }

    public Brand update(Brand a) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(a);
        return a;
    }

    public void delete(Integer brandId) {
        Session session = this.sessionFactory.getCurrentSession();
        Brand b = getBrand(brandId);
        if (b != null) {
            session.delete(b);
        }
    }
}
