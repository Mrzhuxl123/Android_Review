package com.example.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class SqliteActivity extends AppCompatActivity {

    private static final String DB_NAME = "my_database.db";
    private static final int DB_VERSION = 1;
    Sqlite sqlite;
    SQLiteDatabase sqLiteDatabase;
    EditText account;
    EditText password;
    Button login;
    Button register;
    Cursor cursor;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        // 创建一个 Sqlite 对象，打开或创建数据库
        System.out.println("数据文件准备创建++++++++++++++++++++++++");
        sqlite = new Sqlite(this, DB_NAME, null, DB_VERSION);//构造方法
        sqLiteDatabase= sqlite.getReadableDatabase();//数据库将会被创建.
        System.out.println("数据文件创建完成++++++++++++++++++++++++");
        //获取控件对象
        account = findViewById(R.id.account);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        //添加登录监听事件
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateAccount(v);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRegister(v);
            }
        });
    }


    //登录验证逻辑
    private void validateAccount(View view){
        //获取用户输入数据
        String inputAccount = account.getText().toString();
        String inputPassword = password.getText().toString();
        //验证是否为空
        if (validateEmpty()){
            //查询数据库
            cursor = sqLiteDatabase.query("user_table",new String[]{"ID"},"account=? and password = ?",new String[]{inputAccount,inputPassword},null,null,null);
            if(cursor.getCount()>0){
                AlertDialog alertDialog = new AlertDialog.Builder(SqliteActivity.this)
                        .setTitle("提示")
                        .setMessage("登录成功")
                        .setPositiveButton("确认", null)
                        .create();
                alertDialog.show();
            }else {
                AlertDialog alertDialog = new AlertDialog.Builder(SqliteActivity.this)
                        .setTitle("提示")
                        .setMessage("登录失败")
                        .setPositiveButton("确认", null)
                        .create();
                alertDialog.show();
            }
        }


    }
    //注册逻辑
    private void setRegister(View view){
        //获取用户输入数据
        String inputAccount = account.getText().toString();
        String inputPassword = password.getText().toString();
        //验证是否为空
        if(validateEmpty()){
            //插入到user_table表中
            ContentValues values = new ContentValues();
            values.put("account", inputAccount);
            values.put("password", inputPassword);
            if (sqLiteDatabase.insert("user_table", null, values)!=-1){
                AlertDialog alertDialog = new AlertDialog.Builder(SqliteActivity.this)
                        .setTitle("提示")
                        .setMessage("注册成功")
                        .setPositiveButton("确认", null)
                        .create();
                alertDialog.show();
            }
        }


    }
    //验证是否为空
    private boolean validateEmpty(){
        String inputAccount = account.getText().toString();
        String inputPassword = password.getText().toString();
        if(TextUtils.isEmpty(inputAccount)||TextUtils.isEmpty(inputPassword)){
            AlertDialog alertDialog = new AlertDialog.Builder(SqliteActivity.this)
                    .setTitle("提示")
                    .setMessage("不能为空")
                    .setPositiveButton("确认", null)
                    .create();
            alertDialog.show();
            return false;
        }else {
            return true;
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        // 关闭数据库连接
//        if (sqlite != null) {
//            sqlite.close();
//        }
    }
}
