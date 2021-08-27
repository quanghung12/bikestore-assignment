package com.quanghung.bikestore.api.customer;

import com.quanghung.bikestore.dao.customer.Customer;
import com.quanghung.bikestore.dao.customer.CustomerDAO;
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
