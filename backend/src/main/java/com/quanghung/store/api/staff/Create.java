package com.quanghung.store.api.staff;


import com.quanghung.store.dao.staff.Staff;
import com.quanghung.store.dao.staff.StaffDAO;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Staff create(@RequestBody Request request) {
        Staff staff = new Staff(request.firstName, request.lastName, request.phone,
                request.email, request.storeId, request.manageId, request.active);
        return staffDAO.save(staff);
    }

    public static class Request {
        public String firstName;
        public String lastName;
        public String phone;
        public String email;
        public int storeId;
        public Integer manageId;
        public int active;
    }
}
