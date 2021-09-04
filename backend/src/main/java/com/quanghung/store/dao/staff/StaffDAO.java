package com.quanghung.store.dao.staff;

import com.quanghung.store.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class StaffDAO extends AbstractDAO<Staff> {
    public StaffDAO() {
        super(Staff.class);
    }
}
