package com.example.di.Dao;

import com.example.di.PO.DailyMoney;
import com.example.di.PO.DailyQuantity;
import com.example.di.PO.TakeoutOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class OrderMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public List<DailyQuantity> getDailyQuentity(){
        List<DailyQuantity> dailyQuantities=new ArrayList<>();
        String sql="select * from dws_quantity_d";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            dailyQuantities.add(new DailyQuantity((Date) item.get("dws_item_sale_d.day"), (Long) item.get("dws_item_sale_d.num")));
        }
        return dailyQuantities;
    }

    public List<DailyMoney> getDailyMoney(){
        List<DailyMoney> dailyMonies=new ArrayList<>();
        String sql="select * from dws_amount_d";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            BigDecimal amount=(BigDecimal) item.get("dws_amount_d.amount");
            dailyMonies.add(new DailyMoney((Date) item.get("dws_amount_d.day"),amount.doubleValue()));
        }
        return dailyMonies;
    }

    public List<TakeoutOrder> getTakeoutOrders() {
        List<TakeoutOrder> takeoutOrders=new ArrayList<>();
        String sql="select * from dwd_takeout_orders";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            takeoutOrders.add(new TakeoutOrder((Long) item.get("dwd_takeout_orders.id"),(Timestamp) item.get("dwd_takeout_orders.create_time"),
                    (Byte) item.get("dwd_takeout_orders.type"),(Long) item.get("dwd_takeout_orders.price"),(Integer) item.get("dwd_takeout_orders.discount"),
                    (Long) item.get("dwd_takeout_orders.user_id"),(Long) item.get("dwd_takeout_orders.restaurant_id")));
        }
        return takeoutOrders;
    }
}
