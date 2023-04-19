package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

public class Myfragment extends Fragment {
    View my_view;
    public Myfragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
        my_view=inflater.inflate(R.layout.myfragment2,container,false);
        return my_view;
        //return super.onCreateView(inflater, container, savedInstanceState);
    }
}
