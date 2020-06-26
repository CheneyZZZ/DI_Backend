package com.example.di.Dao;

import com.example.di.PO.ActiveEvent;
import com.example.di.PO.UserActionRatio;
import com.example.di.PO.UserActive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class FlowMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public List<UserActive> getUserActive(){
        List<UserActive> userActives=new ArrayList<>();
        String sql="select * from dws_user_active_d";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            userActives.add(new UserActive((Date) item.get("dws_user_active_d.day"),(Long)item.get("dws_user_active_d.num")));
        }
        return userActives;
    }

    public List<ActiveEvent> getActiveEvent(){
        List<ActiveEvent> activeEvents=new ArrayList<>();
        String sql="select * from dws_event_active_d";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            activeEvents.add(new ActiveEvent((Date) item.get("dws_event_active_d.day"),(Long)item.get("dws_event_active_d.total"),
                    (Long)item.get("dws_event_active_d.view"),(Long)item.get("dws_event_active_d.cart"),(Long)item.get("dws_event_active_d.buy")));
        }
        return activeEvents;
    }

    public List<UserActionRatio> getUserActionRatio(){
        List<UserActionRatio> userActionRatios=new ArrayList<>();
        String sql="select * from dws_user_ratio where view_cart is not null and view_buy is not null and cart_buy is not null";
        List<Map<String,Object>> res=hiveDruidTemplate.queryForList(sql);
        for(Map<String,Object> item:res){
            BigDecimal view_cart=(BigDecimal) item.get("dws_user_ratio.view_cart");
            BigDecimal view_buy=(BigDecimal)item.get("dws_user_ratio.view_buy");
            BigDecimal cart_buy=(BigDecimal)item.get("dws_user_ratio.cart_buy") ;
            userActionRatios.add(new UserActionRatio((Long)item.get("dws_user_ratio.user_id"),(Byte)item.get("dws_user_ratio.gender"),view_cart.doubleValue(),
                    view_buy.doubleValue(),cart_buy.doubleValue()));
        }
        return userActionRatios;
    }
}
