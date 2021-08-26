package com.quanghung.backend.dao.order;

import com.quanghung.backend.api.order.Create;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "order_items")
public class OrderItem {

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "item_id")
    private Integer itemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "discount")
    private BigDecimal discount;

    @Column(name = "quantity")
    private Integer quantity;

    public OrderItem(Create.OrderItemRequest o) {
        this.itemId = o.itemId;
        this.discount = o.discount;
        this.listPrice = o.listPrice;
        this.quantity = o.quantity;
        this.productId = o.productId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
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
