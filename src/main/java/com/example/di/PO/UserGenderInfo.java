package com.example.di.PO;

public class UserGenderInfo {
    private int shop_identity_card_type;
    private String shop_identity_cart_no;
    private int shop_gender;

    public UserGenderInfo(){}
    public UserGenderInfo(int shop_identity_card_type,
                String shop_identity_cart_no,int shop_gender){
        this.shop_identity_card_type=shop_identity_card_type;
        this.shop_identity_cart_no=shop_identity_cart_no;
        this.shop_gender=shop_gender;
    }

    public void setShop_identity_card_type(int shop_identity_card_type){this.shop_identity_card_type=shop_identity_card_type;}
    public void setShop_identity_cart_no(String shop_identity_cart_no){this.shop_identity_cart_no=shop_identity_cart_no;}
    public void setShop_gender(int shop_gender){this.shop_gender=shop_gender;}

    public int getShop_identity_card_type(){return shop_identity_card_type;}
    public String getShop_identity_cart_no(){return shop_identity_cart_no;}
    public int getShop_gender(){return shop_gender;}
}
