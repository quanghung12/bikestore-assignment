package com.quanghung.bikestore.api.staff;


import com.quanghung.bikestore.dao.staff.Staff;
import com.quanghung.bikestore.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("UpdateStaffsAPI")
@RequestMapping(path = "/staffs")
public class Update {
    @Autowired
    StaffDAO staffDAO;

    @PutMapping(path = "/{staffId}")
    public ResponseEntity Update(@PathVariable int staffId,@RequestBody Request req) {
        Staff a = staffDAO.get(staffId);
        a.setStaff(req.first_name, req.last_name, req.email, req.phone
                , req.active, req.storeId, req.managerId);
        return ResponseEntity.ok(staffDAO.update(a));
    }
    public static class Request {
        public String first_name;
        public String last_name;
        public String email;
        public String phone;
        public int active;
        public int storeId;
        public int managerId;
    }
}
