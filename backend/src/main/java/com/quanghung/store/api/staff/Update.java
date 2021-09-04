package com.quanghung.store.api.staff;


import com.quanghung.store.dao.staff.Staff;
import com.quanghung.store.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("UpdateStaffsAPI")
@RequestMapping(path = "/staffs")
public class Update {
    @Autowired
    StaffDAO staffDAO;

    @PutMapping(path = "/{staffId}")
    public Staff Update(@PathVariable int staffId,@RequestBody Request req) {
        Staff staff = staffDAO.findById(staffId);
        staff.setFirstName(req.first_name);
        staff.setLatsName(req.last_name);
        staff.setEmail(req.email);
        staff.setPhone(req.phone);
        staff.setManagerId(req.managerId);
        staff.setStoreId(req.storeId);
        return staffDAO.save(staff);
    }
    public static class Request {
        public String first_name;
        public String last_name;
        public String email;
        public String phone;
        public int storeId;
        public int managerId;
    }
}
