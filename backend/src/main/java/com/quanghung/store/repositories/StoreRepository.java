package com.quanghung.store.repositories;

import com.quanghung.store.dao.store.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
