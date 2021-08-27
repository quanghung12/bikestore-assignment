package com.quanghung.bikestore.api.store;


import com.quanghung.bikestore.dao.store.Store;
import com.quanghung.bikestore.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllStoresAPI")
@RequestMapping(path = "/stores")
public class GetAll {
    @Autowired
    StoreDAO storeDAO;
    @GetMapping()
    public List<Store> GetAll(@RequestParam(required = false) String q) {
        return storeDAO.getAll(q);
    }

}
