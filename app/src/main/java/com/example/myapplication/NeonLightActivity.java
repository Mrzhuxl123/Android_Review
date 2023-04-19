package com.example.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class NeonLightActivity extends AppCompatActivity {

    private int[] textViewIdList = {R.id.text1,R.id.text2,R.id.text3,R.id.text4};
    private TextView[] textViewList = new TextView[textViewIdList.length];
    private int[] color = {Color.RED,Color.MAGENTA,Color.GREEN,Color.YELLOW};
    private Handler handler;
    private int current=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neonlight);
        for (int i = 0; i < textViewIdList.length; i++) {
            textViewList[i] = findViewById(textViewIdList[i]);
        }
        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what==0x001){
                    for (int i = 0; i < textViewIdList.length; i++) {
                        textViewList[i].setBackgroundColor(color[(i+current)%color.length]);
                    }
                }
                current=(current+1)%color.length;
            }
        };
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x001);
            }
        },0,1000);
    }
}
