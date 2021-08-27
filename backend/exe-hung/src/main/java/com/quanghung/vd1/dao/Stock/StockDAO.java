package com.quanghung.vd1.dao.Stock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class StockDAO {
    @Autowired
    JdbcTemplate jdbc;

    public Stock get(int storeId, int productId) {
        String sql = String.format(
                "select * from stocks where store_id = %s and product_id = %s",
                storeId, productId
        );
        Map<String, Object> row = jdbc.queryForMap(sql);
        return new Stock(row);
    }


    public List<Stock> getAll(String searchString) {
        String sql = ("Select * from stocks");
        if(searchString != null && !searchString.isEmpty()) {
            sql = String.format(
                    "Select * from stocks where product_id like '%%" +searchString+ "%%'"
            );
        }
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        List<Stock> stocks = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            stocks.add(new Stock(row));
        }
        return stocks;
    }

    public Stock create(Stock a) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = String.format(
                "insert into stocks(store_id, product_id, quantity)" +
                        "values(%s, %s, %s)", a.getStoreId(), a.getProductId(), a.getQuantity()
        );
        jdbc.update(con -> con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), keyHolder);
        return get(a.getStoreId(), a.getStoreId());
    }

    public Stock update(Stock a) {
        String sql = String.format(
                "Update stocks set store_id = %s, product_id = %s, quantity = %s" +
                        " where store_id = %s product_id = %s",
                a.getStoreId(), a.getProductId(), a.getQuantity(), a.getStoreId(), a.getProductId()
        );
        jdbc.execute(sql);
        return get(a.getStoreId(), a.getProductId());
    }

    public void delete(int storeId, int productId) {
        String sql = String.format(
                "Delete from products where product_id = %s and store_id", productId, storeId
        );
        jdbc.execute(sql);
    }
}
