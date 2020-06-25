package com.example.di.PO;

import java.util.Date;

public class ActiveEvent {
    private Date date;
    private int total;
    private int view;
    private int cart;
    private int buy;

    public ActiveEvent(){}
    public ActiveEvent(Date date,int total,int view,int cart,int buy){
        this.date=date;
        this.total=total;
        this.view=view;
        this.cart=cart;
        this.buy=buy;
    }
    public void setDate(Date date){this.date=date;}
    public void setTotal(int total){this.total=total;}
    public void setView(int view){this.view=view;}
    public void setCart(int cart){this.cart=cart;}
    public void setBuy(int buy){this.buy=buy;}

    public Date getDate(){return date;}
    public int getTotal(){return total;}
    public int getView(){return view;}
    public int getCart(){return cart;}
    public int getBuy(){return buy;}
}
