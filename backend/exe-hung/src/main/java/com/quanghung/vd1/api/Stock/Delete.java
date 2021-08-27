package com.quanghung.vd1.api.Stock;


import com.quanghung.vd1.dao.Stock.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("DeleteStocksAPI")
@RequestMapping(path = "/stocks")
public class Delete {
    @Autowired
    StockDAO stockDAO;

    @DeleteMapping(path = "/{storeId}/{productId}")
    public void Delete(@PathVariable int storeId ,@PathVariable int productId) {
        stockDAO.delete(storeId, productId);
    }
}
