package com.example.di.Controller;

import com.example.di.Service.FlowService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flow")
public class FlowController {
    @Autowired
    private FlowService flowService;

    @GetMapping("/getUserActive")
    public ResponseVO getUserActive(){
        return flowService.getUserActive();
    }
    @GetMapping("/getActiveEvent")
    public ResponseVO getActiveEvent(){
        return flowService.getActiveEvent();
    }
    @GetMapping("/getEventRatio")
    public ResponseVO getEventRatio(){
        return flowService.getEventRatio();
    }
}
