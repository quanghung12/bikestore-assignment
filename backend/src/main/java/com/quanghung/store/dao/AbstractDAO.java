package com.quanghung.store.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
public abstract class AbstractDAO<T> {
    @Autowired
     protected SessionFactory sessionFactory;

    private Class<T> tClass;

    public AbstractDAO(Class<T> tClass) {
        this.tClass = tClass;
    }

    public Optional<T> findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        T entity = session.get(tClass, id);
        Optional<T> optional = Optional.ofNullable(entity);
        return optional;
    }

    public List<T> getAll() {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery("from " + tClass.getName());

        List<T> entities = qry.getResultList();
        return entities;
    }

    public T save(T entity) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(entity);
        return entity;
    }

/*    public void delete(Integer brandId) {
        Session session = this.sessionFactory.getCurrentSession();
        Optional<entity> = findById(brandId);
        if () {
            session.delete(entity);
        }
    }*/
}
