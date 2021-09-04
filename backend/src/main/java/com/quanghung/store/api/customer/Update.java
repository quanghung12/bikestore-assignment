package com.quanghung.store.api.customer;

import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("UpdateCustomerAPI")
@RequestMapping(path = "customers")
public class Update {
    @Autowired
    CustomerDAO customerDAO;
    @PutMapping(path = "customerId")

    public Customer update(@PathVariable int customerId, @RequestBody Request request) {
        Customer customer = customerDAO.findById(customerId);
        customer.setFirstName(request.firstName);
        customer.setLastName(request.lastName);
        customer.setPhone(request.phone);
        customer.setEmail(request.email);
        customer.setCity(request.city);
        customer.setStreet(request.street);
        return customerDAO.save(customer);
    }

    public static class Request {
        public String firstName;
        public String lastName;
        public String phone;
        public String email;
        public String street;
        public String city;
    }
}
