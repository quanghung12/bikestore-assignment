package com.quanghung.bikestore.dao.stock;

import java.util.Map;

public class Stock {
    private int storeId;
    private int productId;
    private int quantity;

    public Stock() {
    }
    public Stock(Map<String, Object> row) {
        this.storeId = (int) row.get("store_id");
        this.productId = (int) row.get("product_id");
        this.quantity = (int) row.get("quantity");
    }

    public Stock(int storeId, int productId, int quantity) {
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStock(int storeId, int productId, int quantity) {
        this.storeId = storeId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
