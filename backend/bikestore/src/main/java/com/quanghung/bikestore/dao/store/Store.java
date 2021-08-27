package com.quanghung.bikestore.dao.store;

import java.util.Map;

public class Store {
    private int storeId;
    private String storeName;
    private String phone;
    private String email;
    private String street;
    private String city;
    private String state;
    private String zip_code;

    public Store(String storeName, String phone, String email,
                 String street, String city, String state, String zip_code) {
        this.storeName = storeName;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }
    public Store(Map<String,Object> row) {
        this.storeName = (String) row.get("store_name");
        this.phone = (String) row.get("phone");
        this.email = (String) row.get("email");
        this.street = (String) row.get("street");
        this.city = (String) row.get("city");
        this.state = (String) row.get("state");
        this.zip_code = (String) row.get("zip_code");
    }
    public Store() {
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setStore(String storeName, String phone, String email,
                         String street, String city, String state, String zip_code) {
        this.storeName = storeName;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;

    }
}
