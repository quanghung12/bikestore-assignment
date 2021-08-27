package com.quanghung.bikestore.dao.order;

import com.quanghung.bikestore.api.order.Create;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @EmbeddedId
    private OrderItemPrimaryKey orderItemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderItem(Create.OrderItemRequest i, Order o) {
        this.orderItemId = new OrderItemPrimaryKey(o.getOrderId(), i.itemId);
        this.discount = i.discount;
        this.listPrice = i.listPrice;
        this.quantity = i.quantity;
        this.productId = i.productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
