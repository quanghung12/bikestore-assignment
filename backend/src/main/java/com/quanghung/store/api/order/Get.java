package com.quanghung.store.api.order;

import com.quanghung.store.dao.order.Order;
import com.quanghung.store.dao.order.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetOrdersAPI")
@RequestMapping(path = "/orders")
public class Get {

    @Autowired
    OrderDAO orderDAO;

    @GetMapping(path = "/{orderId}")
    public Order Get(@PathVariable int orderId) {
        return orderDAO.findById(orderId);
    }
}

