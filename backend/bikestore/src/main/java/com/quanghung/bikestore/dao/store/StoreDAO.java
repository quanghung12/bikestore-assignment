package com.quanghung.bikestore.dao.store;

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
public class StoreDAO {
    @Autowired
    JdbcTemplate jdbc;

    public Store get(int storeId) {
        String sql = String.format(
                "Select * from stores where store_id = %s", storeId
        );
        Map<String, Object> row = jdbc.queryForMap(sql);
        return new Store(row);
    }

    public List<Store> getAll(String searchString) {
        String sql = ("Select * from stores");
        if(searchString != null && !searchString.isEmpty()) {
            sql = String.format(
                    "Select * from products where store_name like '%%" +searchString+ "%%'"
            );
        }
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        List<Store> stores = new ArrayList<>();
        for (Map<String, Object> row: rows) {
            stores.add(new Store(row));
        }
        return stores;
    }

    public Store create(Store a) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = String.format(
                "insert into stores(store_name, phone, email, street, city, state, zip_code)" +
                        "values('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                a.getStoreName(), a.getPhone(), a.getEmail(), a.getStreet(),
                a.getCity(), a.getState(), a.getZip_code()
        );
        jdbc.update(con -> con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), keyHolder);
        return get(keyHolder.getKey().intValue());
    }

    public Store update(Store a) {
        String sql = String.format(
                "Update products set store_name = '%s', phone = '%s', email = '%s'," +
                        "street = '%s', city = '%s', state = '%s'" +
                        "zip_code = '%s'  where store_id = %s",
                a.getStoreName(), a.getPhone(), a.getEmail(), a.getStreet(),
                a.getCity(), a.getState(), a.getZip_code(), a.getStoreId()
        );
        jdbc.execute(sql);
        return get(a.getStoreId());
    }

    public void Delete(int storeId) {
        String sql = String.format(
                "Delete from stores where storeId = %s", storeId
        );
        jdbc.execute(sql);
    }
}
