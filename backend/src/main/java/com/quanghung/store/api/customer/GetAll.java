package com.quanghung.store.api.customer;


import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllCustomersAPI")
@RequestMapping(path = "/customers")
public class GetAll {
    @Autowired
    CustomerDAO customerDAO;

    @GetMapping()
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

}
