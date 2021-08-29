package com.quanghung.store.api.store;


import com.quanghung.store.dao.store.StoreDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteStoresAPI")
@RequestMapping(path = "/stores")
public class Delete {
    @Autowired
    StoreDAO storeDAO;

    @DeleteMapping(path = "/{storeId}")
    public void Delete(@PathVariable int storeId) {
        storeDAO.delete(storeId);
    }
}
