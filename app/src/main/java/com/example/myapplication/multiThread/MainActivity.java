package com.example.myapplication.multiThread;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler;
    public void getViews(){
        textView = findViewById(R.id.my_text_view);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //谁创建谁修改，子线程不能修改UI控件。
        getViews();
        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.what % 2 == 0){
                            //修改为绿色
                            textView.setText("修改为绿色");
                            textView.setBackgroundColor(Color.GREEN);
                }else {
                            //修改为红色
                            textView.setText("修改为红色");
                            textView.setBackgroundColor(Color.RED);
                };



            }
        };
        new myThread().start();

    }

    private class myThread extends Thread{
        @Override
        public void run() {
            int i = 1;
            while (true){
                handler.sendEmptyMessage(i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        }
    }

}