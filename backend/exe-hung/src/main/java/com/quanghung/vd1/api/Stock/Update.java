package com.quanghung.vd1.api.Stock;


import com.quanghung.vd1.dao.Stock.Stock;
import com.quanghung.vd1.dao.Stock.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("UpdateStocksAPI")
@RequestMapping(path = "/stocks")
public class Update {
    @Autowired
    StockDAO stockDAO;

    @PutMapping(path = "/{storeId}/{productId}")
    public ResponseEntity Update(@PathVariable int storeId,@PathVariable int productId, @RequestBody Request req) {
        Stock a = stockDAO.get(storeId ,productId);
        a.setStock(req.storeId, req.productId, req.quantity);
        return ResponseEntity.ok(stockDAO.update(a));
    }

    public static class Request {
        public int storeId;
        public int quantity;
        public int productId;
    }
}
