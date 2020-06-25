package com.example.di.PO;

public class Item {
    private int id;
    private String name;
    private String item_spec;
    private double price;
    private double cost;
    private int status;

    public Item(){}
    public Item(int id,String name,String item_spec,double price,double cost,int status){
        this.id=id;
        this.name=name;
        this.item_spec=item_spec;
        this.price=price;
        this.cost=cost;
        this.status=status;
    }
    public void setId(int id){this.id=id;}
    public void setName(String name){ this.name=name;}
    public void setItem_spec(String item_spec){this.item_spec=item_spec;}
    public void setPrice(double price){this.price=price;}
    public void setCost(double cost){this.cost=cost;}
    public void setStatus(int status){this.status=status;}

    public int getId(){return id;}
    public String getName(){return name;}
    public String getItem_spec(){return item_spec;}
    public double getPrice(){return price;}
    public double getCost(){return cost;}
    public int getStatus(){return status;}
}
