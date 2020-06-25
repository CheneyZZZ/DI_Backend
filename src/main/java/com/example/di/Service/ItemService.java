package com.example.di.Service;

import com.example.di.VO.ResponseVO;

import java.net.ResponseCache;

public interface ItemService {
    public ResponseVO getDailySales();

    public ResponseVO getWeeklySales();
}
