package com.quanghung.vd1.api.Stock;


import com.quanghung.vd1.dao.Stock.Stock;
import com.quanghung.vd1.dao.Stock.StockDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("GetAllStocksAPI")
@RequestMapping(path = "/stocks")
public class GetAll {
    @Autowired
    StockDAO stockDAO;
    @GetMapping()
    public List<Stock> GetAll(@RequestParam(required = false) String q) {
        return stockDAO.getAll(q);
    }

}
