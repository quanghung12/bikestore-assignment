package com.quanghung.vd1.dao.Product;

import com.quanghung.vd1.dao.Brand.Brand;
import com.quanghung.vd1.dao.Category.Category;

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

    @OneToOne()
    @JoinColumn(name = "brand_id", referencedColumnName = "brand_id")
    private Brand brand;

    @OneToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @Column(name = "model_year")
    private int modelYear;

    @Column(name = "list_price")
    private BigDecimal listPrice;

    @Column(name = "image_id")
    private String imageId;


    public Product() {
    }

    public Product(String productName, Brand brand, Category
            category, int modelYear, BigDecimal listPrice, String imageId) {
        this.productName = productName;
        this.brand = brand;
        this.category = category;
        this.modelYear = modelYear;
        this.listPrice = listPrice;
        this.imageId = imageId;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public Brand getBrand() {
        return brand;
    }


    public Category getCategory() {
        return category;
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
