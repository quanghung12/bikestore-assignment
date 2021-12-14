package com.quanghung.store.repositories;

import com.quanghung.store.dao.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String name);
}
