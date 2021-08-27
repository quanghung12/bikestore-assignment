package com.quanghung.vd1.api.Customer;

import com.quanghung.vd1.dao.Customer.Customer;
import com.quanghung.vd1.dao.Customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("GetCustomersAPI")
@RequestMapping(path = "/Customers")
public class Get {
    @Autowired
    CustomerDAO customerDAO;

    @GetMapping(path = "/{customerId}")
    public Customer Get(@PathVariable int customerId) {
        return customerDAO.getCustomer(customerId);
    }
}
