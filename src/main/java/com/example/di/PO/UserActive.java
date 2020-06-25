package com.example.di.PO;

import java.util.Date;

public class UserActive {
    private Date date;
    private int num;

    public UserActive(){}
    public UserActive(Date date, int num){
        this.date=date;
        this.num=num;
    }
    public void setDate(Date date){this.date=date;}
    public void setNum(int num){this.num=num;}
    public Date getDate(){return date;}
    public int getNum(){return num;}
}
