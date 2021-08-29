package com.quanghung.store.dao.staff;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StaffDAO {
    @Autowired
    SessionFactory sessionFactory;

    public Staff getStaff(int staffId) {
        Session session = sessionFactory.getCurrentSession();
        Staff staff = session.get(Staff.class, staffId);
        return staff;
    }

    public List<Staff> getStaffs() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Staff");
        List<Staff> staffList = query.getResultList();
        return staffList;
    }

    public Staff save(Staff staff) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(staff);
        return staff;
    }


    public void delete(int staffId) {
        Session session = this.sessionFactory.getCurrentSession();
        Staff staff = session.get(Staff.class, staffId);
        if(staff != null) {
            session.delete(staff);
        }
    }
}
