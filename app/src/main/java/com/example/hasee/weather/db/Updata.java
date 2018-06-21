package com.example.hasee.weather.db;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Updata extends DataSupport {
    private int xiaoshi;
    private int fenzhong;
    private int haomiao;

    public int getXiaoshi() {
        return xiaoshi;
    }

    public void setXiaoshi(int xiaoshi) {
        this.xiaoshi = xiaoshi;
    }

    public int getFenzhong() {
        return fenzhong;
    }

    public void setFenzhong(int fenzhong) {
        this.fenzhong = fenzhong;
    }

    public int getHaomiao() {
        return haomiao;
    }

    public void setHaomiao(int haomiao) {
        this.haomiao = haomiao;
    }
}
