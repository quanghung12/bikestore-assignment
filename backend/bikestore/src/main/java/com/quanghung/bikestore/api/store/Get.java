package com.quanghung.bikestore.api.store;


import com.quanghung.bikestore.dao.store.Store;
import com.quanghung.bikestore.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetStoresAPI")
@RequestMapping(path = "/stores")
public class Get {
    @Autowired
    StoreDAO storeDAO;

    @GetMapping(path = "{storeId}")
    public Store get(@PathVariable int sotreId) {
        return storeDAO.get(sotreId);
    }
}
