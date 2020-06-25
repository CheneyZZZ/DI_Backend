package com.example.di.PO;

import org.apache.hadoop.yarn.webapp.hamlet.HamletSpec;

import java.util.Date;

public class DailySale {
    private Date date;
    private int num;

    public DailySale(){}
    public DailySale(Date date, int num){
        this.date=date;
        this.num=num;
    }
    public void setDate(Date date){this.date=date;}
    public void setNum(int num){this.num=num;}
    public Date getDate(){return date;}
    public int getNum(){return num;}
}
