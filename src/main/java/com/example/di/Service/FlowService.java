package com.example.di.Service;

import com.example.di.VO.ResponseVO;

public interface FlowService {
    public ResponseVO getUserActive();

    public ResponseVO getActiveEvent();

    public ResponseVO getEventRatio();
}
