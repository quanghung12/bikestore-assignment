package com.quanghung.store.dao.order;

import com.quanghung.store.api.order.Create;
import com.quanghung.store.dao.customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "order_status")
    private Status orderStatus;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "shipped_date")
    private LocalDate shippedDate;

    @Column(name = "store_id")
    private Integer storeId;

    @Column(name = "staff_id")
    private String staffId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    public enum Status {
        Pending(1), Processing(2), Rejected(3), Completed(4);
        private final int value;

        Status(int value) {
            this.value = value;
        }
        public static Status fromInt(int id) {
            for (Status type : values()) {
                if (type.value == id) {
                    return type;
                }
            }
            return null;
        }

        public Integer toInt() {
            return this.value;
        }

        public String toString() {
            return Integer.toString(value);
        }
    }

    public Order(Create.Request request, Customer c) {
        this.customerId = c.getCustomerId();
        this.orderStatus = Status.Processing;
        this.orderDate = LocalDate.now();
        this.requiredDate = LocalDate.now().plusDays(5);
        this.shippedDate = LocalDate.now().plusDays(4);
        this.storeId = request.storeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(LocalDate requiredDate) {
        this.requiredDate = requiredDate;
    }

    public LocalDate getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(LocalDate shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addOrderItems(OrderItem orderItem) {
        this.orderItems.add(orderItem);
    }

    public void removeOrderItems(OrderItem orderItems) {
        this.orderItems.remove(orderItems);
    }

}
