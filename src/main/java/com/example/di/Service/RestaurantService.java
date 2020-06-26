package com.example.di.Service;

import com.example.di.VO.ResponseVO;

public interface RestaurantService {
    public ResponseVO getDailySale();

    public ResponseVO getWeeklySale();
}
