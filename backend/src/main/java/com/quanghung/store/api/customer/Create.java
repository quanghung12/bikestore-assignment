package com.quanghung.store.api.customer;


import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("CreateCustomerAPI")
@RequestMapping(path = "customers")
public class Create {
    @Autowired
    CustomerDAO customerDAO;

    @PostMapping()
    public Customer create(@RequestBody Request request) {
        Customer customer = new Customer(request.firstName, request.lastName, request.phone,
                request.email, request.street, request.city);
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
