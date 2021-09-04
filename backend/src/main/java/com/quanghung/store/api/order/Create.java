package com.quanghung.store.api.order;


import com.quanghung.store.dao.customer.Customer;
import com.quanghung.store.dao.customer.CustomerDAO;
import com.quanghung.store.dao.order.Order;
import com.quanghung.store.dao.order.OrderDAO;
import com.quanghung.store.dao.order.OrderItem;
import com.quanghung.store.dao.stock.Stock;
import com.quanghung.store.dao.stock.StockDAO;
import com.quanghung.store.dao.stock.StockPrimaryKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;

@RestController("CreateOrderAPI")
@RequestMapping(path = "/orders")
public class Create {
    @Autowired
    OrderDAO orderDAO;
    @Autowired
    CustomerDAO customerDAO;
    @Autowired
    StockDAO stockDAO;

    @PostMapping
    @Transactional
    public Order create(@RequestBody Request request) {
        Customer c = new Customer(request.customerRequest);
        c = customerDAO.createIfNotExists(c);

        Order o = new Order(request, c);
        o = orderDAO.save(o);

        for(OrderItemRequest i : request.orderItemRequest) {
            OrderItem orderItem = new OrderItem(i, o);
            o.addOrderItems(orderItem);
            deductStock(request.storeId, orderItem);
        }

        return orderDAO.save(o);
    }

    private void deductStock(Integer storeId, OrderItem orderItem) {
        StockPrimaryKey stockPrimaryKey = new StockPrimaryKey(storeId, orderItem.getProductId());
        Stock stock = stockDAO.getByPrimaryKey(stockPrimaryKey);
        stock.deductQuantity(orderItem.getQuantity());
        stockDAO.save(stock);
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
