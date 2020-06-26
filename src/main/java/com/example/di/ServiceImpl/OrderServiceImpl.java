package com.example.di.ServiceImpl;

import com.example.di.Dao.OrderMapper;
import com.example.di.PO.*;
import com.example.di.Service.OrderService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseVO getDailySales(){
       try {
          List<DailyQuantity> dateTemp = orderMapper.getDailyQuentity();
           return ResponseVO.buildSuccess(dateTemp);
       }catch (Exception e){
           return ResponseVO.buildFailure("返回每日订单销量失败");
        }
    }

    @Override
    public ResponseVO getWeeklySales(){
       try{
            List<DailyQuantity> dateTemp = orderMapper.getDailyQuentity();
            List<WeeklySale> weeklySales=new ArrayList<>();
            int i=0;
            while(dateTemp.size()-i>6){
                WeeklySale weeklySale=new WeeklySale();
                long num=0;
                weeklySale.setBeginDate(dateTemp.get(i).getDate());
                weeklySale.setEndDate(dateTemp.get(i+6).getDate());
                for(int j=0;j<7;j++){
                    num=num+dateTemp.get(i+j).getNum();
                }
                weeklySale.setNum(num);
                weeklySales.add(weeklySale);
                i=i+7;
           }
            return ResponseVO.buildSuccess(weeklySales);
        }catch (Exception e){
           return ResponseVO.buildFailure("返回每周订单销量失败");
        }
    }

    @Override
    public ResponseVO getDailyMoney(){
        try {
            List<DailyMoney> dateTemp = orderMapper.getDailyMoney();
            return ResponseVO.buildSuccess(dateTemp);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回每日订单金额失败");
        }
    }

    @Override
    public ResponseVO getWeeklyMoney(){
        try{
            List<DailyMoney> dateTemp = orderMapper.getDailyMoney();
            List<WeeklyMoney> weeklyMonies=new ArrayList<>();
            int i=0;
            while(dateTemp.size()-i>6){
                WeeklyMoney weeklyMoney=new WeeklyMoney();
                double num=0;
                weeklyMoney.setBeginDate(dateTemp.get(i).getDate());
                weeklyMoney.setEndDate(dateTemp.get(i+6).getDate());
                for(int j=0;j<7;j++){
                    num=num+dateTemp.get(i+j).getAmount();
                }
                weeklyMoney.setAmount(num);
                weeklyMonies.add(weeklyMoney);
                i=i+7;
            }
            return ResponseVO.buildSuccess(weeklyMonies);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回每周订单金额失败");
        }
    }
}
