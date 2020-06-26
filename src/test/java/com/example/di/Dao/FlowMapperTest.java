package com.example.di.Dao;

import com.example.di.PO.ActiveEvent;
import com.example.di.PO.UserActionRatio;
import com.example.di.PO.UserActive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FlowMapperTest {
    @Autowired
    FlowMapper flowMapper;

    @Test
    public void getUserActiveTest(){
        List<UserActive> userActives=flowMapper.getUserActive();
        Assert.assertEquals(30,userActives.size());
    }

    @Test
    public void getActiveEventTest() {
        List<ActiveEvent> activeEvents=flowMapper.getActiveEvent();
        Assert.assertEquals(30,activeEvents.size());
    }

    @Test
    public void getUserActionRatioTest() {
        List<UserActionRatio> userActionRatios=flowMapper.getUserActionRatio();
        Assert.assertEquals(1373,userActionRatios.size());
    }
}
