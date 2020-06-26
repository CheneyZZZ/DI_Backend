package com.example.di.Controller;

import com.example.di.Service.ItemService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;


    //商品销量

    @GetMapping("/getDailySales")
    public ResponseVO getDailySales(){
        return itemService.getDailySales();
    }

    @GetMapping("/getWeeklySales")
    public ResponseVO getWeeklySales(){
        return itemService.getWeeklySales();
    }
}
