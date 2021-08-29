package com.quanghung.store.dao.stock;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class StockPrimaryKey implements Serializable {

    @Column(name = "store_id")
    protected Integer storeId;

    @Column(name = "product_id")
    protected Integer productId;

    public StockPrimaryKey(Integer storeId, Integer productId) {
        this.storeId = storeId;
        this.productId = productId;
    }

    public StockPrimaryKey() {
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
