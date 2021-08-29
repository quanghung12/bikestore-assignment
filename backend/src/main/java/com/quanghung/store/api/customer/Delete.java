package com.quanghung.store.api.customer;


import com.quanghung.store.dao.customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("DeleteCustomersAPI")
@RequestMapping(path = "/customers")
public class Delete {
    @Autowired
    CustomerDAO customerDAO;

    @DeleteMapping(path = "/{customerId}")
    public void delete(@PathVariable int customerId) {
        customerDAO.delete(customerId);
    }
}
