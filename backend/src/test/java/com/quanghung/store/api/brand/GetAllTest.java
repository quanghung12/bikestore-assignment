package com.quanghung.store.api.brand;

import com.quanghung.store.dao.brand.Brand;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GetAllTest {
    List<Brand> list = new GetAll().GetAll();

    @Test
    void getAll() {
        
    }
}