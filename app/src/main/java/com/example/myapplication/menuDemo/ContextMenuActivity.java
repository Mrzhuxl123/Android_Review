package com.example.myapplication.menuDemo;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

public class ContextMenuActivity extends AppCompatActivity {
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        button = findViewById(R.id.context_menu);
        registerForContextMenu(button);
        button.setOnClickListener((View::showContextMenu));
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.red:{
                Toast.makeText(this, "你选择红色", Toast.LENGTH_SHORT).show();
            };break;
            case R.id.blue:{
                Toast.makeText(this,"你选择了蓝色",Toast.LENGTH_SHORT).show();
            };break;
            default:{
                Toast.makeText(this,"没有选择",Toast.LENGTH_SHORT).show();
            }
        }
        return super.onContextItemSelected(item);
    }
}
