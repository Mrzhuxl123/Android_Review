package com.example.myapplication.menuDemo;


import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class PopupActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        button = findViewById(R.id.popup_menu);
        PopupMenu popupMenu = new PopupMenu(this, button);
        MenuInflater menuInflater = this.getMenuInflater();
        menuInflater.inflate(R.menu.popup_menu,popupMenu.getMenu());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupMenu.show();
            }
        });
    }

}