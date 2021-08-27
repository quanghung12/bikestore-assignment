package com.quanghung.bikestore.api.order;


import com.quanghung.bikestore.dao.order.Order;
import com.quanghung.bikestore.dao.order.OrderDAO;
import com.quanghung.bikestore.dao.store.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;


@RestController("GetALlOrderAPI")
@RequestMapping(path = "/orders")
public class Get {
    @Autowired
    JdbcTemplate jdbc;

    public List<Map<String, Object>> getOrder(Integer storeId, Order.Status orderStatus, Integer day) {
        LocalDate dateNow;

        String whereClause = "where 1 = 1 and ";
        if(storeId != null) {
            whereClause += String.format("o.store_id = %s and ", storeId);
        }
        if(orderStatus != null) {
            whereClause += String.format("o.order_status = %s and ", orderStatus.toInt());
        }
        if (day != null) {
            dateNow = LocalDate.now();
            LocalDate dateRequired = dateNow.minusDays(day);
            whereClause += String.format("o.order_date > '%s' and o.order_date <= '%s' and ",
                    dateRequired.format(DateTimeFormatter.ISO_DATE), dateNow.format(DateTimeFormatter.ISO_DATE));
        }
        whereClause = whereClause.substring(0, whereClause.length() -4);

        String sql = (
                "select " +
                        "o.order_id as orderId," +
                        "    concat(c.last_name, \" \", c.first_name) as customerName," +
                        "    o.order_date as orderDate," +
                        "    o.required_date as requiredDate," +
                        "    o.shipped_date as shippedDate," +
                        "    concat(s.last_name, \" \", s.last_name) as staffName," +
                        "    sum(oi.list_price*oi.quantity*(1 - oi.discount)) as total," +
                        "    o.order_status as orderStatus" +
                        "    from order_items oi" +
                        "    inner join orders o on o.order_id = oi.order_id" +
                        "    inner join customers c on c.customer_id = o.customer_id" +
                        "    inner join staffs s on s.staff_id = o.staff_id" +
                        "    " + whereClause + " group by oi.order_id" +
                        "    order by oi.order_id desc;"
        );
        List<Map<String, Object>> rows = jdbc.queryForList(sql);

        return rows;
    }


    @GetMapping
    public List<Map<String, Object>> Get(@RequestParam(required = false) Integer storeId,
                                         @RequestParam(required = false) Order.Status orderStatus,
                                         @RequestParam(required = false) Integer day) {

        return getOrder(storeId, orderStatus, day);
    }

}
