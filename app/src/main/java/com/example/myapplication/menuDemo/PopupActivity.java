package com.example.myapplication.menuDemo;


import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.example.myapplication.R;

public class PopupActivity extends AppCompatActivity {
    private Button button;
    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        button = findViewById(R.id.popup_menu);
        constraintLayout = findViewById(R.id.popup);
        PopupMenu popupMenu = new PopupMenu(this, button);
        MenuInflater menuInflater = this.getMenuInflater();
        popupMenu.setOnMenuItemClickListener(item -> {
            switch (item.getItemId()){
                case R.id.popup_menu_blue:{
                    constraintLayout.setBackgroundColor(Color.BLUE);
                };break;
                case R.id.popup_menu_red:{
                    constraintLayout.setBackgroundColor(Color.RED);
                };break;
                default:{
                    Toast.makeText(PopupActivity.this,"没有",Toast.LENGTH_SHORT).show();
                };
            }
            return true;
        });
        menuInflater.inflate(R.menu.popup_menu,popupMenu.getMenu());
        button.setOnLongClickListener(v -> {
            popupMenu.setGravity(Gravity.CENTER_VERTICAL);
            popupMenu.show();
            return false;
        });
    }

}