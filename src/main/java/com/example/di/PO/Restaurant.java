package com.example.di.PO;

public class Restaurant {
    private Long id;
    private String name;
    private String location;
    private String tel;

    public Restaurant(){}
    public Restaurant(Long id,String name,String location,String tel){
        this.id=id;
        this.name=name;
        this.location=location;
        this.tel=tel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public String getTel() {
        return tel;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
