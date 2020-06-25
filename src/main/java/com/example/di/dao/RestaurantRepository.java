package com.example.di.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class RestaurantRepository {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;


    public int getNumOfRestaurants(){
        String sql="select count(*) from dwd_restaurant";
        int count=0;
        try {
            hiveDruidTemplate.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
        return count;

    }

}
