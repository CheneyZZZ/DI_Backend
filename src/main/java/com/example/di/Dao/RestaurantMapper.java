package com.example.di.Dao;

import com.example.di.PO.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;


    public Map<Long,Restaurant> getAllResaurants() {
        String sql="select * from dwd_restaurant";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        Map<Long,Restaurant> restaurants=new HashMap<>();
        for(Map<String,Object> item:res){
            Long id=(Long)item.get("dwd_restaurant.id");
            restaurants.put(id,new Restaurant(id,(String)item.get("dwd_restaurant.name"),(String)item.get("dwd_restaurant.location"),(String)item.get("dwd_restaurant.tel")));
        }
        return restaurants;
    }

    public Restaurant getRestaurantById(long id){
        String sql="select * from dwd_restaurant where id="+id;
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        if(res.size()<1){
            return null;
        }
        Map<String,Object> item=res.get(0);
        Restaurant restaurant=new Restaurant((Long)item.get("dwd_restaurant.id"),(String)item.get("dwd_restaurant.name"),(String)item.get("dwd_restaurant.location"),(String)item.get("dwd_restaurant.tel"));
        return restaurant;
    }

}
