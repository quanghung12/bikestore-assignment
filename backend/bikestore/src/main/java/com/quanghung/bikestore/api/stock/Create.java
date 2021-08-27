package com.quanghung.bikestore.api.stock;


import com.quanghung.bikestore.dao.stock.Stock;
import com.quanghung.bikestore.dao.stock.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController("CreateStocksAPI")
@RequestMapping(path = "/stocks")

public class Create {
    @Autowired
    StockDAO stockDAO;

    @PostMapping()
    public ResponseEntity Create(@RequestBody Request req){
        Stock a = new Stock(req.storeId, req.productId, req.quantity);
        return ResponseEntity.ok(stockDAO.create(a));
    }

    public static class Request {
        public int storeId;
        public int quantity;
        public int productId;
    }
}
