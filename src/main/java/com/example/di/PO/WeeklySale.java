package com.example.di.PO;

import java.util.Date;

public class WeeklySale {
    private Date beginDate;
    private Date endDate;
    private int num;

    public WeeklySale(){}
    public WeeklySale(Date beginDate, Date endDate, int num){
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.num=num;
    }

    public void setBeginDate(Date beginDate){this.beginDate=beginDate;}
    public void setEndDate(Date endDate){this.endDate=endDate;}
    public void setNum(int num){this.num=num;}

    public Date getBeginDate(){return beginDate;}
    public Date getEndDate(){return endDate;}
    public int getNum(){return num;}
}
