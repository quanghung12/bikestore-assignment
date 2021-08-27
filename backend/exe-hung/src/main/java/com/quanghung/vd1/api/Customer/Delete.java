package com.quanghung.vd1.api.Customer;


import com.quanghung.vd1.dao.Customer.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController("DeleteCustomersAPI")
@RequestMapping(path = "/Customers")
public class Delete {
    @Autowired
    CustomerDAO customerDAO;

    @DeleteMapping(path = "/{customerId}")
    public void delete(@PathVariable int customerId) {
        customerDAO.delete(customerId);
    }
}
