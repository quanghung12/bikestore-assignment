package com.quanghung.backend.dao.order;

import com.quanghung.backend.api.order.Create;
import com.quanghung.backend.dao.customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @OneToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;

    @Column(name = "order_status")
    private Status orderStatus;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "required_date")
    private LocalDate requiredDate;

    @Column(name = "Shipped_date")
    private LocalDate shippedDate;

    @Column(name = "store_id")
    private Integer storeId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

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
        this.customer = c;
        this.orderStatus = Status.Processing;
        this.orderDate = LocalDate.now();
        this.requiredDate = LocalDate.now().plusDays(5);
        this.shippedDate = LocalDate.now().plusDays(4);
        this.storeId = request.storeId;
        for(Create.OrderItemRequest o: request.orderItemRequest) {
            this.orderItems.add(new OrderItem(o));
        }

    }
}
