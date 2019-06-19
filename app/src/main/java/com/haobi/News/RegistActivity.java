package com.haobi.News;



import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class RegistActivity extends AppCompatActivity   {
    private EditText username;
    private EditText password;
    private Button mbutton;
    private DataBaseHelper dataBaseHelper;
    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regist);
        dataBaseHelper=new DataBaseHelper(this);
        username=(EditText) findViewById(R.id.et_number);
        password=(EditText) findViewById(R.id.et_password);
        mbutton=(Button)findViewById(R.id.btn_regist);

        mbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=username.getText().toString().trim();
                String psw=password.getText().toString().trim();
                if(!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(psw)){
                    dataBaseHelper.regist(name,psw);
                    Intent intent=new Intent(RegistActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                }
            }
        });

    }


}