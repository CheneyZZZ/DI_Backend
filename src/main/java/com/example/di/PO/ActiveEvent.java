package com.example.di.PO;

import java.util.Date;

public class ActiveEvent {
    private Date date;
    private Long total;
    private Long view;
    private Long cart;
    private Long buy;

    public ActiveEvent(){}
    public ActiveEvent(Date date,Long total,Long view,Long cart,Long buy){
        this.date=date;
        this.total=total;
        this.view=view;
        this.cart=cart;
        this.buy=buy;
    }
    public void setDate(Date date){this.date=date;}
    public void setTotal(Long total){this.total=total;}
    public void setView(Long view){this.view=view;}
    public void setCart(Long cart){this.cart=cart;}
    public void setBuy(Long buy){this.buy=buy;}

    public Date getDate(){return date;}
    public Long getTotal(){return total;}
    public Long getView(){return view;}
    public Long getCart(){return cart;}
    public Long getBuy(){return buy;}
}
