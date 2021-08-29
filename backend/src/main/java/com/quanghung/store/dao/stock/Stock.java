package com.quanghung.store.dao.stock;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {
    @EmbeddedId
    private StockPrimaryKey stockID;

    @Column(name = "quantity")
    private int quantity;

    public Stock() {
    }

    public StockPrimaryKey getStockID() {
        return stockID;
    }

    public void setStockID(StockPrimaryKey stockID) {
        this.stockID = stockID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void deductQuantity(int quantity) {
        this.quantity = this.quantity - quantity;
    }
}
