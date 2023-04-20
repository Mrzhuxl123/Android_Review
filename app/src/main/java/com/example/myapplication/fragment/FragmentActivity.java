package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.myapplication.R;


public class FragmentActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button button;
    Myfragment my_fragment1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.myfragment);

        fragmentManager=this.getSupportFragmentManager();

        button = findViewById(R.id.my_add);

        my_fragment1 = new Myfragment();

        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.my_fragment1,new Myfragment());

        fragmentTransaction.commit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager supportFragmentManager = FragmentActivity.this.getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = supportFragmentManager.beginTransaction();
                fragmentTransaction2.remove(my_fragment1);
                fragmentTransaction2.add(R.id.my_fragment1,new Myfragment());
                fragmentTransaction2.commit();
//                fragmentTransaction.hide(my_fragment1);
//                fragmentTransaction.commit();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main,menu);
//        return true;
//    }
}
