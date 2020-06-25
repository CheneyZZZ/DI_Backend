package com.example.di.Service;

import com.example.di.VO.ResponseVO;

public interface OrderService {
    public ResponseVO getDailySales();

    public ResponseVO getWeeklySales();

    public ResponseVO getDailyMoney();

    public ResponseVO getWeeklyMoney();
}
