package com.example.di.Dao;

import com.example.di.PO.ActiveEvent;
import com.example.di.PO.UserActionRatio;
import com.example.di.PO.UserActive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public List<UserActive> getUserActive(){
        return null;
    }

    public List<ActiveEvent> getActiveEvent(){
        return null;
    }

    public List<UserActionRatio> getUserActionRatio(){
        return null;
    }
}
