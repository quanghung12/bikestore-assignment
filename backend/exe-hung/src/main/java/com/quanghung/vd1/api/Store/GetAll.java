package com.quanghung.vd1.api.Store;


import com.quanghung.vd1.dao.Store.Store;
import com.quanghung.vd1.dao.Store.StoreDAO;
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
