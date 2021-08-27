package com.quanghung.bikestore.api.stock;


import com.quanghung.bikestore.dao.stock.Stock;
import com.quanghung.bikestore.dao.stock.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("GetStocksAPI")
@RequestMapping(path = "/stocks")
public class Get {
    @Autowired
    StockDAO stockDAO;

    @GetMapping(path = "/{storeId}/{productId}")
    public Stock get(@PathVariable int storeId, @PathVariable int productId) {
        return stockDAO.get(storeId, productId);
    }
}
