package com.quanghung.store.api.order;


import com.quanghung.store.dao.order.Order;
import com.quanghung.store.dao.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController("GetAllOrdersAPI")
@RequestMapping(path = "/orders")
public class GetAll {
    @Autowired
    OrderDAO orderDAO;

    @GetMapping
    public List<Order> get(@RequestParam(required = false) String customerName) {
        return orderDAO.getOrderByCustomerName(customerName);
    }


}
