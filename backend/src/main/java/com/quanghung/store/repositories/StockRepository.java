package com.quanghung.store.repositories;

import com.quanghung.store.dao.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
