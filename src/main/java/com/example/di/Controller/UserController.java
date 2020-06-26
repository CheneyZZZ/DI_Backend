package com.example.di.Controller;

import com.example.di.Service.UserService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getGenderRatio")
    public ResponseVO getGenderRatio(){
        return userService.getGenderRatio();
    }

    @GetMapping("/getRegionList")
    public ResponseVO getRegionList(){
        return userService.getRegionList();
    }
}
