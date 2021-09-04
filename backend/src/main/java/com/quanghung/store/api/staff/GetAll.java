package com.quanghung.store.api.staff;


import com.quanghung.store.dao.staff.Staff;
import com.quanghung.store.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllStaffAPI")
@RequestMapping(path = "/staffs")
public class GetAll {
    @Autowired
    StaffDAO staffDAO;

    @GetMapping()
    public List<Staff> getAll() {
        return staffDAO.getAll();
    }

}
