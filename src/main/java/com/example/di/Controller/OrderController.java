package com.example.di.Controller;

import com.example.di.Service.OrderService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getDailySales")
    public ResponseVO getDailySales(){
        return orderService.getDailySales();
    }

    @GetMapping("/getWeeklySales")
    public ResponseVO getWeeklySales(){
        return orderService.getWeeklySales();
    }

    @GetMapping("/getDailyMoney")
    public ResponseVO getDailyMoney(){
        return orderService.getDailyMoney();
    }

    @GetMapping("/getWeeklyMoney")
    public ResponseVO getWeeklyMoney(){
        return orderService.getWeeklyMoney();
    }

}
