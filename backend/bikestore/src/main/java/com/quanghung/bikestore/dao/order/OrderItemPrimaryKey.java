package com.quanghung.bikestore.dao.order;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderItemPrimaryKey implements Serializable {
    OrderItemPrimaryKey() {}

    public OrderItemPrimaryKey(Integer orderId, int itemId) {
        this.orderId = orderId;
        this.itemId = itemId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getItemId() {
        return itemId;
    }

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "item_id")
    private Integer itemId;
}
