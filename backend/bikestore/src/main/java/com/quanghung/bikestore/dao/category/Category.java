package com.quanghung.bikestore.dao.category;


import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryID;

    @Column(name = "category_name")
    private String categoryName;


    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public Category() {
    }

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }


    public Integer getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
