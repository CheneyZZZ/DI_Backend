package com.example.di.PO;

public class WeeklyRestaurant {
    private Restaurant restaurant;
    private long num;
    public WeeklyRestaurant(){}
    public WeeklyRestaurant(Restaurant restaurant,long num){
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
