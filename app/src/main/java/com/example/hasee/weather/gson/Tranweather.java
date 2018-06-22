package com.example.hasee.weather.gson;

import com.google.gson.annotations.SerializedName;

public class Tranweather {

    public String status;

    public Tranweather.basic basic;

    public class basic {

        @SerializedName("cid")
        public String weatherId;

        @SerializedName("location")
        public String cityName;

    }
}