package com.quanghung.store.repositories;

import com.quanghung.store.dao.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
