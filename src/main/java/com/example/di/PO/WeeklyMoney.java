package com.example.di.PO;

import java.util.Date;

public class WeeklyMoney {
    private Date beginDate;
    private Date endDate;
    private double amount;

    public WeeklyMoney(){}
    public WeeklyMoney(Date beginDate, Date endDate,double amount){
        this.beginDate=beginDate;
        this.endDate=endDate;
        this.amount=amount;
    }

    public void setBeginDate(Date beginDate){this.beginDate=beginDate;}
    public void setEndDate(Date endDate){this.endDate=endDate;}
    public void setAmount(double amount){this.amount=amount;}

    public Date getBeginDate(){return beginDate;}
    public Date getEndDate(){return endDate;}
    public double getAmount() {
        return amount;
    }
}
