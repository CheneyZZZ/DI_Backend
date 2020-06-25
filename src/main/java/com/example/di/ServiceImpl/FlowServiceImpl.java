package com.example.di.ServiceImpl;

import com.example.di.Dao.FlowMapper;
import com.example.di.PO.ActiveEvent;
import com.example.di.PO.UserActionRatio;
import com.example.di.PO.UserActive;
import com.example.di.Service.FlowService;
import com.example.di.VO.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowServiceImpl implements FlowService {
    @Autowired
    private FlowMapper flowMapper;

    @Override
    public ResponseVO getUserActive(){
        try{
            List<UserActive> userActives=flowMapper.getUserActive();
            return ResponseVO.buildSuccess(userActives);
        }catch (Exception e){
            return ResponseVO.buildFailure("获取用户活跃表失败");
        }
    }

    @Override
    public ResponseVO getActiveEvent(){
        try{
            List<ActiveEvent> activeEvents=flowMapper.getActiveEvent();
            return ResponseVO.buildSuccess(activeEvents);
        }catch (Exception e){
            return ResponseVO.buildFailure("获取活跃事件表失败");
        }
    }

    @Override
    public ResponseVO getEventRatio(){
        try{
            List<UserActionRatio> userActionRatios=flowMapper.getUserActionRatio();
            return ResponseVO.buildSuccess(userActionRatios);
        }catch (Exception e){
            return ResponseVO.buildFailure("获取用户行为比率表失败");
        }
    }
}
