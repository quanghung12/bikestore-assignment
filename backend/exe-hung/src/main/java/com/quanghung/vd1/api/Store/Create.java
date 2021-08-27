package com.quanghung.vd1.api.Store;


import com.quanghung.vd1.dao.Store.Store;
import com.quanghung.vd1.dao.Store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity Create(@RequestBody Request req){
        Store a = new Store(req.storeName, req.phone,
                req.email, req.street, req.city, req.state, req.zip_code);
        return ResponseEntity.ok(storeDAO.create(a));
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
