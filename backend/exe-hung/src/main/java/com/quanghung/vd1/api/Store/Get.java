package com.quanghung.vd1.api.Store;


import com.quanghung.vd1.dao.Store.Store;
import com.quanghung.vd1.dao.Store.StoreDAO;
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
