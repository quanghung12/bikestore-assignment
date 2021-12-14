package com.quanghung.store.controller;

import com.quanghung.store.dao.ResponseObject;
import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/customers")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @GetMapping("")
    List<Customer> getALl(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject> getCustomerById(@PathVariable Long id) {
        Optional<Customer> foundCustomer = repository.findById(id);
        return foundCustomer.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query customer successfully", foundCustomer)
                ):
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Cannot find customer with id: " + id, "")
                );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertCustomer(@RequestBody Customer newCustomer) {
        Customer foundCustomer = repository.findByEmail(newCustomer.getEmail().trim());
        if(foundCustomer == null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Insert customer successfully", repository.save(newCustomer))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Customer name already taken", "")
        );
    }

    @PutMapping("{id}")
    ResponseEntity<ResponseObject> updateCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
        Customer updateCustomer = repository.findById(id)
                .map(customer -> {
                    customer.setFirstName(newCustomer.getFirstName());
                    customer.setLastName(newCustomer.getLastName());
                    customer.setStreet(newCustomer.getStreet());
                    customer.setCity(newCustomer.getCity());
                    customer.setPhone(newCustomer.getPhone());
                    customer.setState(newCustomer.getState());
                    customer.setZipCode(newCustomer.getZipCode());
                    return repository.save(customer);
                }).orElseGet(() -> {
                    return repository.save(newCustomer);
                });
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("ok", "Insert customer successfully", repository.save(newCustomer))
        );
    }

    @DeleteMapping("{id}")
    ResponseEntity<ResponseObject> deleteCustomer(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete customer successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Cannot find customer to delete", "")
        );
    }
}
