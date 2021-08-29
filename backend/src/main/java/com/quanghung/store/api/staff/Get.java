package com.quanghung.store.api.staff;

import com.quanghung.store.dao.staff.Staff;
import com.quanghung.store.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetStaffsAPI")
@RequestMapping(path = "/staffs")
public class Get {
    @Autowired
    StaffDAO staffDAO;

    @GetMapping(path = "/{staffId}")
    public Staff Get(@PathVariable int staffId) {
        return staffDAO.getStaff(staffId);
    }
}
