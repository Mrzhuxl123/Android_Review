package com.example.myapplication;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Myapplication application = (Myapplication) getApplication();
        Map<String, Object> my_data = application.getMy_data();
        Button button = findViewById(R.id.button2);
        button.setText(my_data.get("name").toString());
    }

    public boolean saveDataToSharedPreferences(String fileName, String userName, int userPswd) {
        boolean isSaveDataSuccess = false;
        SharedPreferences sharedPreferences = this.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();    //创建SharedPreferences.Editor对象
        edit.putString("userName", userName);        //存储数据
        edit.putInt("userPswd", userPswd);
        isSaveDataSuccess = edit.commit();           //提交存储数据
        return isSaveDataSuccess;
    }
}
