package com.example.myapplication;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class Myapplication extends Application {
    private Map<String,Object> my_data;
    public Myapplication(){
        my_data = new HashMap<String,Object>();
    }

    public Map<String, Object> getMy_data() {
        return my_data;
    }

    public void setMy_data(Map<String, Object> my_data) {
        this.my_data = my_data;
    }
}
