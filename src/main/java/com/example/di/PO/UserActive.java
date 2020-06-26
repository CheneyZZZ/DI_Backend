package com.example.di.PO;

import java.util.Date;

public class UserActive implements Comparable<UserActive>{
    private Date date;
    private Long num;

    public UserActive(){}
    public UserActive(Date date, Long num){
        this.date=date;
        this.num=num;
    }
    public void setDate(Date date){this.date=date;}
    public void setNum(Long num){this.num=num;}
    public Date getDate(){return date;}
    public Long getNum(){return num;}

    @Override
    public int compareTo(UserActive userActive){
        return this.date.compareTo(userActive.getDate());
    }
}
