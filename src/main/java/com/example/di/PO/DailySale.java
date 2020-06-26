package com.example.di.PO;


import java.util.Date;

public class DailySale implements Comparable<DailySale>{
    private Date date;
    private Long num;

    public DailySale(){}
    public DailySale(Date date, Long num){
        this.date=date;
        this.num=num;
    }
    public void setDate(Date date){this.date=date;}
    public void setNum(Long num){this.num=num;}
    public Date getDate(){return date;}
    public Long getNum(){return num;}

    @Override
    public int compareTo(DailySale dailySale){
        return this.date.compareTo(dailySale.getDate());
    }
}
