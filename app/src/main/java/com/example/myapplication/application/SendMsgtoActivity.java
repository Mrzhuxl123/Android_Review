package com.example.myapplication.application;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

import java.util.Map;

public class SendMsgtoActivity extends AppCompatActivity {

    private Myapplication myapplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmsg);
        Button button = findViewById(R.id.button);
        myapplication = (Myapplication) getApplication();
        User user = new User("朱秀龙", 23);
        Map<String, Object> my_data = myapplication.getMy_data();
        my_data.put("name",user);

        myapplication.setMy_data(my_data);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSecondActivity();
            }
        });

    }

    private void goToSecondActivity(){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}