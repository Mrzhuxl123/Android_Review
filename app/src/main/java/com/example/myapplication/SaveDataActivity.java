package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SaveDataActivity extends AppCompatActivity {
    private Button button;

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor = null;

    private Integer[] myEditText = new Integer[]{
        R.id.name, R.id.score, R.id.age,
    };

    private EditText[] editTexts = new EditText[3];

    private RadioButton men;

    private RadioButton woman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savedata);

        sharedPreferences = this.getSharedPreferences("my_info",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        for (int i = 0; i < editTexts.length; i++) {
            editTexts[i] = findViewById(myEditText[i]);
        }
        button = findViewById(R.id.saveButton);
        men = findViewById(R.id.men);
        woman = findViewById(R.id.woman);

        button.setOnClickListener(v -> {
            editor.putString("name", String.valueOf(editTexts[0].getText()));
            editor.putFloat("score", Float.parseFloat(String.valueOf(editTexts[1].getText())));
            editor.putInt("age", Integer.parseInt(String.valueOf(editTexts[2].getText())));
            if (men.isChecked()){
                editor.putString("sex", (String) men.getText());
            }else {
                editor.putString("sex", (String) woman.getText());
            }
            boolean commit = editor.commit();
            if (commit){
                AlertDialog alertDialog = new AlertDialog.Builder(SaveDataActivity.this)
                        .setTitle("title")
                        .setMessage("保存成功")
                        .setPositiveButton("确认", null)
                        .create();
                        alertDialog.show();
            }else{
                AlertDialog alertDialog = new AlertDialog.Builder(SaveDataActivity.this)
                        .setTitle("title")
                        .setMessage("保存失败")
                        .setPositiveButton("确认", null)
                        .create();
                alertDialog.show();
            }
        });
    }
}
