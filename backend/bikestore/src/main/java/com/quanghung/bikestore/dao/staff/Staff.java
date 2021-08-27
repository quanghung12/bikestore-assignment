package com.quanghung.bikestore.dao.staff;

import java.util.Map;

public class Staff {
    private int staffId;
    private String firstName;
    private String latsName;
    private String email;
    private String phone;
    private int active;
    private int storeId;
    private int managerId;

    public Staff(Map<String, Object> row) {
        this.staffId = (int) row.get("staff_id");
        this.firstName = (String) row.get("first_name");
        this.latsName = (String) row.get("last_name");
        this.email = (String) row.get("email");
        this.phone = (String) row.get("phone");
        this.active = (int) row.get("active");
        this.storeId = (int) row.get("store_id");
        this.managerId = (Integer) row.get("manager_id");
    }

    public Staff() {
    }

    public Staff(String firstName, String latsName, String email,
                 String phone, int active, int storeId, int managerId) {
        this.firstName = firstName;
        this.latsName = latsName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.storeId = storeId;
        this.managerId = managerId;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLatsName() {
        return latsName;
    }

    public void setLatsName(String latsName) {
        this.latsName = latsName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public void setStaff(String firstName, String latsName, String email,
                         String phone, int active, int storeId, int managerId) {
        this.firstName = firstName;
        this.latsName = latsName;
        this.email = email;
        this.phone = phone;
        this.active = active;
        this.storeId = storeId;
        this.managerId = managerId;
    }
}
