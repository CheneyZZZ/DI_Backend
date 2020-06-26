package com.example.di.ServiceImpl;

import com.example.di.Dao.OrderMapper;
import com.example.di.Dao.RestaurantMapper;
import com.example.di.PO.DailyRestaurant;
import com.example.di.PO.Restaurant;
import com.example.di.PO.TakeoutOrder;
import com.example.di.Service.RestaurantService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jdo.annotations.Order;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;
    private OrderMapper orderMapper;

    @Override
    public ResponseVO getDailySale(){
        try{
            Map<Date,List<DailyRestaurant>> map=new HashMap<Date, List<DailyRestaurant>>();
            List<TakeoutOrder> takeoutOrders=orderMapper.getTakeoutOrders();
            for(int i=0;i<takeoutOrders.size();i++){
                Date tempDate=takeoutOrders.get(i).getCreate_time();
                if(!map.containsKey(tempDate)){

                    DailyRestaurant dailyRestaurant=new DailyRestaurant();

                }
            }
        }catch (Exception e){
            return ResponseVO.buildFailure("返回商家每日销量失败");
        }
        return null;
    }

    @Override
    public ResponseVO getWeeklySale(){
        try{

        }catch (Exception e){
            return ResponseVO.buildFailure("返回商家每周销量失败");
        }
        return null;
    }
}
