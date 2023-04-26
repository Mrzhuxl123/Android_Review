package com.example.myapplication.none;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.myapplication.R;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner2;
    private String[] data;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spanner);
        spinner = findViewById(R.id.my_spinner);
        spinner2 = findViewById(R.id.my_spinner2);
        data = this.getResources().getStringArray(R.array.my_subject);
        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,//数据项布局
                data);
        spinner2.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SpinnerActivity.this,data[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}