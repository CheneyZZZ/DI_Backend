package com.example.di.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMapper {
    @Autowired
    @Qualifier("hiveDruidTemplate")
    private JdbcTemplate hiveDruidTemplate;

    public int getFemaleNum(){
        return 0;
    }

    public int getMaleNum(){
        return 0;
    }

    public List<String> getRegins(){
        return null;
    }
}
