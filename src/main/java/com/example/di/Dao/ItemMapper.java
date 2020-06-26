package com.example.di.Dao;

import com.example.di.PO.DailySale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class ItemMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public List<DailySale> getDailySale(){
        List<DailySale> dailySales=new ArrayList<>();
        String sql="select * from dws_item_sale_d";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            dailySales.add(new DailySale((Date) item.get("dws_item_sale_d.day"),(Long) item.get("dws_item_sale_d.num")));
        }
        Collections.sort(dailySales);
        return dailySales;
    }
}
