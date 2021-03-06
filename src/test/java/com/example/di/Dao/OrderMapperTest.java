package com.example.di.Dao;

import com.example.di.PO.DailyMoney;
import com.example.di.PO.DailyQuantity;
import com.example.di.PO.TakeoutOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderMapperTest {
    @Autowired
    OrderMapper orderMapper;
    @Test
    public void getDailyQuentityTest() {
        List<DailyQuantity> dailyQuantities=orderMapper.getDailyQuentity();
        //System.out.println("quenty:"+dailyQuantities.size());
        Assert.assertEquals(171,dailyQuantities.size());
//        for(DailyQuantity dailyQuantity:dailyQuantities){
//            System.out.println(dailyQuantity.getDate()+" "+dailyQuantity.getNum());
//        }
    }

    @Test
    public void getDailMoneyTest() {
        List<DailyMoney> dailyMonies=orderMapper.getDailyMoney();
        //System.out.println("money:"+dailyMonies.size());
        Assert.assertEquals(171,dailyMonies.size());
//        for(DailyMoney dailyMoney:dailyMonies){
//            System.out.println(dailyMoney.getDate()+" "+dailyMoney.getAmount());
//        }
    }

    @Test
    public void getTakeoutOrdersTest() {
        List<TakeoutOrder> takeoutOrders=orderMapper.getTakeoutOrders();
        //System.out.println("takeout:"+takeoutOrders.size());
        Assert.assertEquals(2501,takeoutOrders.size());
//        for(TakeoutOrder takeoutOrder:takeoutOrders){
//            System.out.println(takeoutOrder.getCreate_time());
//        }
    }
}
