package com.quanghung.store.controller;

import com.quanghung.store.dao.ResponseObject;
import com.quanghung.store.dao.brand.Brand;
import com.quanghung.store.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/brands")
public class BrandController {

    @Autowired
    BrandRepository repository;

    @GetMapping("")
    List<Brand> getALl(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject> getBrandById(@PathVariable Long id) {
        Optional<Brand> foundBrand = repository.findById(id);
        return foundBrand.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok", "Query brand successfully", foundBrand)
                ):
                ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                        new ResponseObject("failed", "Cannot find brand with id: " + id, "")
                );
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertBrand(@RequestBody Brand newBrand) {
        Brand foundBrand = repository.findByBrandName(newBrand.getBrandName().trim());
        if(foundBrand == null) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Insert Brand successfully", repository.save(newBrand))
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("failed", "Brand name already taken", "")
        );
    }

    @PutMapping("{id}")
    ResponseEntity<ResponseObject> updateBrand(@RequestBody Brand newBrand, @PathVariable Long id) {
        Brand updateBrand = repository.findById(id)
                .map(brand -> {
                    brand.setBrandName(newBrand.getBrandName());
                    return repository.save(brand);
                }).orElseGet(() -> {
                    return repository.save(newBrand);
                });
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                new ResponseObject("ok", "Insert brand successfully", repository.save(newBrand))
        );
    }

    @DeleteMapping("{id}")
    ResponseEntity<ResponseObject> deleteBrand(@PathVariable Long id) {
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
