package com.example.di.PO;

import java.util.Date;

public class WeeklySale {
    private Date beginDate;
    private Date endDate;
    private Long num;

    public WeeklySale(){}
    public WeeklySale(Date beginDate, Date endDate, Long num){
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.num=num;
    }

    public void setBeginDate(Date beginDate){this.beginDate=beginDate;}
    public void setEndDate(Date endDate){this.endDate=endDate;}
    public void setNum(Long num){this.num=num;}

    public Date getBeginDate(){return beginDate;}
    public Date getEndDate(){return endDate;}
    public Long getNum(){return num;}
}
