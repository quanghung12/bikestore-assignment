package com.quanghung.store.api.customer;

import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetCustomersAPI")
@RequestMapping(path = "/customers")
public class Get {
    @Autowired
    CustomerDAO customerDAO;

    @GetMapping(path = "/{customerId}")
    public Customer Get(@PathVariable int customerId) {
        return customerDAO.findById(customerId);
    }
}
