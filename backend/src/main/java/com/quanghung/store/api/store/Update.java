package com.quanghung.store.api.store;


import com.quanghung.store.dao.store.Store;
import com.quanghung.store.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("UpdateStoresAPI")
@RequestMapping(path = "/stores")
public class Update {
    @Autowired
    StoreDAO storeDAO;

    @PutMapping(path = "/{storeId}")
    public Store Update(@PathVariable int storeId, @RequestBody Request req) {
        Store store = storeDAO.getStore(storeId);
        store.setStoreName(req.storeName);
        store.setCity(req.city);
        store.setEmail(req.email);
        store.setState(req.state);
        store.setPhone(req.phone);
        store.setZipCode(req.zipCode);
        store.setStreet(req.street);
        return storeDAO.save(store);
    }

    public static class Request {
        public String storeName;
        public String phone;
        public String email;
        public String street;
        public String city;
        public String state;
        public String zipCode;
    }
}
