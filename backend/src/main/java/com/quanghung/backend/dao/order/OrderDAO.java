package com.quanghung.backend.dao.order;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAO {
    @Autowired
    SessionFactory sessionFactory;

}
