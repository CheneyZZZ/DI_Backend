package com.example.di.PO;

public class DailyRestaurant {
    private Restaurant restaurant;
    private long num;
    public DailyRestaurant(){}
    public DailyRestaurant(Restaurant restaurant,long num){
        this.restaurant=restaurant;
        this.num=num;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setNum(long num) {
        this.num = num;
    }

    public long getNum() {
        return num;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
