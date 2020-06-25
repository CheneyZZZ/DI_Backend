package com.example.di.Dao;

import com.example.di.PO.DailyMoney;
import com.example.di.PO.DailySale;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface OrderMapper {
    public List<DailySale> getDailySale();

    public List<DailyMoney> getDailyMoney();
}
