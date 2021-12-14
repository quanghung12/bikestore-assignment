package com.quanghung.store.dao.brand;


import javax.persistence.*;

@Entity
@Table(name="brands")
public class Brand {
    @Id
    @Column(name = "brand_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long brandId;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    public Brand() {
    }

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
