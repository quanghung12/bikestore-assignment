package com.quanghung.store.api.store;


import com.quanghung.store.dao.store.Store;
import com.quanghung.store.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("CreateStoresAPI")
@RequestMapping(path = "/stores")
public class Create {
    @Autowired
    StoreDAO storeDAO;

    @PostMapping()
    public Store Create(@RequestBody Request req){
        Store a = new Store(req.storeName, req.phone,
                req.email, req.street, req.city, req.state, req.zipCode);
        return storeDAO.save(a);
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
