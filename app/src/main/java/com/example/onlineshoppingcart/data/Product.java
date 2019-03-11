package com.example.onlineshoppingcart.data;

public class Product {

    private String api_key;
    private String user_id;
    private String id;
    private String cid;
    private String scid;

    public Product(String api_key, String id) {
        this.api_key = api_key;
        this.id = id;
    }

    public Product(String id, String api_key, String user_id) {
        this.id = id;
        this.api_key = api_key;
        this.user_id = user_id;
    }

    public Product(String cid, String scid, String api_key, String user_id) {
        this.cid = cid;
        this.scid = scid;
        this.api_key = api_key;
        this.user_id = user_id;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }
}
