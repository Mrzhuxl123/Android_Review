package com.example.myapplication.application;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

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
}
