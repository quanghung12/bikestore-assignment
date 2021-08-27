package com.quanghung.bikestore.api.staff;


import com.quanghung.bikestore.dao.staff.Staff;
import com.quanghung.bikestore.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("CreateStaffsAPI")
@RequestMapping(path = "/staffs")
public class Create {
    @Autowired
    StaffDAO staffDAO;

    @PostMapping()
    public ResponseEntity create(@RequestBody Request req) {
        Staff a = new Staff(req.first_name, req.last_name, req.email, req.phone
                , req.active, req.storeId, req.managerId);
        return ResponseEntity.ok(staffDAO.create(a));
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
