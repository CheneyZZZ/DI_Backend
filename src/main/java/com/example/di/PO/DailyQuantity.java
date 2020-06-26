package com.example.di.PO;

import java.util.Date;

public class DailyQuantity implements Comparable<DailyQuantity>{
    private Date date;
    private Long num;

    public DailyQuantity(){}
    public DailyQuantity(Date date, Long num){
        this.date=date;
        this.num=num;
    }
    public void setDate(Date date){this.date=date;}
    public void setNum(Long num){this.num=num;}
    public Date getDate(){return date;}
    public Long getNum(){return num;}

    @Override
    public int compareTo(DailyQuantity dailyQuantity){
        return this.date.compareTo(dailyQuantity.getDate());
    }
}
