package com.example.di.Dao;

import com.example.di.PO.ActiveEvent;
import com.example.di.PO.UserActionRatio;
import com.example.di.PO.UserActive;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Service
public interface FlowMapper {
    public List<UserActive> getUserActive();

    public List<ActiveEvent> getActiveEvent();

    public List<UserActionRatio> getUserActionRatio();
}
