package com.example.di.PO;

public class UserActionRatio {
    private int user_id;
    private  int gender;
    private double view_cart;
    private double view_buy;
    private double cart_buy;

    public UserActionRatio(){}
    public UserActionRatio(int user_id,int gender,double view_cart,double view_buy,double cart_buy){
        this.user_id=user_id;
        this.gender=gender;
        this.view_cart=view_cart;
        this.view_buy=view_buy;
        this.cart_buy=cart_buy;
    }
    public void setUser_id(int user_id){this.user_id=user_id;}
    public void setGender(int gender){this.gender=gender;}
    public void setView_cart(int view_cart){this.view_cart=view_cart;}
    public void setView_buy(int view_buy){this.view_buy=view_buy;}
    public void setCart_buy(double cart_buy) {
        this.cart_buy = cart_buy;
    }

    public int getUser_id() {
        return user_id;
    }
    public int getGender() {
        return gender;
    }

    public double getCart_buy() {
        return cart_buy;
    }

    public double getView_buy() {
        return view_buy;
    }

    public double getView_cart() {
        return view_cart;
    }
}
