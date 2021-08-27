package com.quanghung.vd1.api.staff;


import com.quanghung.vd1.dao.Staff.Staff;
import com.quanghung.vd1.dao.Staff.StaffDAO;
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
    public List<Staff> getAll(@RequestParam(required = false) String q) {
        return staffDAO.getAll(q);
    }

}
