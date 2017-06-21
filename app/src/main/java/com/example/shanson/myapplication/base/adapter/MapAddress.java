package com.example.shanson.myapplication.base.adapter;

/**
 * Created by Administrator on 2017/6/18.
 */

public class MapAddress {
    public static String name;
    public static String address;
    public static int image_map;

    public static int getImage_map() {
        return image_map;
    }

    public void setImage_map(int image_map) {
        this.image_map = image_map;
    }

    public static String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
