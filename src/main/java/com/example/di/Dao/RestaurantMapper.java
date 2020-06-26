package com.example.di.Dao;

import com.example.di.PO.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;


    public List<Restaurant> getAllResaurants() {
        String sql="select * from dwd_restaurant";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        List<Restaurant> restaurants=new ArrayList<>();
        for(Map<String,Object> item:res){
            restaurants.add(new Restaurant((Long)item.get("dwd_restaurant.id"),(String)item.get("dwd_restaurant.name"),(String)item.get("dwd_restaurant.location"),(String)item.get("dwd_restaurant.tel")));
        }
        return restaurants;
    }
    

}
