package com.example.di.PO;

public class User {
    private int shop_id;
    private String shop_nickname;
    private String shop_realname;
    private int shop_identity_card_type;
    private String shop_identity_cart_no;
    private String mobile_phone;
    private String shop_customer_email;
    private int shop_gender;
    private String shop_address;
    private int takeout_id;
    private String takeout_nickname;
    private String takeout_bind_wechat;
    private String takeout_bind_alipay;
    private int takeout_gender;
    private String takeout_address;

    public User(){}
    public User(int shop_id,String shop_nickname,String shop_realname,int shop_identity_card_type,
                String shop_identity_cart_no,String mobile_phone,String shop_customer_email,int shop_gender,
                String shop_address,int takeout_id,String takeout_nickname,String takeout_bind_wechat,
                String takeout_bind_alipay,int takeout_gender,String takeout_address){
        this.shop_id=shop_id;
        this.shop_nickname=shop_nickname;
        this.shop_realname=shop_realname;
        this.shop_identity_card_type=shop_identity_card_type;
        this.shop_identity_cart_no=shop_identity_cart_no;
        this.mobile_phone=mobile_phone;
        this.shop_customer_email=shop_customer_email;
        this.shop_gender=shop_gender;
        this.shop_address=shop_address;
        this.takeout_id=takeout_id;
        this.takeout_nickname=takeout_nickname;
        this.takeout_bind_wechat=takeout_bind_wechat;
        this.takeout_bind_alipay=takeout_bind_alipay;
        this.takeout_gender=takeout_gender;
        this.takeout_address=takeout_address;
    }
    public void setShop_id(int shop_id){this.shop_id=shop_id;}
    public void setShop_nickname(String shop_nickname){this.shop_nickname=shop_nickname;}
    public void setShop_realname(String shop_realname){this.shop_realname=shop_realname;}
    public void setShop_identity_card_type(int shop_identity_card_type){this.shop_identity_card_type=shop_identity_card_type;}
    public void setShop_identity_cart_no(String shop_identity_cart_no){this.shop_identity_cart_no=shop_identity_cart_no;}
    public void setMobile_phone(String mobile_phone){this.mobile_phone=mobile_phone;}
    public void setShop_customer_email(String shop_customer_email){this.shop_customer_email=shop_customer_email;}
    public void setShop_gender(int shop_gender){this.shop_gender=shop_gender;}
    public void setShop_address(String shop_address){this.shop_address=shop_address;}
    public void setTakeout_id(int takeout_id){this.takeout_id=takeout_id;}
    public void setTakeout_nickname(String takeout_nickname){this.takeout_nickname=takeout_nickname;}
    public void setTakeout_bind_wechat(String takeout_bind_wechat){this.takeout_bind_wechat=takeout_bind_wechat;}
    public void setTakeout_bind_alipay(String takeout_bind_alipay){this.takeout_bind_alipay=takeout_bind_alipay;}
    public void setTakeout_gender(int takeout_gender){this.takeout_gender=takeout_gender;}
    public void setTakeout_address(String takeout_address){this.takeout_address=takeout_address;}
    public int getShop_id(){return shop_id;}
    public String getShop_nickname(){return shop_nickname;}
    public String getShop_realname(){return shop_realname;}
    public int getShop_identity_card_type(){return shop_identity_card_type;}
    public String getShop_identity_cart_no(){return shop_identity_cart_no;}
    public String getMobile_phone(){return mobile_phone;}
    public String getShop_customer_email(){return shop_customer_email;}
    public int getShop_gender(){return shop_gender;}
    public String getShop_address(){return shop_address;}
    public int getTakeout_id(){return takeout_id;}
    public String getTakeout_nickname(){return takeout_nickname;}
    public String getTakeout_bind_wechat(){return takeout_bind_wechat;}
    public String getTakeout_bind_alipay(){return takeout_bind_alipay;}
    public int getTakeout_gender(){return takeout_gender;}
    public String getTakeout_address(){return takeout_address;}
}
