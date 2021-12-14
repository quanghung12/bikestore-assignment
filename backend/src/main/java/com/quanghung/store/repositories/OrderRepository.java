package com.quanghung.store.repositories;

import com.quanghung.store.dao.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
