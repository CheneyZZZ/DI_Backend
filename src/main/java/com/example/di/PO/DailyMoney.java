package com.example.di.PO;

import java.util.Date;

public class DailyMoney implements Comparable<DailyMoney>{
    private Date date;
    private double amount;

    public DailyMoney(){}
    public DailyMoney(Date date, double amount){
        this.date=date;
        this.amount=amount;
    }
    public void setDate(Date date){this.date=date;}
    public void setAmount(int num){this.amount=amount;}
    public Date getDate(){return date;}
    public double getAmount() {
        return amount;
    }

    @Override
    public int compareTo(DailyMoney dailyMoney){
        return this.date.compareTo(dailyMoney.getDate());
    }
}
