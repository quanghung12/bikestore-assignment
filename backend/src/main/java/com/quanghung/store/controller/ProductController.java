package com.quanghung.store.controller;

import com.quanghung.store.dao.ResponseObject;
import com.quanghung.store.dao.product.Product;
import com.quanghung.store.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    @GetMapping("")
    List<Product> getALl(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject> getProductById(@PathVariable Long id) {
        Optional<Product> foundProduct = repository.findById(id);
        return foundProduct.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query brand successfully", foundProduct)
                ):
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Cannot find brand with id: " + id, "")
                );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertProduct(@RequestBody Product newProduct) {
        Product foundBrand = repository.findByProductName(newProduct.getProductName().trim());
        if(foundBrand == null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Insert Brand successfully", repository.save(newProduct))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Brand name already taken", "")
        );
    }

    @PutMapping("{id}")
    ResponseEntity<ResponseObject> updateProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        Product updateBrand = repository.findById(id)
                .map(product -> {
                    product.setProductName(newProduct.getProductName());
                    product.setBrandId(newProduct.getBrandId());
                    product.setCategoryId(newProduct.getCategoryId());
                    product.setListPrice(newProduct.getListPrice());
                    product.setImageId(newProduct.getImageId());
                    product.setModelYear(newProduct.getModelYear());
                    return repository.save(product);
                }).orElseGet(() -> {
                    return repository.save(newProduct);
                });
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("ok", "Insert brand successfully", repository.save(newProduct))
        );
    }

    @DeleteMapping("{id}")
    ResponseEntity<ResponseObject> deleteProduct(@PathVariable Long id) {
        boolean exists = repository.existsById(id);
        if(!exists) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete brand successfully", "")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Cannot find brand to delete", "")
        );
    }
}
