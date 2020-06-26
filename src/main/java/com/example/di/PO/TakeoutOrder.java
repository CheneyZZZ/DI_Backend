package com.example.di.PO;

import java.util.Date;

public class TakeoutOrder implements Comparable<TakeoutOrder>{
    public TakeoutOrder(){}
    public TakeoutOrder(Long id,Date create_time,int type,Long price,Integer discount,Long user_id,Long restaurant_id){
        this.id=id;
        this.create_time=create_time;
        this.type=type;
        this.price=price;
        this.discount=discount;
        this.user_id=user_id;
        this.restaurant_id=restaurant_id;
    }
    private Long id;
    private Date create_time;
    private Integer type;
    private Long price;
    private Integer discount;
    private Long user_id;
    private Long restaurant_id;

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDiscount() {
        return discount;
    }

    public Long getId() {
        return id;
    }

    public Long getPrice() {
        return price;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    @Override
    public int compareTo(TakeoutOrder takeoutOrder){
        return this.create_time.compareTo(takeoutOrder.getCreate_time());
    }
}
