package com.haobi.News;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class LoginActivity extends Activity  {
    private DataBaseHelper mDataBaseHelper;
    private EditText username;
    private EditText password;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mDataBaseHelper=new DataBaseHelper(this);
        username=(EditText) findViewById(R.id.et_zh);
        password=(EditText) findViewById(R.id.et_mima);
        loginbtn=(Button)  findViewById(R.id.btn_login);
        loginbtn.setOnClickListener(new View.OnClickListener() {
            String name,psw;
            @Override
            public void onClick(View view) {
                name = username.getText().toString().trim();
                psw = password.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(psw)) {
                    int data = mDataBaseHelper.login();
                    boolean match = false;

                    if (data!=0) {
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(intent);
                        finish();//销毁此Activity
                    }else {
                        Toast.makeText(LoginActivity.this,"用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void toRegist(View view){
        //Toast.makeText(LoginActivity.this,"okkkkkkk",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(LoginActivity.this,RegistActivity.class);
        startActivity(intent);
    }


}
