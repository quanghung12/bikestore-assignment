package com.quanghung.bikestore.api.store;


import com.quanghung.bikestore.dao.store.Store;
import com.quanghung.bikestore.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("UpdateStoresAPI")
@RequestMapping(path = "/stores")
public class Update {
    @Autowired
    StoreDAO storeDAO;

    @PutMapping(path = "/{storeId}")
    public ResponseEntity Update(@PathVariable int storeId, @RequestBody Request req) {
        Store a = storeDAO.get(storeId);
        a.setStore(req.storeName, req.phone,
                req.email, req.street, req.city, req.state, req.zip_code);
        return ResponseEntity.ok(storeDAO.update(a));
    }

    public static class Request {
        public String storeName;
        public String phone;
        public String email;
        public String street;
        public String city;
        public String state;
        public String zip_code;
    }
}
