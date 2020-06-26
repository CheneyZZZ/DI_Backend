package com.example.di.Controller;

import com.example.di.Service.RestaurantService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/getDailySale")
    public ResponseVO getDailySale(){
        return restaurantService.getDailySale();
    }

    @GetMapping("/getWeeklySale")
    public ResponseVO getWeeklySale(){
        return restaurantService.getWeeklySale();
    }
}
