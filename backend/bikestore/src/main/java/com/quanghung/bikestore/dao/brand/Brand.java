package com.quanghung.bikestore.dao.brand;

import com.quanghung.bikestore.dao.product.Product;

import javax.persistence.*;

@Entity
@Table(name="brands")
public class Brand {
    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int brandId;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
