package com.quanghung.store.dao.product;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "image_id")
    private String imageId;


    public Product() {
    }

    public Product(String productName, int brandId, int
            categoryId, int modelYear, BigDecimal listPrice, String imageId) {
        this.productName = productName;
        this.brandId = brandId;
        this.categoryId = categoryId;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
        this.imageId = imageId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getBrandId() {
        return brandId;
    }


    public int getCategoryId() {
        return categoryId;
    }


    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

}
