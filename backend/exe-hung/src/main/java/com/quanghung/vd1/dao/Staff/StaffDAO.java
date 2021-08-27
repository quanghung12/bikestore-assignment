package com.quanghung.vd1.dao.Staff;

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
public class StaffDAO {
    @Autowired
    JdbcTemplate jdbc;

    public Staff get(int staffId) {
        String sql = String.format(
                "select * from staffs where staff_id = %s", staffId
        );
        Map<String, Object> row = jdbc.queryForMap(sql);
        return new Staff(row);
    }

    public List<Staff> getAll(String searchString) {
        String sql = ("select * from staffs");
        if (searchString != null && !searchString.isEmpty()) {
            sql = String.format(
                    "select * from staffs where last_name like '%%" + searchString + "%%'"
            );
        }
        List<Map<String, Object>> rows = jdbc.queryForList(sql);
        List<Staff> staffs = new ArrayList<>();
        for (Map<String, Object> row:rows) {
            staffs.add(new Staff(row));
        }
        return staffs;
    }

    public Staff create(Staff a) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = String.format(
                "insert into staffs(first_name, last_name, email, phone, active, store_id, manager_id)" +
                        "values('%s','%s','%s','%s',%s,%s,%s)", a.getFirstName(), a.getLatsName(),
                a.getEmail(), a.getPhone(), a.getActive(), a.getStoreId(), a.getManagerId()
        );
        jdbc.update(con -> con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), keyHolder);
        return get(keyHolder.getKey().intValue());
    }

    public Staff update(Staff a) {
        String sql = String.format(
                "update staffs set first_name = '%s', last_name = '%s', email = '%s', phone = '%s'," +
                        "active = %s, store_id= %s,manager_id = %s where staff_id = %s " +
                        "", a.getFirstName(), a.getLatsName(), a.getEmail(),
                a.getPhone(), a.getActive(), a.getStoreId(), a.getManagerId(), a.getStaffId()
        );
        jdbc.execute(sql);
        return get(a.getStaffId());
    }

    public void Delete(int staffId) {
        String sql = String.format(
                "Delete from staff where staff_id = %s", staffId
        );
        jdbc.execute(sql);
    }
}
