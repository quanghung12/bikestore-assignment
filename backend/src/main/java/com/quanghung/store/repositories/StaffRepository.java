package com.quanghung.store.repositories;

import com.quanghung.store.dao.staff.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff, Long> {
}
