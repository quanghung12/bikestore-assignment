package com.quanghung.vd1.api.Order;


import com.quanghung.vd1.dao.Customer.Customer;
import com.quanghung.vd1.dao.Customer.CustomerDAO;
import com.quanghung.vd1.dao.Order.Order;
import com.quanghung.vd1.dao.Order.OrderDAO;
import com.quanghung.vd1.dao.Order.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController("CreateOrderAPI")
@RequestMapping(path = "orders")
public class Create {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    CustomerDAO customerDAO;

    @PostMapping()
    public Order create(@RequestBody Request request) {
        Customer c = new Customer(request.customerRequest);
        c = customerDAO.createIfNotExists(c);

        Order o = new Order(request, c);
        o = orderDAO.save(o);

        for(OrderItemRequest i : request.orderItemRequest) {
            o.addOrderItems(new OrderItem(i, o));
        }

        return orderDAO.save(o);
    }

    public static class Request {
        public CustomerRequest customerRequest;
        public List<OrderItemRequest> orderItemRequest;
        public int storeId;
    }

    public static class CustomerRequest {
        public String firstName;
        public String lastName;
        public String phone;
        public String email;
        public String street;
        public String city;
    }

    public static class OrderItemRequest {
        public int itemId;
        public int productId;
        public int quantity;
        public BigDecimal listPrice;
        public BigDecimal discount;
    }
}
