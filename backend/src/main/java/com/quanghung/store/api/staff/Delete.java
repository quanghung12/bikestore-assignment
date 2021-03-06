package com.quanghung.store.api.staff;


import com.quanghung.store.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("DeleteStaffAPI")
@RequestMapping(path = "/staffs")
public class Delete {
    @Autowired
    StaffDAO staffDAO;

    @DeleteMapping(path = "/{staffId}")
    public void delete(@PathVariable int staffId) {
        staffDAO.delete(staffId);
    }
}
