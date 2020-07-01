package com.example.di.ServiceImpl;

import com.example.di.Dao.OrderMapper;
import com.example.di.Dao.RestaurantMapper;
import com.example.di.PO.DailyRestaurant;
import com.example.di.PO.Restaurant;
import com.example.di.PO.TakeoutOrder;
import com.example.di.PO.WeeklyRestaurant;
import com.example.di.Service.RestaurantService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public ResponseVO getDailySale(){
        try{
            LinkedHashMap<String,Map<Long,DailyRestaurant>> map=new LinkedHashMap<>();//返回结果
            Map<Long,Restaurant> restaurantMap=restaurantMapper.getAllResaurants();
            List<TakeoutOrder> takeoutOrders=orderMapper.getTakeoutOrders();
            for(int i=0;i<takeoutOrders.size();i++){//遍历订单
                String tempDate=takeoutOrders.get(i).getCreate_time().toString().substring(0,10);//当前订单date
                if(!map.containsKey(tempDate) && takeoutOrders.get(i).getRestaurant_id()!=null ){
                    Restaurant restaurant=restaurantMap.get(takeoutOrders.get(i).getRestaurant_id());
                    DailyRestaurant dailyRestaurant=new DailyRestaurant(restaurant,1);
                    Map<Long,DailyRestaurant> dailyRestaurants=new HashMap<Long,DailyRestaurant>();
                    dailyRestaurants.put(takeoutOrders.get(i).getRestaurant_id(),dailyRestaurant);
                    map.put(tempDate,dailyRestaurants);
                }else{
                    if(takeoutOrders.get(i).getRestaurant_id()!=null && !map.get(tempDate).containsKey(takeoutOrders.get(i).getRestaurant_id())){
                        Restaurant restaurant=restaurantMap.get(takeoutOrders.get(i).getRestaurant_id());
                        DailyRestaurant dailyRestaurant=new DailyRestaurant(restaurant,1);
                        map.get(tempDate).put(takeoutOrders.get(i).getRestaurant_id(),dailyRestaurant);
                    }else if(takeoutOrders.get(i).getRestaurant_id()!=null && map.get(tempDate).containsKey(takeoutOrders.get(i).getRestaurant_id())){
                        long tempNum=map.get(tempDate).get(takeoutOrders.get(i).getRestaurant_id()).getNum()+1;
                        DailyRestaurant dailyRestaurant=map.get(tempDate).get(takeoutOrders.get(i).getRestaurant_id());
                        dailyRestaurant.setNum(tempNum);
                        map.get(tempDate).put(takeoutOrders.get(i).getRestaurant_id(),dailyRestaurant);
                    }
                }
            }
            return ResponseVO.buildSuccess(map);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseVO.buildFailure("返回商家每日销量失败");
        }
    }

    @Override
    public ResponseVO getWeeklySale(){
        try{
            LinkedHashMap<Date,Map<Long,WeeklyRestaurant>> weeklyMap=new LinkedHashMap<>();
            Map<Date,Map<Long,DailyRestaurant>> map=new HashMap<Date, Map<Long,DailyRestaurant>>();
            Map<Long,Restaurant> restaurantMap=restaurantMapper.getAllResaurants();
            List<TakeoutOrder> takeoutOrders=orderMapper.getTakeoutOrders();
            Date beginDate=takeoutOrders.get(0).getCreate_time();
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(beginDate);
            calendar.add(Calendar.WEEK_OF_MONTH, 1);
            Date endDate=calendar.getTime();
            for(TakeoutOrder takeoutOrder:takeoutOrders){
                if(takeoutOrder.getCreate_time().compareTo(endDate)>0){
                    beginDate=endDate;
                    calendar = new GregorianCalendar();
                    calendar.setTime(beginDate);
                    calendar.add(Calendar.WEEK_OF_MONTH, 1);
                    endDate=calendar.getTime();
                }else{
                    if(!weeklyMap.containsKey(beginDate)&&takeoutOrder.getRestaurant_id()!=null){
                        Restaurant restaurant=restaurantMap.get(takeoutOrder.getRestaurant_id());
                        WeeklyRestaurant weeklyRestaurant=new WeeklyRestaurant(restaurant,1);
                        Map<Long,WeeklyRestaurant> weeklyRestaurants=new HashMap<Long, WeeklyRestaurant>();
                        weeklyRestaurants.put(takeoutOrder.getRestaurant_id(),weeklyRestaurant);
                        weeklyMap.put(beginDate,weeklyRestaurants);
                    }
                    else{
                        if(takeoutOrder.getRestaurant_id()!=null&&!weeklyMap.get(beginDate).containsKey(takeoutOrder.getRestaurant_id())){
                            Restaurant restaurant=restaurantMap.get(takeoutOrder.getRestaurant_id());
                            WeeklyRestaurant weeklyRestaurant=new WeeklyRestaurant(restaurant,1);
                            weeklyMap.get(beginDate).put(takeoutOrder.getRestaurant_id(),weeklyRestaurant);
                        }
                        else if(takeoutOrder.getRestaurant_id()!=null&&weeklyMap.get(beginDate).containsKey(takeoutOrder.getRestaurant_id())){
                            long tempNum=weeklyMap.get(beginDate).get(takeoutOrder.getRestaurant_id()).getNum()+1;
                            WeeklyRestaurant weeklyRestaurant=weeklyMap.get(beginDate).get(takeoutOrder.getRestaurant_id());
                            weeklyRestaurant.setNum(tempNum);
                            weeklyMap.get(beginDate).put(takeoutOrder.getRestaurant_id(),weeklyRestaurant);
                        }
                    }
                }
            }
            return ResponseVO.buildSuccess(weeklyMap);
        }catch (Exception e){
            return ResponseVO.buildFailure("返回商家每周销量失败");
        }
    }
}
