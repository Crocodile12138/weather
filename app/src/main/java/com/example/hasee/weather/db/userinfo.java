package com.example.hasee.weather.db;

import org.litepal.crud.DataSupport;

public class userinfo extends DataSupport {
    private String name;
    private String password;
    private String state;
    private String position;
   /* private byte[] head;

    public userinfo(byte[] head) {
        super();
        this.head = head;
    }

    public byte[] getHead() {
        return head;
    }

    public void setHead(byte[] head) {
        this.head = head;
    }*/
   public userinfo(String position) {
       this.position = position;
   }

   public String getPosition() {
       return position;
   }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
